package com.xinran.common.constant;

/**
 * 返回值常数
 * @author xuehy
 * @since 2021/5/20
 */
public interface ResultCode {

    //成功
    int SUCCESS = 0;
    //失败
    int ERR = 500;

    //错误-参数
    int ERR_PARAM = 400;
    //错误-无接口权限
    int ERR_FORBIDDEN = 403;
    //错误-页面不存在
    int ERR_NOT_FOUND = 404;

    //密码过于简单
    int ERR_EASY_PASS = -4;
    //Token无效
    int ERR_TOKEN = -100;
    //在其他地方登录
    int ERR_LOGIN_OTHER_PLACE = -104;

    //短信发送过于频繁
    int ERR_SMS_FREQUENT = -301;

}
