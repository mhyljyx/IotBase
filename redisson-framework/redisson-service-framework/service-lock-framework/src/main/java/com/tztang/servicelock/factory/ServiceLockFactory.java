package com.tztang.servicelock.factory;

import com.tztang.servicelock.LockType;
import com.tztang.servicelock.ServiceLocker;
import com.tztang.servicelock.impl.RedissonFairLocker;
import com.tztang.servicelock.impl.RedissonReadLocker;
import com.tztang.servicelock.impl.RedissonReentrantLocker;
import com.tztang.servicelock.impl.RedissonWriteLocker;
import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

/**
 * @program: 
 * @description: 分布式锁类型工厂
 * @author: tztang
 **/
@AllArgsConstructor
public class ServiceLockFactory {

    
    private final RedissonClient redissonClient;
    

    public ServiceLocker getLock(LockType lockType){
        ServiceLocker lock;
        switch (lockType) {
            case Fair:
                lock = new RedissonFairLocker(redissonClient);
                break;
            case Write:
                lock = new RedissonWriteLocker(redissonClient);
                break;
            case Read:
                lock = new RedissonReadLocker(redissonClient);
                break;
            default:
                lock = new RedissonReentrantLocker(redissonClient);
                break;
        }
        return lock;
    }
}
