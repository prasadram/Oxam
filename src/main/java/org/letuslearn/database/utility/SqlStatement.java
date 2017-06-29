// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import org.letuslearn.database.connection.service.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author aksharaaaa This Class gives the SQL Statements.
 */

public class SqlStatement {
  Connection connection = ConnectionProvider.getInstance().getConnection();

  public String getSelectStatment() {
    String s = "";

    return s;

  }

  public String getInsertStatment(String tableName) {
    System.out.println("In SQL Statement ");
    String s = "";
    try {
      TableMetadataUtility tableMetadata = new TableMetadataUtility(connection);
      s = "INSERT INTO " + tableName + tableMetadata.getColumns(tableName);
    } catch (SQLException e) {

    }

    return s;

  }

}
