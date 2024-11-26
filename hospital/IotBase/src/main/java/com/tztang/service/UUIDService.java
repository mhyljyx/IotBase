package com.tztang.service;

import com.tztang.pojo.dto.UUIDDto;

public interface UUIDService {

    //默认生成id
    String generateUUID(UUIDDto dto);

}
