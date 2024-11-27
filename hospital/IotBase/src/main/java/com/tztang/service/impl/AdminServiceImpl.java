package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.AdminMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.AdminDto;
import com.tztang.pojo.dto.AdminQueryDto;
import com.tztang.pojo.dto.AdminUpdateDto;
import com.tztang.pojo.dto.UUIDDto;
import com.tztang.pojo.entity.AdminDo;
import com.tztang.pojo.entity.UserDo;
import com.tztang.pojo.vo.AdminVo;
import com.tztang.pojo.vo.UserVo;
import com.tztang.service.AdminService;
import com.tztang.service.UUIDService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDo> implements AdminService {

    @Resource
    private UUIDService uuidService;

    @Override
    public void create(AdminDto dto) {
        String id = uuidService.generateUUID(new UUIDDto("A_", 18));
        AdminDo adminDo = this.baseMapper.selectById(id);
        if (ObjectUtil.isNotNull(adminDo)) {
            throw new DemoFrameException(BaseCode.ADMIN_EXIST);
        }
        adminDo = new AdminDo();
        BeanUtil.copyProperties(dto, adminDo);
        adminDo.setId(id);
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
