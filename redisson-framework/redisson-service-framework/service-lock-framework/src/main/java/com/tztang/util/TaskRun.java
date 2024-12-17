package com.tztang.util;

/**
 * @program: 
 * @description: 分布式锁 方法类型执行 无返回值的业务
 * @author: tztang
 **/
@FunctionalInterface
public interface TaskRun {
    
    /**
     * 执行任务
     * */
    void run();
}
