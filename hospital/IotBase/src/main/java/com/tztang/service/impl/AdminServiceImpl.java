package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.config.PwdConfig;
import com.tztang.core.RedisKeyManage;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.AdminMapper;
import com.tztang.mapper.SysApiMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.*;
import com.tztang.pojo.entity.AdminDo;
import com.tztang.pojo.vo.AdminVo;
import com.tztang.redis.RedisCache;
import com.tztang.redis.RedisKeyBuild;
import com.tztang.service.AdminService;
import com.tztang.service.UUIDService;
import com.tztang.util.TokenHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDo> implements AdminService {

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
        );
        if (ObjectUtil.isNull(adminDo)) {
            throw new DemoFrameException(BaseCode.ADMIN_NOT_EXIST);
        }
        boolean matches = pwdConfig.passwordEncoder().matches(dto.getPassword(), adminDo.getPassword());
        if (!matches) {
            throw new DemoFrameException(BaseCode.ACCOUNT_PWD_ERROR);
        }
        // 创建token
        String token = tokenService.createToken(adminDo);
        HashMap<String, Object> map = new HashMap<>();
        map.put("base_info", adminDo);
        map.put("token", token);
        redisCache.putHash(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_LOGIN, adminDo.getAccount()), map, TokenHelper.TOKEN_EXPIRATION, TimeUnit.MILLISECONDS);
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
        adminDo.setPassword(pwdConfig.passwordEncoder().encode(dto.getPassword()));
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

}
