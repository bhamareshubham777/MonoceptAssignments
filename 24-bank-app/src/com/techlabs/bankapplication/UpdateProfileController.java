package com.techlabs.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        
        HttpSession session = request.getSession();
        String firstName2 = (String) session.getAttribute("firstName");

        int customerId = BankDatabase.getInstance().getIdForPassbook(firstName2); 
        
        if(password.length() >= 7) {
        	BankDatabase.getInstance().updateProfile(firstName, lastName, password, customerId);
        	request.setAttribute("successMessage", "Profile Updated Successfully!!!");
        	request.getRequestDispatcher("CustomerHome.jsp").forward(request, response);
        } else {
   		 // User validation failed, show an error message
        	request.setAttribute("errorMessage", "Invalid username or password");
        	request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response); 
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
