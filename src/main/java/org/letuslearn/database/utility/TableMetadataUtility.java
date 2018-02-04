// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import org.letuslearn.database.connection.service.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author aksharaaaa This class Validates the User login.
 * 
 * 
 */
public class TableMetadataUtility {

  private Logger logger = Logger.getLogger("TableMetadataUtility");

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
    try {
      Statement informationSchemaStatement = ConnectionProvider.getInstance().getConnection()
          .createStatement();
      try {
          ResultSet resultCount = informationSchemaStatement.executeQuery(sqlSchemaQuery);
            try {
                count = resultCount.getMetaData().getColumnCount();
                logger.info("Count is " + count);
            } finally {
                resultCount.close();
            }
        } finally {
            informationSchemaStatement.close();
        }
    } catch (SQLException e) {
        logger.severe("In SQLException Catch ");
        e.printStackTrace();
    }
    return count;
  }
}
