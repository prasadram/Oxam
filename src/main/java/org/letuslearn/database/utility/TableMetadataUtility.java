// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author aksharaaaa This class Validates the User login.
 * 
 * 
 */
public class TableMetadataUtility {
  private Connection connection;

  public TableMetadataUtility(Connection con) {
    connection = con;
  }

  public String getColumns(String tableName) throws SQLException {

    StringBuffer sb = new StringBuffer("(");
    StringBuffer sbValues = new StringBuffer(" VALUES (");
    System.out.println("In Conection " + connection);
    java.sql.DatabaseMetaData metadata = connection.getMetaData();

    ResultSet rscolumns = metadata.getColumns(connection.getCatalog(), null, tableName, null);
    System.out.println(rscolumns.getRow());
    while (rscolumns.next()) {

      // rscolumns.getString(i);

      System.out.println("columns " + rscolumns.getString("COLUMN_NAME"));
      if (rscolumns.isLast()) {
        sbValues.append("?)");
        sb.append(rscolumns.getString("COLUMN_NAME")).append(")");
      } else {
        sbValues.append("?,");
        sb.append(rscolumns.getString("COLUMN_NAME")).append(",");
      }
    }

    return sb.append(sbValues).toString();
  }
}
