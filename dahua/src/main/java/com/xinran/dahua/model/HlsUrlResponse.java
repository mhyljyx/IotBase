package com.xinran.dahua.model;

import com.dahuatech.icc.oauth.http.IccResponse;

/** + 封装实时拉流response */
public class HlsUrlResponse extends IccResponse {
  private HlsData data;

  public HlsData getData() {
    return data;
  }

  public String getHlsUrl() {
    return data.getUrl();
  }

  public void setData(HlsData data) {
    this.data = data;
  }

  public static class HlsData {
    private String url;

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }
  }
}
