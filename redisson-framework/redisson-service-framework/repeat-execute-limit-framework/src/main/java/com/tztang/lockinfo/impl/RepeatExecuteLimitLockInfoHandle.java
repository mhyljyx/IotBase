package com.tztang.lockinfo.impl;

import com.tztang.lockinfo.AbstractLockInfoHandle;

/**
 * @program:  
 * @description: 锁信息实现(防重复幂等)
 * @author: tztang
 **/
public class RepeatExecuteLimitLockInfoHandle extends AbstractLockInfoHandle {

    public static final String PREFIX_NAME = "REPEAT_EXECUTE_LIMIT";
    
    @Override
    protected String getLockPrefixName() {
        return PREFIX_NAME;
    }
}
