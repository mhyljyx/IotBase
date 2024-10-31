package com.xinran.common.util;

import cn.hutool.core.util.ObjectUtil;
import com.xinran.common.constant.CmRedisConst;
import io.lettuce.core.KeyScanCursor;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.ScanArgs;
import io.lettuce.core.ScanCursor;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * Redis工具类
 * @author xuehy
 * @since 2022/12/8
 */
@Component
public class RedisHelper {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //增加<Key,Set>
    public Long addSet(String key, Set<String> set) {
        return stringRedisTemplate.boundSetOps(key).add(set.toArray(new String[0]));
    }

    //增加<Key,Set>
    public Set<String> getSet(String key) {
        return stringRedisTemplate.boundSetOps(key).members();
    }

    //判断key对应的Set中是否有hKey成员
    public Boolean isSetMember(String key, Object hKey) {
        return stringRedisTemplate.boundSetOps(key).isMember(ObjectUtil.toString(hKey));
    }

    //判断key对应的Set中是否有hKey成员
    public Map<Object, Boolean> isSetMember(String key, Object... hKey) {
        return stringRedisTemplate.boundSetOps(key).isMember(hKey);
    }

    //增加<Key,HashMap>
    public void addHashMap(String key, HashMap<String, String> map) {
        stringRedisTemplate.boundHashOps(key).putAll(map);
    }

    //增加<Key,<HKey, HValue>>
    public void putHashMap(String key, String hk, String hv) {
        stringRedisTemplate.boundHashOps(key).put(hk, hv);
    }

    //删除Map中的Key
    public Long delHashKey(String key, String hk) {
        return stringRedisTemplate.boundHashOps(key).delete(hk);
    }

    //通过Key获取HashMap
    public Map<Object, Object> getHashMap(String key) {
        return stringRedisTemplate.boundHashOps(key).entries();
    }

    //通过Key获取字符串类型的值
    public String getHashMapValue(String key, String hKey) {
        if (DataType.HASH.equals(stringRedisTemplate.type(key))) {
            return (String) stringRedisTemplate.boundHashOps(key).get(hKey);
        }
        return null;
    }

    //删除Key
    public Boolean delKey(String key) {
         return stringRedisTemplate.delete(key);
    }

    //批量删除Key
    public Long delBatchKeys(Collection<String> key) {
        return stringRedisTemplate.delete(key);
    }

    //设置过期时间(过期时间 = 当前时间 + duration)
    public void setExpireTime(String key) {
        setExpireTime(key, Duration.ofMinutes(CmRedisConst.TOKEN_EXPIRES_MINUTE));
    }
    public void setExpireTime(String key, Duration duration) {
        stringRedisTemplate.boundValueOps(key).expire(duration);
    }

    /**
     * 获取key的集合
     * @param pattern 前缀
     * @return 以前缀开头的键集合
     */
    public Set<String> getKeySetLikeRight(String pattern) {
        return stringRedisTemplate.execute(connection -> {
            Set<String> keySet = new HashSet<>();
            RedisAsyncCommands conn = (RedisAsyncCommands) connection.getNativeConnection();
            //游标
            ScanCursor curs = ScanCursor.INITIAL;
            try {
                //采用SCAN命令,迭代遍历所有key
                while (!curs.isFinished()) {
                    ScanArgs args = ScanArgs.Builder.matches(pattern.concat("*")).limit(10240L);
                    RedisFuture<KeyScanCursor<byte[]>> future = conn.scan(curs, args);
                    //每次迭代后的返回数据,包含下次迭代的游标和此次迭代返回的keys列表
                    KeyScanCursor<byte[]> keyCurs = future.get();
                    List<byte[]> ks = keyCurs.getKeys();
                    Set<String> set = ks.stream().map(bytes -> new String(bytes, StandardCharsets.UTF_8)).collect(Collectors.toSet());
                    keySet.addAll(set);
                    curs = keyCurs;
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            return keySet;
        }, true);
    }

}
