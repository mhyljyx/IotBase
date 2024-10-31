package com.xinran.common.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuehy
 * @since 2022/8/26
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {

  /**
   *
   * @param strTime HH:mm:ss
   * @return UTC时间格式
   * @throws ParseException
   */
  public static String transToUTCDate(String strTime) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(today() + " " + strTime);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    return sdf.format(date);
  }

  /**
   *
   * @return UTC时间格式
   * @throws ParseException
   */
  public static String transToUTCDate() throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(now());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    return sdf.format(date);
  }

  /**
   *
   * @param time yyyy-MM-dd HH:mm:ss
   * @return
   * @throws ParseException
   */
  public static String transTimeToUTCDate(String time) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    return sdf.format(date);
  }

  /**
   *
   * @param time yyyy-MM-dd HH:mm:ss
   * @return 2023-12-28T10:41:02+08:00
   * @throws ParseException
   */
  public static String transTimeToISODateTime(String time) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    return sdf.format(date);
  }

  /**
   *
   * @param time yyyy-MM-dd HH:mm:ss
   * @return 2023-12-28T10:41:02
   * @throws ParseException
   */
  public static String transTimeToISODateTimeNoZone(String time) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    return sdf.format(date);
  }

  /**
   *
   * @param time 2022-05-03T17:30:08.123+08:00
   * @return
   * @throws ParseException
   */
  public static String transUTCDateToTime(String time) throws ParseException {
    LocalDateTime date = LocalDateTime.parse(time, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    return dateString;
  }

}
