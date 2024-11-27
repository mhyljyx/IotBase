package com.tztang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.enums.BaseCode;
import com.tztang.exception.DemoFrameException;
import com.tztang.mapper.DeptMapper;
import com.tztang.page.PageUtil;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.DeptDto;
import com.tztang.pojo.dto.DeptQueryDto;
import com.tztang.pojo.dto.DeptUpdateDto;
import com.tztang.pojo.dto.UUIDDto;
import com.tztang.pojo.entity.CommunityDo;
import com.tztang.pojo.entity.DeptDo;
import com.tztang.pojo.vo.CommunityVo;
import com.tztang.pojo.vo.DeptVo;
import com.tztang.service.DeptService;
import com.tztang.service.UUIDService;
import com.tztang.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, DeptDo> implements DeptService {

    @Resource
    private UUIDService uuidService;

    @Override
    public void create(DeptDto dto) {
        String id = uuidService.generateUUID(new UUIDDto("D_", 35));
        //检查父级部门是否存在,非根部门
        if (StrUtil.isNotBlank(dto.getParentId()) && !DeptDo.ROOT_ID.equals(dto.getParentId())) {
            DeptDo deptDo = this.baseMapper.selectById(dto.getParentId());
            if (ObjectUtil.isNull(deptDo)) {
                throw new DemoFrameException(BaseCode.PARENT_DEPT_NOT_EXIST);
            }
        }
        //检查部门id是否存在
        DeptDo deptDo = this.baseMapper.selectById(id);
        if (ObjectUtil.isNotNull(deptDo)) {
            throw new DemoFrameException(BaseCode.DEPT_EXIST);
        }
        deptDo = new DeptDo();
        BeanUtil.copyProperties(dto, deptDo);
        deptDo.setId(id);
        this.baseMapper.insert(deptDo);
    }

    @Override
    public void delete(Set<String> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    @Override
    public void update(DeptUpdateDto dto) {
        DeptDo deptDo = this.baseMapper.selectById(dto.getId());
        if (ObjectUtil.isNull(deptDo)) {
            throw new DemoFrameException(BaseCode.DEPT_NOT_EXIST);
        }
        BeanUtil.copyProperties(dto, deptDo);
        this.baseMapper.updateById(deptDo);
    }

    @Override
    public PageVo<DeptVo> query(DeptQueryDto dto) {
        IPage<DeptDo> iPage = this.baseMapper.selectPage(
                PageUtil.getPageParams(dto),
                Wrappers.<DeptDo>lambdaQuery()
                        .eq(DeptDo::getParentId, dto.getParentId())
                        .like(StrUtil.isNotBlank(dto.getName()), DeptDo::getName, dto.getName())
        );
        return PageUtil.convertPage(iPage, deptDo -> {
            DeptVo deptVo = new DeptVo();
            BeanUtil.copyProperties(deptDo, deptVo);
            return deptVo;
        });
    }

}
