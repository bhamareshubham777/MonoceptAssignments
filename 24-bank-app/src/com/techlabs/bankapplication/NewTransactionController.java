package com.techlabs.bankapplication;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewTransactionController")
public class NewTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewTransactionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String transactionType = request.getParameter("transactionType");
	        String senderAccountNumber = request.getParameter("senderaccountnumber");
	        String recieverAccountNumber = request.getParameter("recieveraccountnumber");
	        double amount = Double.parseDouble(request.getParameter("amount"));
	        LocalDate date = LocalDate.now();

	        BankDatabase.getInstance().addNewTransaction(transactionType, senderAccountNumber, amount, date, recieverAccountNumber);
	       
	        response.sendRedirect("CustomerHome.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
