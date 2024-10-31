package com.xinran.common.util;

/**
 * 密码复杂度工具类
 * @author xuehy
 * @since 2023/3/20
 */
public class CryptUtil {

    private static final int NUM = 1;
    private static final int LOWER_LETTER = 2;
    private static final int CAPITAL_LETTER = 3;
    private static final int OTHER_CHAR = 4;

    public static Boolean checkPassword(String password) {
        Integer hasNum = hasType(password, NUM);
        Integer hasLower = hasType(password, LOWER_LETTER);
        Integer hasCapital = hasType(password, CAPITAL_LETTER);
        Integer hasOther = hasType(password, OTHER_CHAR);
        return hasNum + hasLower + hasCapital + hasOther >= 2;
    }

    private static Integer hasType(String password, int type) {
        for (char c : password.toCharArray()) {
            if (checkCharacterType(c) == type) {
                return 1;
            }
        }
        return 0;
    }

    private static int checkCharacterType(char c) {
        if (c >= 48 && c <= 57) {
            return NUM;
        }
        if (c >= 65 && c <= 90) {
            return CAPITAL_LETTER;
        }
        if (c >= 97 && c <= 122) {
            return LOWER_LETTER;
        }
        return OTHER_CHAR;
    }

}
