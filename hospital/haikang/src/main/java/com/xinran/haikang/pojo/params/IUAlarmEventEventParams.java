package com.xinran.haikang.pojo.params;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import lombok.Data;

/**
 * 入侵报警和紧急报警事件数据
 * @author tztang
 * @since 2024-10-28
 */
@Data
public class IUAlarmEventEventParams {

    private String eventType;

    private String eventId;

    //事件名称
    private String eventName;

    //发生时间格式：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
    @JsonFormat(pattern = "")
    private String happenTime;

    private String srcIndex;

    //事件状态 0瞬时,1开始,2停止
    private Integer status = 1;

    //脉冲超时时间
    private Integer timeout;

    //停止时间：yyyy-MM-dd'T'HH:mm:ss.SSSXXX
    private String stopTime;

}
