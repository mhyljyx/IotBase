package com.tztang.service;

import com.tztang.service.pojo.params.LangTongDoorPointParams;
import com.tztang.service.pojo.params.LangTongAccessInfoParams;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface LangtongDataBaseService {

  //读取门禁点位数据
  List<LangTongDoorPointParams> readLangTongDoorPoint() throws SQLException;

  //读取通行记录
  List<LangTongAccessInfoParams> readLangTongAccessInfo(Date dateTime);

}
