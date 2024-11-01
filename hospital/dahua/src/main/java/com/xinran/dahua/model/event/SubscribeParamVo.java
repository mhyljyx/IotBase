package com.xinran.dahua.model.event;

import java.util.List;

/**
 * Created by 32514 on 2019-06-17.
 */
public class SubscribeParamVo {
    private List<MonitorVo> monitors;//监听组
    private SubsystemVo subsystem;//订阅者信息


    public List<MonitorVo> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<MonitorVo> monitors) {
        this.monitors = monitors;
    }

    public SubsystemVo getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(SubsystemVo subsystem) {
        this.subsystem = subsystem;
    }

}
