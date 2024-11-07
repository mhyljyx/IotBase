package com.tztang.dahua.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 安检业务类型
 */
public enum TypeSecurityBusinessEnums {

    ads_notify_security_door("ads.notifySecurityDoor", "安检门消息"),
    ads_notify_security_machine("ads.notifySecurityMachine", "安检机消息"),
    admin_security_explosive("admin.securityExplosive", "毒品炸药探测"),
    admin_car_inspection_report("admin.car.inspection.report", "车底检测");

    public String code;
    public String msg;

    TypeSecurityBusinessEnums(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public static List<String> getCodes() {
        return Arrays.stream(TypeFireAlarmEnums.values())
                .map(value -> value.code)
                .collect(Collectors.toList());
    }

}
