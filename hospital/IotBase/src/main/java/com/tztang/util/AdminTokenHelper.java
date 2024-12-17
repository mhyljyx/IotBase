package com.tztang.util;

import cn.hutool.core.util.StrUtil;
import com.tztang.pojo.entity.AdminDo;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AdminTokenHelper extends TokenHelper<AdminDo> {

    //主题
    private static final String SUBJECT = "AUTH-ADMIN";

    //根据用户id和用户名称生成token字符串
    @Override
    public String createToken(AdminDo adminDo) {
        String token = Jwts.builder()
                .setSubject(SUBJECT)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .claim(ID, adminDo.getId())
                .claim(NAME, adminDo.getName())
                .claim(ACCOUNT, adminDo.getAccount())
                .claim(ROLE_TYPE, adminDo.getRoleType())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGN_KEY)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //从token字符串获取AdminId
    @Override
    public String getId(String token) {
        return (String) getClaims(token).get(ID);
    }

    //从token字符串获取AdminName
    @Override
    public String getName(String token) {
        return (String) getClaims(token).get(NAME);
    }

    @Override
    public String getAccount(String token) {
        return (String) getClaims(token).get(ACCOUNT);
    }

    @Override
    public String getRoleType(String token) {
        return (String) getClaims(token).get(ROLE_TYPE);
    }

}
