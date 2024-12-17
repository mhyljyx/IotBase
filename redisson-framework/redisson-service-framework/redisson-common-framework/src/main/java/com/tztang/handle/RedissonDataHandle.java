package com.tztang.handle;

import lombok.AllArgsConstructor;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * @program: 
 * @description: redisson操作
 * @author: tztang
 **/
@AllArgsConstructor
public class RedissonDataHandle {
    
    private final RedissonClient redissonClient;
    
    public String get(String key){
        return (String)redissonClient.getBucket(key).get();
    }
    
    public void set(String key,String value){
        redissonClient.getBucket(key).set(value);
    }
    
    public void set(String key,String value,long timeToLive, TimeUnit timeUnit){
        redissonClient.getBucket(key).set(value,timeToLive,timeUnit);
    }
}
