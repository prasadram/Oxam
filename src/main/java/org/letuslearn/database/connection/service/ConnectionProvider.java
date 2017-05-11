// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.connection.service;

import java.sql.Connection;

/**
 * 
 * @author aksharaaaa This class provided the Connection
 *
 */
public class ConnectionProvider {
  private static ConnectionProvider instance = new ConnectionProvider();

  public static ConnectionProvider getInstance() {
    return instance;
  }

  public static void setInstance(ConnectionProvider instance) {
    ConnectionProvider.instance = instance;
  }

  public Connection getConnection() {
    System.out.println("in Connection Provider");

    return ConnectionProviderUtility.getInstance().getRdbmsConnection();
  }
}
