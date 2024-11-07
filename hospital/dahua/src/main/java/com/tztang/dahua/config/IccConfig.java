package com.tztang.dahua.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * dahua icc平台登录鉴权参数
 */
@Configuration
@ConfigurationProperties(prefix = "dahua.icc")
public class IccConfig {

    private String dahuaIccUrl;

    private String dahuaAccount;

    private String dahuaPassword;

    private String dahuaClientId;

    private String dahuaClientSecret;

    private IccOauth iccOauth;

    public String getDahuaIccUrl() {
        return dahuaIccUrl;
    }

    public void setDahuaIccUrl(String dahuaIccUrl) {
        this.dahuaIccUrl = dahuaIccUrl;
    }

    public String getDahuaAccount() {
        return dahuaAccount;
    }

    public void setDahuaAccount(String dahuaAccount) {
        this.dahuaAccount = dahuaAccount;
    }

    public String getDahuaPassword() {
        return dahuaPassword;
    }

    public void setDahuaPassword(String dahuaPassword) {
        this.dahuaPassword = dahuaPassword;
    }

    public String getDahuaClientId() {
        return dahuaClientId;
    }

    public void setDahuaClientId(String dahuaClientId) {
        this.dahuaClientId = dahuaClientId;
    }

    public String getDahuaClientSecret() {
        return dahuaClientSecret;
    }

    public void setDahuaClientSecret(String dahuaClientSecret) {
        this.dahuaClientSecret = dahuaClientSecret;
    }

    public IccOauth getIccOauth() {
        return iccOauth;
    }

    public void setIccOauth(IccOauth iccOauth) {
        this.iccOauth = iccOauth;
    }

    public static class IccOauth {

        private String publicKeyUrl;

        private String userPasswordAuthUrl;

        private String userPasswordRefreshTokenUrl;

        public String getPublicKeyUrl() {
            return publicKeyUrl;
        }

        public void setPublicKeyUrl(String publicKeyUrl) {
            this.publicKeyUrl = publicKeyUrl;
        }

        public String getUserPasswordAuthUrl() {
            return userPasswordAuthUrl;
        }

        public void setUserPasswordAuthUrl(String userPasswordAuthUrl) {
            this.userPasswordAuthUrl = userPasswordAuthUrl;
        }

        public String getUserPasswordRefreshTokenUrl() {
            return userPasswordRefreshTokenUrl;
        }

        public void setUserPasswordRefreshTokenUrl(String userPasswordRefreshTokenUrl) {
            this.userPasswordRefreshTokenUrl = userPasswordRefreshTokenUrl;
        }
    }

}
