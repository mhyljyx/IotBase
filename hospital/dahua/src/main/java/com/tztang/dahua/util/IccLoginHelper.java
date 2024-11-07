package com.tztang.dahua.util;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.IccHttpHttpRequest;
import com.dahuatech.icc.oauth.http.IccTokenResponse;
import com.dahuatech.icc.oauth.model.v202010.OauthPublicKeyResponse;
import com.dahuatech.icc.oauth.profile.GrantType;
import com.dahuatech.icc.util.BeanUtil;
import com.dahuatech.icc.util.SignUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@Component
@EnableScheduling
public class IccLoginHelper {

    @Value("${dahua.icc.url}")
    private String dahuaIccUrl;
    @Value("${dahua.icc.account}")
    private String dahuaAccount;
    @Value("${dahua.icc.password}")
    private String dahuaPassword;
    @Value("${dahua.icc.client-id}")
    private String dahuaClientId;
    @Value("${dahua.icc.client-secret}")
    private String dahuaClientSecret;
    @Value("${dahua.icc.oauth.public-key-url}")
    private String publicKeyUrl;
    @Value("${dahua.icc.oauth.user-password-auth-url}")
    private String userPasswordAuthUrl;
    @Value("${dahua.icc.oauth.user-password-refresh-token-url}")
    private String userPasswordRefreshTokenUrl;

    //公钥
    public static String publicKey;
    //令牌类型，固定bearer
    public static String tokenType;
    //鉴权token
    public static String accessToken;
    //刷新token
    public static String refreshToken;

    public void login() throws ClientException {
        getPublicKey();
        userPasswordAuth();
    }

    public void keepAlive() throws ClientException {
        userPasswordRefreshToken();
    }

    private void getPublicKey() throws ClientException {
        log.info("----开始执行----{}------请求地址:{}", "用户密码模式-获取公钥", publicKeyUrl);
        log.info(dahuaIccUrl + publicKeyUrl);
        IccHttpHttpRequest pubRequest = new IccHttpHttpRequest(dahuaIccUrl + publicKeyUrl, Method.GET);
        String pubBody = pubRequest.execute();
        OauthPublicKeyResponse keyResp =  BeanUtil.toBean(pubBody, OauthPublicKeyResponse.class);
        log.info("----结束执行----{}------返回报文:{}", "用户密码模式-获取公钥", keyResp);
        publicKey = keyResp.getData().getPublicKey();
    }

    /**
     * 用户密码模式-认证申请
     * @throws ClientException
     */
    private void userPasswordAuth() throws ClientException {
        log.info("----开始执行----{}------请求地址:{}", "用户密码模式-认证申请",userPasswordAuthUrl);
        Map<String, Object> map = new HashMap();
        map.put("grant_type", "password");
        map.put("username", dahuaAccount);
        map.put("password", SignUtil.encryptRSA(dahuaPassword,publicKey));
        map.put("client_id", dahuaClientId);
        map.put("client_secret", dahuaClientSecret);
        map.put("public_key", publicKey);
        IccHttpHttpRequest pr = new IccHttpHttpRequest(dahuaIccUrl + userPasswordAuthUrl, Method.POST, JSONUtil.toJsonStr(map));
        String prBody = pr.execute();
        IccTokenResponse keyResp = BeanUtil.toBean(prBody, IccTokenResponse.class);
        log.info("----结束执行----{}------返回报文:{}", "用户密码模式-认证申请",keyResp);
        accessToken = keyResp.getData().getAccess_token();
        refreshToken = keyResp.getData().getRefresh_token();
    }

    /**
     * 用户密码模式_刷新token
     * @throws ClientException
     */
    private void userPasswordRefreshToken() throws ClientException {
        log.info("----开始执行----{}------请求地址:{}", "用户密码模式_刷新token",userPasswordRefreshTokenUrl);
        Map<String, Object> map = new HashMap();
        map.put("grant_type", GrantType.refresh_token.name());
        map.put("client_id", dahuaClientId);
        map.put("client_secret", dahuaClientSecret);
        map.put("refresh_token", refreshToken);
        IccHttpHttpRequest pr = new IccHttpHttpRequest(dahuaIccUrl + userPasswordRefreshTokenUrl, Method.POST, JSONUtil.toJsonStr(map));
        String prBody = pr.execute();
        IccTokenResponse keyResp = BeanUtil.toBean(prBody, IccTokenResponse.class);
        log.info("----结束执行----{}------返回报文:{}", "用户密码模式_刷新token",prBody);
        accessToken = keyResp.getData().getAccess_token();
        refreshToken = keyResp.getData().getRefresh_token();
    }

}
