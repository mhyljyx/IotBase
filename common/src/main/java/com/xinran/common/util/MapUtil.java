package com.xinran.common.util;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xuehy
 * @since 2023/1/4
 */
public class MapUtil extends cn.hutool.core.map.MapUtil {

    //通过value获取key的集合
    public static <K, V> Set<K> getKeysByStream(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(kvEntry -> Objects.equals(kvEntry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}
