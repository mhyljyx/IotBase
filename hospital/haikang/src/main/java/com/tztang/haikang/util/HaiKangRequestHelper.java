package com.tztang.haikang.util;

import com.hikvision.artemis.sdk.ArtemisHttpUtil;
import com.hikvision.artemis.sdk.config.ArtemisConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class HaiKangRequestHelper {

    @Value("${haikang.isc.host}")
    private String host;
    @Value("${haikang.isc.app-key}")
    private String appKey;
    @Value("${haikang.isc.app-secret}")
    private String appSecret;
    //设置OpenAPI接口的上下文
    @Value("${haikang.isc.artemis-path}")
    private String artemisPath;
    //设置参数提交方式
    @Value("${haikang.isc.content-type}")
    private String contentType;

    @PostConstruct
    private void initArtemisConfig() {
        ArtemisConfig.host = host; // 平台的ip端口
        ArtemisConfig.appKey = appKey;  // 密钥appkey
        ArtemisConfig.appSecret = appSecret;// 密钥appSecret
    }

    public String post(String api, String body) {
        Map<String, String> path = new HashMap<String, String>(2) {
            {
                put("https://", artemisPath + api);//根据现场环境部署确认是http还是https
            }
        };
        String data = ArtemisHttpUtil.doPostStringArtemis(path, body, null, null, contentType, null);// post请求application/json类型参数
        return data;
    }

}
