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
import com.tztang.dahua.config.IccConfig;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@Component
public class IccLoginHelper {

    @Resource
    private IccConfig iccConfig;

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
        log.info("----开始执行----{}------请求地址:{}", "用户密码模式-获取公钥", iccConfig.getIccOauth().getPublicKeyUrl());
        IccHttpHttpRequest pubRequest = new IccHttpHttpRequest(iccConfig.getDahuaIccUrl() + iccConfig.getIccOauth().getPublicKeyUrl(), Method.GET);
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
        log.info("----开始执行----{}------请求地址:{}", "用户密码模式-认证申请", iccConfig.getIccOauth().getUserPasswordAuthUrl());
        Map<String, Object> map = new HashMap();
        map.put("grant_type", "password");
        map.put("username", iccConfig.getDahuaAccount());
        map.put("password", SignUtil.encryptRSA(iccConfig.getDahuaPassword(), publicKey));
        map.put("client_id", iccConfig.getDahuaClientId());
        map.put("client_secret", iccConfig.getDahuaClientSecret());
        map.put("public_key", publicKey);
        IccHttpHttpRequest pr = new IccHttpHttpRequest(iccConfig.getDahuaIccUrl() + iccConfig.getIccOauth().getUserPasswordAuthUrl(), Method.POST, JSONUtil.toJsonStr(map));
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
        log.info("----开始执行----{}------请求地址:{}", "用户密码模式_刷新token",iccConfig.getIccOauth().getUserPasswordRefreshTokenUrl());
        Map<String, Object> map = new HashMap();
        map.put("grant_type", GrantType.refresh_token.name());
        map.put("client_id", iccConfig.getDahuaClientId());
        map.put("client_secret", iccConfig.getDahuaClientSecret());
        map.put("refresh_token", refreshToken);
        IccHttpHttpRequest pr = new IccHttpHttpRequest(iccConfig.getDahuaIccUrl() + iccConfig.getIccOauth().getUserPasswordRefreshTokenUrl(), Method.POST, JSONUtil.toJsonStr(map));
        String prBody = pr.execute();
        IccTokenResponse keyResp = BeanUtil.toBean(prBody, IccTokenResponse.class);
        log.info("----结束执行----{}------返回报文:{}", "用户密码模式_刷新token",prBody);
        accessToken = keyResp.getData().getAccess_token();
        refreshToken = keyResp.getData().getRefresh_token();
    }

}
