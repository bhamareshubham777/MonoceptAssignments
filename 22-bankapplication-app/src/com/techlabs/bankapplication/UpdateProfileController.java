package com.techlabs.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateProfileController")
public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateProfileController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        int customerId = 2; 
        
        BankDatabase.getInstance().updateProfile(firstName, lastName, password, customerId);

        response.sendRedirect("CustomerHome.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
