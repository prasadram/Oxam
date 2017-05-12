// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.service;

import org.letuslearn.beans.data.User;
import org.letuslearn.database.connection.service.ConnectionProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author aksharaaaa This class Validates the User login.
 */
public class LoginService {

  Connection connection = ConnectionProvider.getInstance().getConnection();
  private static LoginService instance = new LoginService();

  public static LoginService getInstance() {
    return instance;
  }

  public static void setInstance(LoginService instance) {
    LoginService.instance = instance;
  }

  public boolean authenticate(String emailId, String password) {
    if (this.validate(emailId, password)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validate(String emailId, String password) {
    // connection = conn.getPostgresCon();

    boolean parity = false;
    // String checkUserSql = "select userid from userdetails where email = '" + emailId + "'";
    String parseuserPassword = "select flag from userdetails where email = '" + emailId
        + "' and password = '" + password + "'";
    try {
      if (connection == null) {
        throw new Exception("Connection not established");
      }
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(parseuserPassword);

      if (rs.next()) {
        // System.out.println("Row Number " + rs.getRow());
        parity = true;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return parity;
  }

  public boolean checkUsername(String emailId) {
    int use = 1;
    boolean parity = false;
    try {

      // connection = conn.getPostgresCon();
      String sql = "select userid from userdetails where email = '" + emailId + "'";

      // System.out.println(sql);
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      if (rs.next()) {
        while (rs.next()) {
          // use = rs.getInt("userid");
          // System.out.println("Row " + rs.getRow());
        }

        parity = true;
      } else {
        parity = false;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return parity;
  }

  public User getDetails(String emailId) {
    User user = new User();
    String sql = "SELECT studentname,age,gender FROM userdetails where email = '" + emailId + "'";
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      if (!rs.wasNull()) {
        while (rs.next()) {
          // System.out.println("Name in getDetails " + rs.getString("studentname"));
          user.setStudentName(rs.getString("studentname"));
          user.setAge(rs.getInt("age"));
          user.setGender(rs.getString("gender"));
        }
      }
    } catch (SQLException e) {

    }

    return user;
  }
}
