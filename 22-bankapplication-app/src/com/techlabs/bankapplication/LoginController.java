package com.techlabs.bankapplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginType = request.getParameter("loginType");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        boolean authenticated = BankDatabase.getInstance().authenticateUser(loginType, firstName, lastName, password);

        if (authenticated) {
            if (loginType.equals("admin")) {
                response.sendRedirect("AdminHome.jsp");
            } else if (loginType.equals("customer")) {
                response.sendRedirect("CustomerHome.jsp");
            }
        } else {
            response.sendRedirect("Login.jsp"); // Redirect back to login page if authentication fails
        }
    }

    }

