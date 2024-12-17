package com.tztang.config;

import com.tztang.handler.BloomFilterHandler;
import org.redisson.api.RedissonClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @program: 
 * @description: 布隆过滤器 配置
 * @author: tztang
 **/
@EnableConfigurationProperties(BloomFilterProperties.class)
public class BloomFilterAutoConfiguration {
    
    /**
     * 布隆过滤器
     */
    @Bean
    public BloomFilterHandler rBloomFilterUtil(RedissonClient redissonClient, BloomFilterProperties bloomFilterProperties) {
        return new BloomFilterHandler(redissonClient, bloomFilterProperties);
    }
}
