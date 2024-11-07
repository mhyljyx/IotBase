package com.tztang.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.tztang.config.DataSourceConfig;
import com.tztang.service.LangtongDataBaseService;
import com.tztang.service.pojo.params.LangTongDoorPointParams;
import com.tztang.service.pojo.params.LangTongAccessInfoParams;
import com.tztang.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LangtongDataBaseServiceImpl implements LangtongDataBaseService {

  @Autowired
  private DataSourceConfig dataSourceConfig;

  public List<LangTongDoorPointParams> readLangTongDoorPoint() {
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet resultSet = null;
    List<LangTongDoorPointParams> doorPointList = new ArrayList<>();
    try {
      conn = dataSourceConfig.createConn();
      // 创建PreparedStatement对象
      prep = conn.prepareStatement("select EquptID,EquptName,EquptStatus from Equipment");
      // 执行查询
      resultSet = prep.executeQuery();
      while (resultSet.next()) {
        LangTongDoorPointParams doorPoint = new LangTongDoorPointParams();
        doorPoint.setSrcIndex(resultSet.getString("EquptID"));
        doorPoint.setName(resultSet.getString("EquptName"));
        doorPointList.add(doorPoint);
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
      log.error(e.getMessage());
    } finally {
      // 关闭资源
      try {
        if (resultSet != null) resultSet.close();
        if (prep != null) prep.close();
        if (conn != null) conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return doorPointList;
  }

  public List<LangTongAccessInfoParams> readLangTongAccessInfo(Date dateTime) {
    Connection conn = null;
    PreparedStatement prep = null;
    ResultSet resultSet = null;
    List<LangTongAccessInfoParams> accessInfoList = new ArrayList<>();
    try {
      conn = dataSourceConfig.createConn();
      // 创建PreparedStatement对象
      prep = conn.prepareStatement(
        "select CAST(CardRecord.DataTime-2 as datetime) as datetime,CardRecord.PersonnelID,CardRecord.EquptID,v_FPPersonnel.PName,CardRecord.CodeIndex,CardRecord.PortNum\n" +
          " from CardRecord CardRecord\n" +
          " left join v_FPPersonnel v_FPPersonnel on CardRecord.PersonnelID = v_FPPersonnel.PersonnelID\n" +
          " where CAST(CardRecord.Datatime-2 as datetime) > ?\n" +
          " order by CardRecord.DataTime desc"
      );
      if (ObjectUtil.isNull(dateTime)) {
        return accessInfoList;
      }
      prep.setString(1, DateUtils.formatDateTime(DateUtils.date(dateTime.getTime() + 1000)));
      prep.setString(1, DateUtils.formatDateTime(DateUtils.beginOfDay(DateUtils.date())));
      //执行查询
      resultSet = prep.executeQuery();
      while (resultSet.next()) {
        LangTongAccessInfoParams accessInfo = new LangTongAccessInfoParams();
        accessInfo.setUserId(resultSet.getString("PersonnelID"));
        accessInfo.setUserName(resultSet.getString("PName"));
        accessInfo.setSrcIndex(resultSet.getString("EquptID"));
        accessInfo.setPassTime(DateUtils.transTimeToUTCDate(resultSet.getString("datetime")));
        accessInfo.setPortNum(Integer.parseInt(resultSet.getString("PortNum")));
        accessInfoList.add(accessInfo);
      }
    } catch (SQLException | ClassNotFoundException | ParseException e) {
      e.printStackTrace();
      log.error(e.getMessage());
    } finally {
      // 关闭资源
      try {
        if (resultSet != null) resultSet.close();
        if (prep != null) prep.close();
        if (conn != null) conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return accessInfoList;
  }

}
