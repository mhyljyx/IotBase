package com.tztang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.common.ApiResponse;
import com.tztang.pojo.entity.SysApiDo;

import java.util.List;

public interface SysApiService extends IService<SysApiDo> {

    void scanApis();

}
