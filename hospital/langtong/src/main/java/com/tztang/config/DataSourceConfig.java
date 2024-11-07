package com.tztang.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Configuration
public class DataSourceConfig {

  @Autowired
  private DataBaseConfig dataBaseConfig;

  public Connection createConn() throws ClassNotFoundException, SQLException {
    try {
      Class.forName(dataBaseConfig.getDriverClassName());
      Connection conn = DriverManager.getConnection(dataBaseConfig.getUrl(), dataBaseConfig.getUsername(), dataBaseConfig.getPassword());
      log.info("sqlserver连接建立成功");
      return conn;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new SQLException(throwables.getMessage());
    }
  }

}
