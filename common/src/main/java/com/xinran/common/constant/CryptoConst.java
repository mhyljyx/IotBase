package com.xinran.common.constant;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 密码常量
 * @author xuehy
 * @since 2023/2/15
 */
public interface CryptoConst {

    //sha256加密器
    Digester SHA256 = new Digester(DigestAlgorithm.SHA256);

}
