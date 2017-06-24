// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.connection.service;

import java.sql.Connection;

/**
 * 
 * @author aksharaaaa This class provided the Connection
 *
 */
public class ConnectionProvider {
  private ConnectionProvider() {

  }

  private static ConnectionProvider instance;

  public static ConnectionProvider getInstance() {
    if (null == instance) {
      instance = new ConnectionProvider();
    }
    return instance;
  }

  public Connection getConnection() {
    System.out.println("in Connection Provider");

    return ConnectionProviderUtility.getInstance().getRdbmsConnection();
  }
}
