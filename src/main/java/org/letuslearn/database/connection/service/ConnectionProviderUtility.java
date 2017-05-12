// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.connection.service;

import org.letuslearn.database.listeners.DalContextListener;
import org.letuslearn.database.listeners.InitializeParameters;
import org.letuslearn.database.utility.ConnectionParametersProvider;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

/**
 * @author aksharaaaa Provides the Connection.
 * 
 * 
 */
public class ConnectionProviderUtility {
  private static ConnectionProviderUtility instance = new ConnectionProviderUtility();
  private static ServletContext context = DalContextListener.getInstance().getServletContext();

  public static ServletContext getContext() {
    return context;
  }

  public static void setContext(ServletContext context) {
    ConnectionProviderUtility.context = context;
  }

  public static ConnectionProviderUtility getInstance() {
    return instance;
  }

  public static void setInstance(ConnectionProviderUtility instance) {
    ConnectionProviderUtility.instance = instance;
  }

  public Connection getRdbmsConnection() {
    System.out.println("In RDBMS");
    Connection connection = null;
    DataSource ds;

    try {
      InitializeParameters ip = InitializeParameters.getInstance();
      ConnectionParametersProvider cpp = ip.getCpp();

      InitialContext context = new InitialContext(); // context.PROVIDER_URL // Context con = new

      // Iterator it = context.getEnvironment().keySet().iterator();

      ds = (DataSource) context.lookup("java:comp/env/jdbc/postgres");
      System.out.println("DS " + ds);
      connection = ds.getConnection();
    } catch (Exception e) {
    }
    System.out.println(connection);

    return connection;
  }
}
