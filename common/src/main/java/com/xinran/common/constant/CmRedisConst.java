package com.xinran.common.constant;

/**
 * Redis 常量
 * @author xuehy
 * @since 2021/9/13
 */
public interface CmRedisConst {

    //Token有效时间(30min)
    Integer TOKEN_EXPIRES_MINUTE = 30;

    //************************************ Key

    //Redis Key:阿里短信信息
    String KEY_ALI_SMS = "SMS_INFO_ALI";

    //Redis HKey:过期时间
    String SMS_KEY_EXPIRE = "EXPIRE";

    //Redis HKey:验证码
    String SMS_KEY_CODE = "CODE";

    //Redis HKey:验证码类型
    String SMS_KEY_TYPE = "TYPE";

    //Redis Key:管理员信息前缀
    String ADMIN_KEY_PREFIX = "ADMIN_";
    //Redis Key:用户信息前缀
    String USER_KEY_PREFIX = "USER_";

    //Redis HKey:用户Token
    String TOKEN = "TOKEN";

    //Redis HKey:管理员角色编号
    String ROLE_ID = "ROLE_ID";

    //Redis HKey:是否为超级管理员
    String IS_SUPER_ADMIN = "IS_SUPER_ADMIN";

    //Redis Key:管理员有权限的部门后缀
    String ADMIN_KEY_DEPT_SUFFIX = "_DEPT";

    //Redis Key:设备信息前缀
    String DEVICE_KEY_PREFIX = "DEVICE_";

    //Redis HKey:设备型号
    String DEVICE_KEY_MODEL = "DEVICE_MODEL";

    //Redis HKey:设备类型
    String DEVICE_KEY_TYPE = "DEVICE_TYPE";

    //************************************ Topic

    //公共模块Topic
    String TOPIC_COMMON = "TOPIC_SERVICE_COMMON";

    //考勤模块Topic
    String TOPIC_ATTENDANCE = "TOPIC_SERVICE_ATTENDANCE";

}
