package com.tztang.servicelock.info;

/**
 * @program: 
 * @description: 分布式锁 处理失败抽象
 * @author: tztang
 **/
public interface LockTimeOutHandler {
    
    /**
     * 处理
     * @param lockName 锁名
     * */
    void handler(String lockName);
}
