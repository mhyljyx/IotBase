package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.core.RedisKeyManage;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.AdminMapper;
import com.tztang.mapper.UserMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.UUIDDto;
import com.tztang.pojo.dto.UserDto;
import com.tztang.pojo.dto.UserQueryDto;
import com.tztang.pojo.dto.UserUpdateDto;
import com.tztang.pojo.entity.UserDo;
import com.tztang.pojo.vo.AdminVo;
import com.tztang.pojo.vo.UserVo;
import com.tztang.redis.RedisCache;
import com.tztang.redis.RedisKeyBuild;
import com.tztang.service.UUIDService;
import com.tztang.service.UserService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {

    @Resource
    private UUIDService uuidService;

    @Override
    public void create(UserDto dto) {
        String id = uuidService.generateUUID(new UUIDDto("U_", 18));
        UserDo userDo = this.baseMapper.selectById(id);
        if (ObjectUtil.isNotNull(userDo)) {
            throw new DemoFrameException(BaseCode.USER_EXIST);
        }
        userDo = new UserDo();
        BeanUtil.copyProperties(dto, userDo);
        userDo.setId(id);
        this.baseMapper.insert(userDo);
    }

    @Override
    public void delete(Set<String> ids) {
        this.baseMapper.selectBatchIds(ids);
    }

    @Override
    public void update(UserUpdateDto dto) {
        UserDo userDo = this.baseMapper.selectById(dto.getId());
        if (ObjectUtil.isNull(userDo)) {
            throw new DemoFrameException(BaseCode.USER_NOT_EXIST);
        }
        BeanUtil.copyProperties(dto, userDo);
        this.baseMapper.updateById(userDo);
    }

    @Override
    public PageVo<UserVo> query(UserQueryDto dto) {
        IPage<UserDo> iPage = this.baseMapper.selectPage(
                PageUtil.getPageParams(dto),
                Wrappers.<UserDo>lambdaQuery()
                        .eq(StrUtil.isNotBlank(dto.getDeptId()), UserDo::getDeptId, dto.getDeptId())
                        .eq(StrUtil.isNotBlank(dto.getType()), UserDo::getType, dto.getType())
                        .eq(StrUtil.isNotBlank(dto.getStatus()), UserDo::getStatus, dto.getStatus())
                        .like(StrUtil.isNotBlank(dto.getName()), UserDo::getName, dto.getName())
        );
        return PageUtil.convertPage(iPage, userDo -> {
            UserVo userVo = new UserVo();
            BeanUtil.copyProperties(userDo, userVo);
            return userVo;
        });
    }

}
