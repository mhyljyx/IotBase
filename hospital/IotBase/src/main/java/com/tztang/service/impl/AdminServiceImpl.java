package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.config.PwdConfig;
import com.tztang.core.RedisKeyManage;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.AdminMapper;
import com.tztang.mapper.SysRoleApiMapper;
import com.tztang.mapper.SysRoleMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.*;
import com.tztang.pojo.entity.AdminDo;
import com.tztang.pojo.entity.SysRoleApiDo;
import com.tztang.pojo.vo.AdminVo;
import com.tztang.pojo.vo.SysApiVo;
import com.tztang.pojo.vo.SysMenuVo;
import com.tztang.redis.RedisCache;
import com.tztang.redis.RedisKeyBuild;
import com.tztang.service.AdminService;
import com.tztang.service.UUIDService;
import com.tztang.util.Aes;
import com.tztang.util.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDo> implements AdminService, UserDetailsService {

    @Resource
    private SysRoleApiMapper sysRoleApiMapper;

    @Resource
    private UUIDService uuidService;
    @Resource
    private TokenServiceImpl tokenService;

    @Resource
    private PwdConfig pwdConfig;
    @Resource
    private RedisCache redisCache;

    @Override
    public Map<String, Object> login(AdminLoginDto dto) {
        AdminDo adminDo = this.baseMapper.selectOne(
                Wrappers.<AdminDo>lambdaQuery()
                        .eq(AdminDo::getAccount, dto.getAccount())
                        .eq(AdminDo::getPassword, pwdConfig.passwordEncoder().encode(dto.getPassword()))
        );
        if (ObjectUtil.isNull(adminDo)) {
            throw new DemoFrameException("账号或密码错误");
        }
        // 创建token
        String token = tokenService.createToken(adminDo);
        // 查询接口权限
        List<SysRoleApiDo> sysRoleApiDos = sysRoleApiMapper.selectList(
                Wrappers.<SysRoleApiDo>lambdaQuery()
                        .eq(SysRoleApiDo::getRoleId, adminDo.getRoleId())
        );
        Set<Long> apis = sysRoleApiDos.stream().map(SysRoleApiDo::getApiId).collect(Collectors.toSet());
        HashMap<String, Object> map = new HashMap<>();
        map.put("base_info", adminDo);
        map.put("token", token);
        map.put("api_permission", apis);
        redisCache.putHash(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_LOGIN, adminDo.getAccount()), map, TokenHelper.TOKEN_EXPIRATION);
        return map;
    }

    @Override
    public void create(AdminDto dto) {
        String id = uuidService.generateUUID(new UUIDDto("A_", 18));
        AdminDo adminDo = this.baseMapper.selectOne(
                Wrappers.<AdminDo>lambdaQuery()
                        .eq(AdminDo::getAccount, dto.getAccount())
        );
        if (ObjectUtil.isNotNull(adminDo)) {
            throw new DemoFrameException(BaseCode.ADMIN_EXIST);
        }
        adminDo = new AdminDo();
        BeanUtil.copyProperties(dto, adminDo);
        adminDo.setId(id);
        adminDo.setPassword(dto.getPassword());
        this.baseMapper.insert(adminDo);
    }

    @Override
    public void delete(Set<String> ids) {
        this.baseMapper.selectBatchIds(ids);
    }

    @Override
    public void update(AdminUpdateDto dto) {
        AdminDo adminDo = this.baseMapper.selectById(dto.getId());
        if (ObjectUtil.isNull(adminDo)) {
            throw new DemoFrameException(BaseCode.ADMIN_NOT_EXIST);
        }
        BeanUtil.copyProperties(dto, adminDo);
        this.baseMapper.updateById(adminDo);
    }

    @Override
    public PageVo<AdminVo> query(AdminQueryDto dto) {
        IPage<AdminDo> iPage = this.baseMapper.selectPage(
                PageUtil.getPageParams(dto),
                Wrappers.<AdminDo>lambdaQuery()
                        .eq(StrUtil.isNotBlank(dto.getAccount()), AdminDo::getAccount, dto.getAccount())
                        .eq(StrUtil.isNotBlank(dto.getStatus()), AdminDo::getStatus, dto.getStatus())
                        .like(StrUtil.isNotBlank(dto.getName()), AdminDo::getName, dto.getName())
        );
        return PageUtil.convertPage(iPage, adminDo -> {
            AdminVo adminVo = new AdminVo();
            BeanUtil.copyProperties(adminDo, adminVo);
            return adminVo;
        });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //先从redis中获取
        Object baseInfo = redisCache.getForHash(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_LOGIN, username), username, HashMap.class).get("base_info");
        if (!(baseInfo instanceof AdminVo)) {
            throw new DemoFrameException("系统异常");
        }
        AdminVo adminVo = (AdminVo) baseInfo;
        //查询不到再去查数据库
        if (ObjectUtil.isNull(adminVo)) {
            AdminDo adminDo = this.baseMapper.selectOne(
                    Wrappers.<AdminDo>lambdaQuery()
                            .eq(AdminDo::getAccount, username)
            );
            if (ObjectUtil.isNull(adminDo)) {
                throw new UsernameNotFoundException("Admin not found: " + username);
            }
            adminVo = new AdminVo();
            BeanUtil.copyProperties(adminDo, adminVo);
        }
        HashMap map = JSON.parseObject(JSON.toJSONString(adminVo), HashMap.class);
        //存储到redis
        redisCache.putHash(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_LOGIN, adminVo.getId()), map, 1, TimeUnit.HOURS);
        //从redis中获取权限
        Set<Long> apiIds = redisCache.getForHash(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_PERMISSION, "api_permission"), String.valueOf(adminVo.getRoleId()), Set.class);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (CollUtil.isNotEmpty(apiIds)) {
            apiIds.forEach(api -> authorities.add(new SimpleGrantedAuthority("ROLE_" + api)));
        }
        return new User(adminVo.getAccount(), adminVo.getPassword(), authorities);
    }

}
