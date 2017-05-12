// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.listeners;

import org.letuslearn.database.utility.ConnectionParametersProvider;
import org.letuslearn.database.utility.OEPropertiesProvider;

import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author aksharaaaa This is used to initialize the ConnectionParametersProvided.java.
 * 
 *
 */
public class InitializeParameters {
  private static final Logger logger = Logger.getLogger("InitializeParameters");

  public InitializeParameters() {
    // OEPropertiesProvider oepp = OEPropertiesProvider.getInstance();

    setConnectionParameters();
  }

  private static ConnectionParametersProvider cpp = null;
  static Properties props = null;

  public static ConnectionParametersProvider getCpp() {
    return cpp;
  }

  public static void setCpp(ConnectionParametersProvider cpp) {
    InitializeParameters.cpp = cpp;
  }

  private static InitializeParameters instance = new InitializeParameters();

  public static InitializeParameters getInstance() {
    return instance;
  }

  public static void setInstance(InitializeParameters instance) {
    InitializeParameters.instance = instance;
  }

  public static void setConnectionParameters() {

    OEPropertiesProvider oepp = OEPropertiesProvider.getInstance();
    props = oepp.getProperties();
    logger.info("INITIAL PARAMETERS in dal object ");

    // ConnectionParametersProvider cpp = new ConnectionParametersProvider();
    cpp.setDbUrl(props.getProperty("db.url"));
    cpp.setName(props.getProperty("db.name"));
    cpp.setAuth(props.getProperty("db.auth"));
    cpp.setType(props.getProperty("db.type"));
    cpp.setDbDriver(props.getProperty("db.driver"));
    cpp.setDbDatabase(props.getProperty("db.database"));
    cpp.setDbUserName(props.getProperty("db.systemUser"));
    cpp.setDbPassword(props.getProperty("db.systemPassword"));

    logger.info("Name " + cpp.getName());
    logger.info("Auth " + cpp.getAuth());
    logger.info("Type " + cpp.getType());
    logger.info("url " + cpp.getDbUrl());
    logger.info("driver " + cpp.getDbDriver());
    logger.info("username " + cpp.getDbUserName());
    logger.info("password " + cpp.getDbPassword());
  }
}
