// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import org.letuslearn.database.connection.service.ConnectionProvider;
import org.letuslearn.utils.StringUtility;

/**
 * @author aksharaaaa This Class gives the SQL Statements.
 */

public class SqlStatement {
  int columnCount;

  private Logger log = Logger.getLogger("SqlStatement");

  public String getSelectStatment() {
    String string = "";

    return string;

  }

  public String getInsertStatment(String tableName) {
    Connection connection = ConnectionProvider.getInstance().getConnection();

    String stringInsertStatement = "";
    stringInsertStatement = "INSERT INTO " + tableName + 
    getAllColumsString(connection, tableName) + getValuesString();
    return stringInsertStatement;
  }

  public String getAllColumsString(Connection connection, String tableName) {
    ResultSet rscolumns;
    StringUtility stringConcatination = new StringUtility();
    StringBuffer columnsWithCommaSeperated = new StringBuffer("");
    StringBuffer preparedColumnsString = new StringBuffer("(");

    try {
      DatabaseMetaData metadata = connection.getMetaData();
      rscolumns = metadata.getColumns(connection.getCatalog(), null, tableName, null);
      TableMetadataUtility tableMetadata = new TableMetadataUtility();
      columnCount = tableMetadata.getColumnCount(tableName);

      columnsWithCommaSeperated = stringConcatination
          .getCommaSepratedList(tableMetadata.getColumnsList(rscolumns));

    } catch (SQLException e) {
         e.printStackTrace();
    } finally {
      log.info("In Final stage");
    }
    preparedColumnsString
        .append(stringConcatination.replaceAtLastChar(columnsWithCommaSeperated, ")"));
    return preparedColumnsString.toString();
  }

  public String getValuesString() {
    StringBuffer sbValues = new StringBuffer(" VALUES (");
    while (columnCount > 0) {
      sbValues.append("?,");
      columnCount--;
    }
    sbValues.replace(sbValues.length() - 1, sbValues.length(), ")");

    return sbValues.toString();
  }

}
