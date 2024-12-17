package com.tztang.config;

import com.tztang.constant.LockInfoType;
import com.tztang.lockinfo.LockInfoHandle;
import com.tztang.lockinfo.factory.LockInfoHandleFactory;
import com.tztang.lockinfo.impl.ServiceLockInfoHandle;
import com.tztang.servicelock.aspect.ServiceLockAspect;
import com.tztang.servicelock.factory.ServiceLockFactory;
import com.tztang.util.ServiceLockTool;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;

/**
 * @program: 
 * @description: 分布式锁 配置
 * @author: tztang
 **/
public class ServiceLockAutoConfiguration {
    
    @Bean(LockInfoType.SERVICE_LOCK)
    public LockInfoHandle serviceLockInfoHandle(){
        return new ServiceLockInfoHandle();
    }
    
    @Bean
    public ServiceLockFactory serviceLockFactory(RedissonClient redissonClient){
        return new ServiceLockFactory(redissonClient);
    }
    
    @Bean
    public ServiceLockAspect serviceLockAspect(LockInfoHandleFactory lockInfoHandleFactory,ServiceLockFactory serviceLockFactory){
        return new ServiceLockAspect(lockInfoHandleFactory,serviceLockFactory);
    }
    
    @Bean
    public ServiceLockTool serviceLockUtil(LockInfoHandleFactory lockInfoHandleFactory,ServiceLockFactory serviceLockFactory){
        return new ServiceLockTool(lockInfoHandleFactory,serviceLockFactory);
    }
}
