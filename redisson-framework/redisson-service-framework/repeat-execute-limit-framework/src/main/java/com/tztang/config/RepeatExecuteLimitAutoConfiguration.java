package com.tztang.config;

import com.tztang.constant.LockInfoType;
import com.tztang.handle.RedissonDataHandle;
import com.tztang.locallock.LocalLockCache;
import com.tztang.lockinfo.LockInfoHandle;
import com.tztang.lockinfo.factory.LockInfoHandleFactory;
import com.tztang.lockinfo.impl.RepeatExecuteLimitLockInfoHandle;
import com.tztang.repeatexecutelimit.aspect.RepeatExecuteLimitAspect;
import com.tztang.servicelock.factory.ServiceLockFactory;
import org.springframework.context.annotation.Bean;

/**
 * @program:  
 * @description: 防重复幂等配置
 * @author: tztang
 **/
public class RepeatExecuteLimitAutoConfiguration {
    
    @Bean(LockInfoType.REPEAT_EXECUTE_LIMIT)
    public LockInfoHandle repeatExecuteLimitHandle(){
        return new RepeatExecuteLimitLockInfoHandle();
    }
    
    @Bean
    public RepeatExecuteLimitAspect repeatExecuteLimitAspect(LocalLockCache localLockCache,
                                                             LockInfoHandleFactory lockInfoHandleFactory,
                                                             ServiceLockFactory serviceLockFactory,
                                                             RedissonDataHandle redissonDataHandle){
        return new RepeatExecuteLimitAspect(localLockCache, lockInfoHandleFactory,serviceLockFactory,redissonDataHandle);
    }
}
    