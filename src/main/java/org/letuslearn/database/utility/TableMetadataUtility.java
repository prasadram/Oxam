// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import org.letuslearn.database.connection.service.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aksharaaaa This class Validates the User login.
 * 
 * 
 */
public class TableMetadataUtility {
  private List<String> columnsList = new ArrayList<String>();

  public List<String> getColumnsList() {
    return columnsList;
  }

  public TableMetadataUtility(ResultSet rscolumns) throws SQLException {

    while (rscolumns.next()) {

      columnsList.add(rscolumns.getString("COLUMN_NAME"));

    }

  }

  public int getColumnCount(String tableName) {
    int count = 0;
    try {
      String sqlSchemaQuery = " select * from " + tableName + "";

      Statement informationSchemaStatement = ConnectionProvider.getInstance().getConnection()
          .createStatement();

      ResultSet resultCount = informationSchemaStatement.executeQuery(sqlSchemaQuery);
      count = resultCount.getMetaData().getColumnCount();
      System.out.println("Count is " + count);
    } catch (SQLException e) {

    }

    return count;
  }

}
