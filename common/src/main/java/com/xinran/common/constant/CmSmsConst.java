package com.xinran.common.constant;

/**
 * 短信平台常量
 * @author xuehy
 * @since 2021/9/24
 */
public interface CmSmsConst {

    //发送间隔时间(90s)
    Integer INTERVAL_TIME_DEFAULT = 90;

    //短信Code默认有效时间(10min)
    Integer TIMEOUT_DEFAULT = 600;

    //类型:微信小程序用户登录
    String TYPE_VX_USER_LOGIN = "VX_USER_LOGIN";

    //类型:编辑人员信息
    String TYPE_EDIT_USER_INFO = "EDIT_USER_INFO";

}
