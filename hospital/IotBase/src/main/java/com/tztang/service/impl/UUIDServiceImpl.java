package com.tztang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.tztang.pojo.dto.UUIDDto;
import com.tztang.service.UUIDService;
import com.tztang.util.UUIDUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UUIDServiceImpl implements UUIDService {

    @Override
    public String generateUUID(UUIDDto dto) {
        if (ObjectUtil.isNull(dto.getLength())) {
            //默认值为16
            dto.setLength(16);
        }
        return UUIDUtil.customCreation(dto.getHead(), dto.getLength());
    }

}
