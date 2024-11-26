package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.CommunityMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.CommunityDto;
import com.tztang.pojo.dto.CommunityQueryDto;
import com.tztang.pojo.dto.CommunityUpdateDto;
import com.tztang.pojo.entity.CommunityDo;
import com.tztang.pojo.entity.ServiceagencyDo;
import com.tztang.pojo.vo.CommunityVo;
import com.tztang.pojo.vo.ServiceagencyVo;
import com.tztang.service.CommunityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, CommunityDo> implements CommunityService {

    @Override
    public void create(CommunityDto dto) {
        boolean exists = this.baseMapper.exists(
                Wrappers.<CommunityDo>lambdaQuery()
                        .eq(CommunityDo::getCode, dto.getCode())
                        .eq(CommunityDo::getParentId, dto.getParentId())
        );
        if (exists) {
            throw new DemoFrameException(BaseCode.COMMUNITY_EXIST);
        }
        CommunityDo communityDo = new CommunityDo();
        BeanUtil.copyProperties(dto, communityDo);
        this.baseMapper.insert(communityDo);
    }

    @Override
    public void delete(Set<Integer> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public void update(CommunityUpdateDto dto) {
        CommunityDo communityDo = this.baseMapper.selectById(dto.getId());
        if (ObjectUtil.isNull(communityDo)) {
            throw new DemoFrameException(BaseCode.COMMUNITY_NOT_EXIST);
        }
        BeanUtil.copyProperties(dto, communityDo);
        this.baseMapper.updateById(communityDo);
    }

    @Override
    public PageVo<CommunityVo> query(CommunityQueryDto dto) {
        IPage<CommunityDo> iPage = this.baseMapper.selectPage(
                PageUtil.getPageParams(dto),
                Wrappers.<CommunityDo>lambdaQuery()
                        .eq(CommunityDo::getParentId, dto.getParentId())
                        .like(StrUtil.isNotBlank(dto.getName()), CommunityDo::getName, dto.getName())
        );
        return PageUtil.convertPage(iPage, communityDo -> {
            CommunityVo communityVo = new CommunityVo();
            BeanUtil.copyProperties(communityDo, communityVo);
            return communityVo;
        });
    }

}
