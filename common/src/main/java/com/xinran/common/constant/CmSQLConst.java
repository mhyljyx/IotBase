package com.xinran.common.constant;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * @author xuehy
 * @since 2021/10/19
 */
public interface CmSQLConst {

    //空
    Object NULL = null;

    //只取一条记录
    String LIMIT_1 = "LIMIT 1";

    //求数量
    String COUNT_1 = "COUNT(1) ";

    //表cm_vein_palm的user_id字段
    String CM_VEIN_PALM_USER_ID = "user_id";

    //SQL字段,一般拼在COUNT_1后面
    String SQL_FIELD_COUNT = "count";

    //无此数据,表示数据库不查询此数据
    Set<String> COLL_NO_DATA = CollUtil.newHashSet("-1");
    Set<Integer> COLL_NO_DATA_INT = CollUtil.newHashSet(-1);
    Set<Long> COLL_NO_DATA_LONG = CollUtil.newHashSet(-1L);

}
