package com.techlabs.bankapplication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCustomerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if(password.length() >= 7) {
        	BankDatabase.getInstance().addCustomer(firstName, lastName, password);
        	request.setAttribute("successMessage", "Customer Added Successfully!!!");
        	request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
        } else {
   		 // User validation failed, show an error message
        	request.setAttribute("errorMessage", "Invalid username or password");
        	request.getRequestDispatcher("AddNewCustomer.jsp").forward(request, response); 
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
