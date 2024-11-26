package com.tztang.util;

import cn.hutool.core.util.StrUtil;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author tztang
 * @since 2024-11-26
 */
public class UUIDUtil {

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static SecureRandom secureRandom;

    static {
        secureRandom = new SecureRandom();
    }

    /**
     * 自定义生成uuid
     * @param head 头
     * @param length 长度
     * @return uuid
     */
    public static String customCreation(String head, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (head == null) {
            head = "";
        }
        if (head.length() >= length) {
            throw new IllegalArgumentException("Length must be greater than Head Length");
        }
        StringBuilder result = new StringBuilder(length);
        if (head.length() > 0) {
            result.append(head);
        }
        for (int i = 0; i < length - head.length(); i++) {
            int index = secureRandom.nextInt(CHAR_POOL.length());
            result.append(CHAR_POOL.charAt(index));
        }
        return result.toString();
    }

}
