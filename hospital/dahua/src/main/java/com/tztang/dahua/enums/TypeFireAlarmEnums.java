package com.tztang.dahua.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消防告警类型
 */
public enum TypeFireAlarmEnums {

  alarm_ack("73000000", "告警确认"),
  fire_alarm_ack("73000001", "火警确认"),
  gas_alarm_ack("73000005", "燃气报警确认"),
  fire_alarm("73010000", "火警"),
  remove_alarm("73010001", "拆除报警");

  public String code;
  public String msg;

  TypeFireAlarmEnums(String code,String msg){
    this.code = code;
    this.msg = msg;
  }

  public static List<String> getCodes() {
    return Arrays.stream(TypeFireAlarmEnums.values())
            .map(value -> value.code)
            .collect(Collectors.toList());
  }

}
