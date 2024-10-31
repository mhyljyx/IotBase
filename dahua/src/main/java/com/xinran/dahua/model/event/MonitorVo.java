package com.xinran.dahua.model.event;

import java.util.List;


/**
 * Created by 32514 on 2019-06-13.
 */
public class MonitorVo {
    private String monitor;//监听地址
    private final String monitorType = "url";//监听类型
    private List<EventVo> events;//监听事件

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(String monitorType) {
//        this.monitorType = monitorType;
    }

    public List<EventVo> getEvents() {
        return events;
    }

    public void setEvents(List<EventVo> events) {
        this.events = events;
    }

}
