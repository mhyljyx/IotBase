package com.tztang.haikang.pojo.params;

import lombok.Data;

import java.util.List;

/**
 * 事件订阅
 * @author tztang
 * @since 2024/10/28
 */
@Data
public class EventSubscribeParams {

    //事件类型
    private List<Integer> eventTypes;

    //事件的接收地址
    private String eventDest;

    //订阅类型 0订阅原始事件 1联动事件 2原始事件和联动事件 默认0
    private Integer subType;

    //事件等级 0未配置 1低 2中 3高
    // 此处事件等级是指在事件联动中配置的等级.订阅类型为0时，此参数无效，默认0；订阅类型为1时，不填使用默认值[1,2,3];订阅类型为2时，不填使用默认值[0,1,2,3]
    private List<Integer> eventLvl;

}
