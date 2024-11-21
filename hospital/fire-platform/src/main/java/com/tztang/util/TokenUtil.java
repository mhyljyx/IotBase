package com.tztang.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 安防云平台消防板块Token
 * @author tztang
 * @since 2024-11-21
 */
public class TokenUtil {

    public static String createToken(String tokenAK, String tokenSK) {
        //有效时间，30秒
        long validTimeStamp = System.currentTimeMillis() + 30 * 1000L;
        //认证字符串
        String certificationStr = Base64.encode(tokenAK + validTimeStamp);
        //认证摘要字符串
        String digesterStr = new Digester(DigestAlgorithm.SHA256).digestHex(certificationStr + tokenSK);
        //token
        return Base64.encode(digesterStr + ":" + tokenAK + ":" + validTimeStamp);
    }

}
