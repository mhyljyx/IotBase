package com.tztang.dahua.enums;

/**
 * 事件订阅大类
 */
public enum EventCategoryEnums {

    alarm("alarm","报警事件"),//对应的types 可参考 ICC平台-报警类型
    business("business","业务事件"),//对应的types 可参考 ICC开放平台-文档-附录-事件列表
    state("state","设备状态事件"),//设备状态信息推送
    perception("perception","感知类事件")//gps信息推送
    ;

    public String code;
    public String msg;

    EventCategoryEnums(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
