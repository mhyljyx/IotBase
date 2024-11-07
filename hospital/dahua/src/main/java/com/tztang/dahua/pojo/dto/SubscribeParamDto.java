package com.tztang.dahua.pojo.dto;

import java.util.List;

/**
 * Created by 32514 on 2019-06-17.
 */
public class SubscribeParamDto {
    private List<MonitorDto> monitors;//监听组
    private SubsystemDto subsystem;//订阅者信息


    public List<MonitorDto> getMonitors() {
        return monitors;
    }

    public void setMonitors(List<MonitorDto> monitors) {
        this.monitors = monitors;
    }

    public SubsystemDto getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(SubsystemDto subsystem) {
        this.subsystem = subsystem;
    }

}
