package com.xinran.common.util;

import com.alibaba.fastjson2.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author xuehy
 * @since 2022/11/23
 */
public class ResponseUtil {

    public static void writeResponse(Result result, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.append(JSONObject.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
