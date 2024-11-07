package com.tztang.dahua.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 事件订阅查询试视图
 * @author tztang
 * @since 2024-11-07
 */
@Data
@ApiModel("事件订阅查询试视图")
public class EventSubscribeQueryVo {

    private Integer id;

    /**
     * 事件订阅名称
     */
    private String name;

    /**
     * 事件大类
     */
    private String category;

    /**
     * 接收方ip
     */
    private String ip;

    /**
     * 接收方port
     */
    private Integer port;

    /**
     * 0未取消 1已取消
     */
    private Integer status;

    /**
     * 告警等级
     */
    private Integer grade;

    /**
     * 设备或者通道编号
     */
    private String nodeCode;

    /**
     * 事件类型
     */
    private String type;

}
