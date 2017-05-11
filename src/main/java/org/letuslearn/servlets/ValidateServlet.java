// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.servlets;

import org.letuslearn.beans.data.User;
import org.letuslearn.service.LoginService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validate.
 */
public class ValidateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValidateServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    request.isRequestedSessionIdValid();
    response.setContentType("text/html");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    LoginService ls = LoginService.getInstance();

    boolean checkUser = ls.checkUsername(username);

    boolean result = ls.authenticate(username, password);
    String message = "";
    if (username != null || username != "") {
      if (checkUser) {
        // request.getRequestDispatcher(message)
        if (result) {
          User user = ls.getDetails(username);
          request.setAttribute("user", user);
          request.setAttribute("error", message);
          RequestDispatcher rd = request.getRequestDispatcher("/show.jsp");
          rd.forward(request, response);
        } else {
          RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
          message = "Ur username and Password is Wrong.";
          request.setAttribute("error", message);
          request.setAttribute("parity", "wrong");
          rd.forward(request, response);

          return;
        }

      } else {
        // System.out.println("in else ");
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        message = "Ur username is not registered Yet.";
        request.setAttribute("error", message);
        request.setAttribute("parity", "not");
        rd.forward(request, response);
        return;
      }

    }

    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
