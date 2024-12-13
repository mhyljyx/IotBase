package com.tztang.core;


import lombok.Getter;

/**
 * @program: 
 * @description: redis key管理
 * @author: tztang
 **/
@Getter
public enum RedisKeyManage {
    /**
     * redis 缓存 key管理
     * */

    Key("key","键值测试","value为TestCacheDto类型","k"),
    Key2("key:%s","键值占位测试","value为TestCacheDto类型","k"),
    
    USER_LOGIN("user_login_%s","user_login","value为UserVo类型","k"),
    ADMIN_LOGIN("admin_login_%s","admin_login","value为AdminVo类型","k"),

    USER_PERMISSION("user_permission_%s","user_permission","value为PermissionVo类型","k"),
    ADMIN_PERMISSION("admin_permission_%s","admin_permission","value为PermissionVo类型","k"),
    
    //分布式datacenter_id
    DISTRIBUTED_DATACENTER_ID("distributed_datacenter_id:%s","分布式datacenter_id","分布式datacenter_id的值","lk"),
    
    ALL_RULE_HASH("all_rule_hash","所有规则的key","所有规则的Hash","k"),
    RULE("rule","调用限制规则的key","调用限制规则的value","k"),
    
    RULE_LIMIT("rule_limit_%s","调用限制时间的key","调用限制时间的value","k"),
    
    Z_SET_RULE_STAT("z_set_rule_stat_%s","规则zset", "value为zset类型", "k"),
    
    DEPTH_RULE("depth_rule","深度调用限制规则的key","深度调用限制规则的value","k"),
    
    DEPTH_RULE_LIMIT("depth_rule_limit_%s_%s","深度调用限制时间的key","深度调用限制时间的value","k"),
    
    API_STAT_CONTROLLER_METHOD_DATA("api_stat_controller_method_data:%s","controller的key","controller的value","k"),
    
    API_STAT_SERVICE_METHOD_DATA("api_stat_service_method_data:%s","service的key","service的value","k"),
    
    API_STAT_DAO_METHOD_DATA("api_stat_dao_method_data:%s","dao的key","dao的value","k"),
    
    API_STAT_METHOD_HIERARCHY("api_stat_method_Hierarchy:%s","method_Hierarchy的key","method_Hierarchy的value","k"),

    API_STAT_METHOD_DETAIL("api_stat_method_detail:%s","api_stat_method_detail的key","api_stat_method_detail的value","k"),

    API_STAT_CONTROLLER_SORTED_SET("api_stat_controller_sorted_set","api_stat_controller_sorted_set的key","api_stat_controller_sorted_set的value","k"),

    API_STAT_CONTROLLER_CHILDREN_SET("api_stat_controller_children_set:%s","api_stat_controller_children_set的key","api_stat_controller_children_set的value","k"),
    
    API_STAT_SERVICE_CHILDREN_SET("api_stat_service_children_set:%s","api_stat_service_children_set的key","api_stat_service_children_set的value","k"),
    
    PLATFORM_NOTICE_FLAG("platform_notice_flag","platform_notice_flag的key","platform_notice_flag的value","k"),
    
    CHANNEL_DATA("channel_data_%s","channel_data的key","channel_data的value","k"),
    
    LOGIN_USER_MOBILE_ERROR("login_user_mobile_error_%s","登录错误的用户手机号key","登录错误的用户手机号次数","k"),
    
    LOGIN_USER_EMAIL_ERROR("login_user_email_error_%s","登录错误的用户邮箱key","登录错误的用户邮箱次数","k"),
    ;

    /**
     * key值
     * */
    private final String key;

    /**
     * key的说明
     * */
    private final String keyIntroduce;

    /**
     * value的说明
     * */
    private final String valueIntroduce;

    /**
     * 作者
     * */
    private final String author;

    RedisKeyManage(String key, String keyIntroduce, String valueIntroduce, String author){
        this.key = key;
        this.keyIntroduce = keyIntroduce;
        this.valueIntroduce = valueIntroduce;
        this.author = author;
    }

    public static RedisKeyManage getRc(String keyCode) {
        for (RedisKeyManage re : RedisKeyManage.values()) {
            if (re.key.equals(keyCode)) {
                return re;
            }
        }
        return null;
    }
    
}
