package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.ServiceAgencyMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.ServiceAgencyDto;
import com.tztang.pojo.dto.ServiceAgencyQueryDto;
import com.tztang.pojo.dto.ServiceAgencyUpdateDto;
import com.tztang.pojo.dto.UUIDDto;
import com.tztang.pojo.entity.ServiceAgencyDo;
import com.tztang.pojo.vo.ServiceAgencyVo;
import com.tztang.service.ServiceAgencyService;
import com.tztang.service.UUIDService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class ServiceAgencyServiceImpl extends ServiceImpl<ServiceAgencyMapper, ServiceAgencyDo> implements ServiceAgencyService {

    @Resource
    private UUIDService uuidService;

    @Override
    public void create(ServiceAgencyDto dto) {
        String id = uuidService.generateUUID(new UUIDDto("SA_", 35));
        ServiceAgencyDo serviceagencyDo = this.baseMapper.selectById(id);
        if (ObjectUtil.isNotNull(serviceagencyDo)) {
            throw new DemoFrameException(BaseCode.SERVICE_AGENCY_EXIST);
        }
        serviceagencyDo = new ServiceAgencyDo();
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
    public void update(ServiceAgencyUpdateDto dto) {
        ServiceAgencyDo serviceagencyDo = this.baseMapper.selectById(dto.getId());
        if (ObjectUtil.isNull(serviceagencyDo)) {
            throw new DemoFrameException(BaseCode.SERVICE_AGENCY_NOT_EXIST);
        }
        BeanUtil.copyProperties(dto, serviceagencyDo);
        this.baseMapper.updateById(serviceagencyDo);
    }

    @Override
    public PageVo<ServiceAgencyVo> query(ServiceAgencyQueryDto dto) {
        IPage<ServiceAgencyDo> iPage = this.baseMapper.selectPage(
                PageUtil.getPageParams(dto),
                Wrappers.<ServiceAgencyDo>lambdaQuery()
                        .like(StrUtil.isNotBlank(dto.getName()), ServiceAgencyDo::getName, dto.getName())
        );
        return PageUtil.convertPage(iPage, serviceagencyDo -> {
            ServiceAgencyVo serviceagencyVo = new ServiceAgencyVo();
            BeanUtil.copyProperties(serviceagencyDo, serviceagencyVo);
            return serviceagencyVo;
        });
    }

}
