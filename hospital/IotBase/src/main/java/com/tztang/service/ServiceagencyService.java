package com.tztang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.ServiceAgencyDto;
import com.tztang.pojo.dto.ServiceAgencyQueryDto;
import com.tztang.pojo.dto.ServiceAgencyUpdateDto;
import com.tztang.pojo.entity.ServiceAgencyDo;
import com.tztang.pojo.vo.ServiceAgencyVo;

import java.util.Set;

/**
 * @description  物联网运营服务机构service
 * @author  tztang
 * @Date 2024-11-25
 */
public interface ServiceAgencyService extends IService<ServiceAgencyDo> {

    //新增物联网运营服务机构
    void create(ServiceAgencyDto dto);

    //删除物联网运营服务机构
    void delete(Set<String> ids);

    //修改物联网运营服务机构
    void update(ServiceAgencyUpdateDto dto);

    //查询物联网运营服务机构
    PageVo<ServiceAgencyVo> query(ServiceAgencyQueryDto dto);

}
