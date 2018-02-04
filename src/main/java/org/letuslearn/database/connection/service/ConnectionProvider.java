// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.connection.service;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author aksharaaaa This class provided the Connection
 *
 */
public class ConnectionProvider implements ConnectionProviderInterface {
  //private Logger log = Logger.getLogger("ConnectionProvider");
  private ConnectionProvider() {

  }
  private static ConnectionProvider instance;

  public static ConnectionProvider getInstance() {
    if (null == instance) {
      instance = new ConnectionProvider();
    }
    return instance;
  }
  @Override
  public Connection getConnection() {
    Connection connection = null;
    DataSource ds;

    try {
      InitialContext context = new InitialContext(); // context.PROVIDER_URL // Context con = new
      // This is by using JNDI
      ds = (DataSource) context.lookup("java:comp/env/jdbc/postgres");

      connection = ds.getConnection();

    } catch (NamingException ne) {
      ne.printStackTrace();
    } catch (SQLException sql) {
      sql.printStackTrace();
    }

    return connection;
  }
}
