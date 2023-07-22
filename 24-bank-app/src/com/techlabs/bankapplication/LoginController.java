package com.techlabs.bankapplication;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginType = request.getParameter("loginType");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
			
        request.setAttribute("name", firstName);

        boolean authenticated = BankDatabase.getInstance().authenticateUser(loginType, firstName, lastName, password);

        if (authenticated) {
       		if (loginType.equals("admin")) {
//       			List<Admin> admins = BankDatabase.getInstance().getAdmin();
//       			for(Admin admin : admins) {
//       				if(admin.getFirstName().contentEquals(firstName) && admin.getLastName().contentEquals(lastName) && admin.getPassword().contentEquals(password)) {
//       					HttpSession session = request.getSession();
//       					session.setAttribute("adminSession", admin);
       					request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
       					
//       				}
//       			}
        	} else if (loginType.equals("customer")) {
//        		List<Customer> customers = BankDatabase.getInstance().getCustomer();
//        		for(Customer customer : customers) {
//        			if(customer.getFirstName().contentEquals(firstName) && customer.getLastName().contentEquals(lastName) && customer.getPassword().contentEquals(password)) {
//        				HttpSession session = request.getSession();
//       					session.setAttribute("customerSession", customer);
       					request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
//       					
//        			}
//        		}
        	}
        } else {
        		 // User validation failed, show an error message
	        request.setAttribute("errorMessage", "Invalid username or password");
	        request.getRequestDispatcher("Login.jsp").forward(request, response); 
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
