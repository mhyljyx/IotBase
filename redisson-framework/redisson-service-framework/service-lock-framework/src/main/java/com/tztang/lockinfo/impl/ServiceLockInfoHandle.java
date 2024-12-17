package com.tztang.lockinfo.impl;

import com.tztang.lockinfo.AbstractLockInfoHandle;

/**
 * @program: 
 * @description: 锁信息实现(分布式锁)
 * @author: tztang
 **/
public class ServiceLockInfoHandle extends AbstractLockInfoHandle {

    private static final String LOCK_PREFIX_NAME = "SERVICE_LOCK";
    
    @Override
    protected String getLockPrefixName() {
        return LOCK_PREFIX_NAME;
    }
}
