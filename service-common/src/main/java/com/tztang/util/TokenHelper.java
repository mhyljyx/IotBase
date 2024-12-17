package com.tztang.util;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

public abstract class TokenHelper<T> {

    //加密秘钥
    protected static final String TOKEN_SIGN_KEY = "tztang";

    //token过期时间
    public static long TOKEN_EXPIRATION = 60 * 60 * 1000;

    //参数
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ACCOUNT = "account";
    public static final String ROLE_TYPE = "roleType";


    //根据id和名称生成token字符串
    public String createToken(T t) {
        return null;
    }

    //从token字符串获取Id
    public String getId(String token) {
        return null;
    }

    //从token字符串获取Name
    public String getName(String token) {
        return null;
    }

    //从token字符串获取account
    public String getAccount(String token) {
        return null;
    }

    //从token字符串获取roleType
    public String getRoleType(String token) {
        return null;
    }

    public Claims getClaims(String token) {
        try {
            if (StrUtil.isBlank(token)) return null;
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token);
            return claimsJws.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
