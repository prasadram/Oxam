// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.utility;

import java.io.InputStream;
import java.util.Properties;
//import java.util.logging.Logger;
import java.util.logging.Logger;

/**
 * 
 * @author aksharaaaa This Property class is initialized while starting the tomcat server.
 *
 */
public class OEPropertiesProvider {
  private static OEPropertiesProvider instance = new OEPropertiesProvider();
  private static final Logger logger = Logger.getLogger("OEPropertiesProvider");
  private Properties oeProperties = new Properties();

  public static OEPropertiesProvider getInstance() {
    return instance;
  }

  public static void setInstance(OEPropertiesProvider instance) {
    OEPropertiesProvider.instance = instance;
  }

  public Properties getProperties() {
    logger.info("IN OEProperties Instance");
    return oeProperties;
  }

  public void setProperties(Properties props) {
    if (oeProperties != null) {
      logger.info("Already loaded properties file");
    }
    System.out.println(props.get("db.url"));
    oeProperties = new Properties();
    oeProperties.putAll(props);

  }

  public void setProperties(InputStream is) {
    if (oeProperties != null) {
      logger.info("Already loaded properties file");
    }
    try {
      oeProperties.load(is);
      is.close();
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }
}
