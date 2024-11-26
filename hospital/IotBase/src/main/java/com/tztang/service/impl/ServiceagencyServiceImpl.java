package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.common.ApiResponse;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.ServiceagencyMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.ServiceagencyDto;
import com.tztang.pojo.dto.ServiceagencyQueryDto;
import com.tztang.pojo.dto.ServiceagencyUpdateDto;
import com.tztang.pojo.dto.UUIDDto;
import com.tztang.pojo.entity.ServiceagencyDo;
import com.tztang.pojo.vo.ServiceagencyVo;
import com.tztang.service.ServiceagencyService;
import com.tztang.service.UUIDService;
import com.tztang.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class ServiceagencyServiceImpl extends ServiceImpl<ServiceagencyMapper, ServiceagencyDo> implements ServiceagencyService {

    @Resource
    private UUIDService uuidService;

    @Override
    public void create(ServiceagencyDto dto) {
        String id = uuidService.generateUUID(new UUIDDto(null, 16));
        ServiceagencyDo serviceagencyDo = this.baseMapper.selectById(id);
        if (ObjectUtil.isNotNull(serviceagencyDo)) {
            throw new DemoFrameException(BaseCode.SERVICEAGENCY_EXIST);
        }
        serviceagencyDo = new ServiceagencyDo();
        BeanUtil.copyProperties(dto, serviceagencyDo);
        serviceagencyDo.setId(id);
        this.baseMapper.insert(serviceagencyDo);
    }

    @Override
    public void delete(Set<String> ids) {
        this.baseMapper.deleteBatchIds(ids);
        //todo 互联网单位也要删除
    }

    @Override
    public void update(ServiceagencyUpdateDto dto) {
        ServiceagencyDo serviceagencyDo = this.baseMapper.selectById(dto.getId());
        if (ObjectUtil.isNull(serviceagencyDo)) {
            throw new DemoFrameException(BaseCode.SERVICEAGENCY_NOT_EXIST);
        }
        BeanUtil.copyProperties(dto, serviceagencyDo);
        this.baseMapper.updateById(serviceagencyDo);
    }

    @Override
    public PageVo<ServiceagencyVo> query(ServiceagencyQueryDto dto) {
        IPage<ServiceagencyDo> iPage = this.baseMapper.selectPage(
                PageUtil.getPageParams(dto),
                Wrappers.<ServiceagencyDo>lambdaQuery()
                        .like(StrUtil.isNotBlank(dto.getName()), ServiceagencyDo::getName, dto.getName())
        );
        return PageUtil.convertPage(iPage, serviceagencyDo -> {
            ServiceagencyVo serviceagencyVo = new ServiceagencyVo();
            BeanUtil.copyProperties(serviceagencyDo, serviceagencyVo);
            return serviceagencyVo;
        });
    }

}
