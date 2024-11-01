package com.xinran.dahua.model;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;
import com.dahuatech.icc.oauth.profile.IccProfile;

/** + 封装实时拉流request */
public class HlsUrlRequest extends AbstractIccRequest<HlsUrlResponse> {
  /**
   * 码流类型。
   *
   * <p>1-主码流，2-辅码流
   */
  private String streamType;
  /**
   * 通道编码
   *
   * <p>例 1000150$7$0$0
   */
  private String channelId;

  public HlsUrlRequest(String channelId, String streamType) throws ClientException {
    super(IccProfile.URL_SCHEME +"/evo-apigw/admin/API/video/stream/realtime", Method.POST);
    String body =
        "{\"clientType\":\"WINPC\",\"clientMac\":\"30:9c:23:79:40:08\",\"clientPushId\":\"\",\"project\":\"\",\"method\":\"\",\"data\":{\"channelId\":\""+channelId+"\",\"streamType\":\""+streamType+"\",\"type\":\"hls\"}}";
    httpRequest.body(body);
  }

  @Override
  public Class<HlsUrlResponse> getResponseClass() {
    return HlsUrlResponse.class;
  }
}
