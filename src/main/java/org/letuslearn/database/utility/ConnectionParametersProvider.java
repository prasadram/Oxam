// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

/**
 * 
 * @author aksharaaaa This class is used to get the Database Properties initialized in
 *         InitializeParameters.java.
 */
public class ConnectionParametersProvider {
  private static ConnectionParametersProvider instance = new ConnectionParametersProvider();

  public static ConnectionParametersProvider getInstance() {
    return instance;
  }

  public static void setInstance(ConnectionParametersProvider instance) {
    ConnectionParametersProvider.instance = instance;
  }

  private static String dbUrl = null;
  private static String dbDriver = null;
  private static String dbUserName = null;
  private static String dbPassword = null;
  private static String dbDatabase = null;
  private static String name = null;
  private static String auth = null;

  public static String getName() {
    return name;
  }

  public static void setName(String name) {
    ConnectionParametersProvider.name = name;
  }

  public static String getAuth() {
    return auth;
  }

  public static void setAuth(String auth) {
    ConnectionParametersProvider.auth = auth;
  }

  public static String getType() {
    return type;
  }

  public static void setType(String type) {
    ConnectionParametersProvider.type = type;
  }

  private static String type = null;

  public static String getDbDatabase() {
    return dbDatabase;
  }

  public static void setDbDatabase(String dbDatabase) {
    ConnectionParametersProvider.dbDatabase = dbDatabase;
  }

  public static String getDbUrl() {
    return dbUrl;
  }

  public static void setDbUrl(String dbUrl) {
    ConnectionParametersProvider.dbUrl = dbUrl;
  }

  public static String getDbDriver() {
    return dbDriver;
  }

  public static void setDbDriver(String dbDriver) {
    ConnectionParametersProvider.dbDriver = dbDriver;
  }

  public static String getDbUserName() {
    return dbUserName;
  }

  public static void setDbUserName(String dbUserName) {
    ConnectionParametersProvider.dbUserName = dbUserName;
  }

  public static String getDbPassword() {
    return dbPassword;
  }

  public static void setDbPassword(String dbPassword) {
    ConnectionParametersProvider.dbPassword = dbPassword;
  }

}
