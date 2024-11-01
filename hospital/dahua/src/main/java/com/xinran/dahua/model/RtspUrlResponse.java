package com.xinran.dahua.model;

import com.dahuatech.icc.oauth.http.IccResponse;

/** + 封装实时拉流response */
public class RtspUrlResponse extends IccResponse {
  private RtspData data;

  public RtspData getData() {
    return data;
  }

  public String getRtspUrl() {
    return data.getUrl() + "?token=" + data.getToken();
  }

  public void setData(RtspData data) {
    this.data = data;
  }

  public static class RtspData {
    private String url;
    private String session;
    private String token;

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getSession() {
      return session;
    }

    public void setSession(String session) {
      this.session = session;
    }

    public String getToken() {
      return token;
    }

    public void setToken(String token) {
      this.token = token;
    }

    @Override
    public String toString() {
      return "RtspData{"
          + "url='"
          + url
          + '\''
          + ", session='"
          + session
          + '\''
          + ", token='"
          + token
          + '\''
          + '}';
    }
  }
}
