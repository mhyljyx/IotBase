package com.example.langtong.service.pojo.params;

/**
 * 朗通门禁通行数据
 * @author tztang
 * @since 2024/10/24
 */
public class LangTongAccessInfoParams {

  //用户id
  private String userId;

  //用户名称
  private String userName;

  //进出方向 1入 0出
  private Integer portNum;

  //通行时间
  private String passTime;

  //通行点位id
  private String srcIndex;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Integer getPortNum() {
    return portNum;
  }

  public void setPortNum(Integer portNum) {
    this.portNum = portNum;
  }

  public String getPassTime() {
    return passTime;
  }

  public void setPassTime(String passTime) {
    this.passTime = passTime;
  }

  public String getSrcIndex() {
    return srcIndex;
  }

  public void setSrcIndex(String srcIndex) {
    this.srcIndex = srcIndex;
  }

}
