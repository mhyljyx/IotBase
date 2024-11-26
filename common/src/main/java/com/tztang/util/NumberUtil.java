package com.tztang.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字工具
 * @author tztang
 * @since 2024-11-26
 */
public class NumberUtil {

    /**
     * 生成固定宽度的递增数字列表（以字符串形式返回）
     *
     * @param startNum 起始数字
     * @param count    需要生成的数字个数
     * @param width    数字的固定宽度（不足补零）
     * @return         生成的数字列表（字符串形式）
     */
    public static List<String> generateFixedWidthNumbers(int startNum, int count, int width) {
        if (count <= 0) {
            throw new IllegalArgumentException("需要生成的数字个数必须大于0");
        }

        List<String> result = new ArrayList<>();
        String format = "%0" + width + "d"; // 动态生成格式，例如 "%06d" 表示6位数字，左侧补零

        for (int i = 0; i < count; i++) {
            result.add(String.format(format, startNum + i));
        }
        return result;
    }

}
