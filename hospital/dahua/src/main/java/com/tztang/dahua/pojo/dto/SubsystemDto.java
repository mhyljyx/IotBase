package com.tztang.dahua.pojo.dto;



/**
 * Created by 32514 on 2019-06-13.
 */
public class SubsystemDto {
    private final Integer subsystemType = 0;//0代表子系统
    private String name;//订阅者名称
    //@NotNull(message = SUBSCRIBE_SUBSYSTEM_MAGIC_NOT_NULL)
    private String magic;//订阅者ip，端口等信息

    public Integer getSubsystemType() {
        return subsystemType;
    }

    public void setSubsystemType(Integer subsystemType) {
//        this.subsystemType = subsystemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

}
