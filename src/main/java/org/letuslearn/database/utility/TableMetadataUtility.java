// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.letuslearn.database.connection.service.ConnectionProvider;

/**
 * @author aksharaaaa This class Validates the User login.
 * 
 * 
 */
public class TableMetadataUtility {
  private Logger log = Logger.getLogger("TableMetadataUtility");

  public List<String> getColumnsList(ResultSet rscolumns) throws SQLException {

    List<String> columnsList = new ArrayList<String>();

    while (rscolumns.next()) {
      columnsList.add(rscolumns.getString("COLUMN_NAME"));
    }

    return columnsList;
  }

  public int getColumnCount(String tableName) {
    int count = 0;

    String sqlSchemaQuery = " select * from " + tableName + "";
    try (
        Statement informationSchemaStatement = ConnectionProvider.getInstance().getConnection()
            .createStatement();
        ResultSet resultCount = informationSchemaStatement.executeQuery(sqlSchemaQuery);) {

      count = resultCount.getMetaData().getColumnCount();
      log.info("Count is " + count);
    } catch (SQLException e) {
      log.info("Connection is not created or Result ");
      e.printStackTrace();
    } finally {
      log.info("Finally Result ");
    }

    return count;
  }

}
