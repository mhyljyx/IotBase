package com.tztang.core;

/**
 * @program: 
 * @description: 分布式锁 业务名管理
 * @author: tztang
 **/
public class DistributedLockConstants {

    /**
     * 	分布式id datacenterId
     * */
    public static final String DATACENTER_ID = "datacenter_id";
    /**
     * api统计定时任务
     * */
    public final static String API_STAT_LOCK = "api_stat_lock";
    
    /**
     * 分布式锁示例
     * */
    public final static String LOCK_DATA = "lock_data";
    
    /**
     * 注册用户
     * */
    public final static String REGISTER_USER_LOCK = "register_user_lock";
    
    /**
     * 登录用户
     * */
    public final static String LOGIN_USER_LOCK = "login_user_lock";

    /**
     * 备份数据库
     * */
    public final static String BACKUP_DATABASE = "backup_database_lock";

}
