package com.techlabs.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateAccountController")
public class GenerateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GenerateAccountController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
        String balance = request.getParameter("balance");

        // Validate input

        if (customerId.isEmpty() || balance.isEmpty()) {
        	 request.setAttribute("errorMessage2", "Please provide customerId and amount!!!");
             request.getRequestDispatcher("GenerateAccount.jsp").forward(request, response); 
        }
        
        double balanced = Double.parseDouble(balance);
        if(balanced >= 5000) {
        	BankDatabase.getInstance().generateAccountById(customerId, balanced, request, response);
        	request.setAttribute("successMessage2", "Account Generated Successfully!!!");
            request.getRequestDispatcher("AdminHome.jsp").forward(request, response); 
        }else {
   		 // User validation failed, show an error message
        	request.setAttribute("errorMessage", "Insufficient Amount!!!");
        	request.getRequestDispatcher("GenerateAccount.jsp").forward(request, response); 
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
