package com.techlabs.bankapplication;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewCustomersController")
public class ViewCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ViewCustomersController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer>customers=BankDatabase.getInstance().viewCustomers();
		
		request.setAttribute("customers", customers);
        request.getRequestDispatcher("ViewCustomers3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}