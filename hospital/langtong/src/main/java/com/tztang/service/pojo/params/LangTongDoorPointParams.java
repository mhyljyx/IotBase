package com.tztang.service.pojo.params;

/**
 * 朗通门禁点位参数
 * @author tztang
 * @since 2024/10/24
 */
public class LangTongDoorPointParams {

  //点位id
  private String srcIndex;

  //点位名称
  private String name;

  public String getSrcIndex() {
    return srcIndex;
  }

  public void setSrcIndex(String srcIndex) {
    this.srcIndex = srcIndex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
