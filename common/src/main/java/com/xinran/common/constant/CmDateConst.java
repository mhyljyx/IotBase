package com.xinran.common.constant;

import java.text.SimpleDateFormat;

/**
 * @author xuehy
 * @since 2022/3/25
 */
public interface CmDateConst {

    //格式化文件名
    SimpleDateFormat FILE_NAME_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");

    //以'.'结尾的格式化文件名
    SimpleDateFormat FILE_NAME_FORMAT_1 = new SimpleDateFormat("yyyyMMdd_HHmmssSSS.");

    //以'_'结尾的格式化文件名
    SimpleDateFormat FILE_NAME_FORMAT_2 = new SimpleDateFormat("yyyyMMdd_HHmmssSSS_");

    //以时间格式化的目录名
    SimpleDateFormat FILE_DIR_FORMAT_1 = new SimpleDateFormat("yyyyMMdd/");

    //以时间格式化的目录名,只到月
    SimpleDateFormat FILE_DIR_FORMAT_2 = new SimpleDateFormat("yyyyMM/");

}
