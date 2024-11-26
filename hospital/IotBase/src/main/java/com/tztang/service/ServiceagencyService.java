package com.tztang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.common.ApiResponse;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.ServiceagencyDto;
import com.tztang.pojo.dto.ServiceagencyQueryDto;
import com.tztang.pojo.dto.ServiceagencyUpdateDto;
import com.tztang.pojo.entity.ServiceagencyDo;
import com.tztang.pojo.vo.ServiceagencyVo;

import java.util.Set;

/**
 * @description  物联网运营服务机构service
 * @author  tztang
 * @Date 2024-11-25
 */
public interface ServiceagencyService extends IService<ServiceagencyDo> {

    //新增物联网运营服务机构
    void create(ServiceagencyDto dto);

    //删除物联网运营服务机构
    void delete(Set<String> ids);

    //修改物联网运营服务机构
    void update(ServiceagencyUpdateDto dto);

    //查询物联网运营服务机构
    PageVo<ServiceagencyVo> query(ServiceagencyQueryDto dto);

}
