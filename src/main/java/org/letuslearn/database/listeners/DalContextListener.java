// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.listeners;

import org.letuslearn.database.utility.OEPropertiesProvider;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author aksharaaaa Initializes the dal layer when the servlet container starts.
 * 
 * 
 */
public class DalContextListener implements ServletContextListener {
  private static final Logger logger = Logger.getLogger("DalContextListener");

  private static Properties oeProperties = null;

  public static Properties getOeProperties() {
    return oeProperties;
  }

  public static void setOeProperties(Properties oeProperties) {
    DalContextListener.oeProperties = oeProperties;
  }

  private static ServletContext servletContext = null;
  private static DalContextListener instance = new DalContextListener();

  public static DalContextListener getInstance() {
    return instance;
  }

  public static void setInstance(DalContextListener instance) {
    DalContextListener.instance = instance;
  }

  public static ServletContext getServletContext() {
    return servletContext;
  }

  public static void setServletContext(ServletContext servletContext) {
    DalContextListener.servletContext = servletContext;
  }

  @Override
  public void contextInitialized(ServletContextEvent event) {

    final ServletContext context = event.getServletContext();
    this.setServletContext(context);
    try {
      // final InputStream is =
      // context.getClass().getClassLoader().getResourceAsStream("config.properties")
      final InputStream is = context.getResourceAsStream("/WEB-INF/config.properties");

      if (is.equals("")) {
        logger.info("Debug 1");
      }
      if (is != null) {
        logger.info("In servletContextEvent IF " + is.available());

        OEPropertiesProvider.getInstance().setProperties(is);
      }

    } catch (Exception e) {

    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    // this.setInstance(null);
  }
}
