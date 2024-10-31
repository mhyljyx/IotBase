package com.xinran.common.util;

import com.xinran.common.constant.CryptoConst;

/**
 * 密码工具类
 * @author xuehy
 * @since 2021/4/26
 */
public class PasswordUtil {

    private enum CHAR_TYPE {NUM, LOWER, UPPER, OTHER}

    /**
     * 加密密码
     * @param adminId   管理员id
     * @param password  密码明文
     * @return  加密后的密码
     */
    public static String encode(String adminId, String password) {
        return CryptoConst.SHA256.digestHex(adminId + password);
    }

    /**
     * 验证密码是否符合规则(长度为4-20位 大写/小写/数字/字母 两种及以上)
     * @param password  明文密码
     * @return 是否符合要求
     */
    public static boolean checkPassword(String password) {
        if (password.length() < 4 || password.length() > 20) {
            return false;
        }
        return hasType(password, CHAR_TYPE.NUM) + hasType(password, CHAR_TYPE.LOWER) +
                hasType(password, CHAR_TYPE.UPPER) + hasType(password, CHAR_TYPE.OTHER) >= 2;
    }

    /**
     * 密码是否有此类型的字符
     * @param password  密码明文
     * @param type      类型
     * @return  {@link Integer} 存在:1 不存在:0
     */
    private static Integer hasType(String password, CHAR_TYPE type) {
        for (char c : password.toCharArray()) {
            if (checkCharacterType(c) == type) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 获取字符类型
     * @param c 字符
     * @return  类型
     */
    private static CHAR_TYPE checkCharacterType(char c) {
        if (c >= 48 && c <= 57) {
            return CHAR_TYPE.NUM;
        }
        if (c >= 65 && c <= 90) {
            return CHAR_TYPE.UPPER;
        }
        if (c >= 97 && c <= 122) {
            return CHAR_TYPE.LOWER;
        }
        return CHAR_TYPE.OTHER;
    }

}
