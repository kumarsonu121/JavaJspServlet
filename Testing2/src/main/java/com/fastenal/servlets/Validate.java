package com.fastenal.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fastenal.Database.LoginDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Validate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger loggerlogin = LogManager.getLogger(Validate.class);
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		loggerlogin.info("Validate:doPost entering method");
		String uname= req.getParameter("uname");
		String pass= req.getParameter("pass");
		LoginDAO db= new LoginDAO();
			HttpSession session= req.getSession();
			try {
				if(db.checkUser(uname, pass))
				{
				session.setAttribute("username", uname);
				session.setAttribute("password", pass);
				loggerlogin.info("Validate:doPost exiting method");
				res.sendRedirect("Videos.jsp");
				}
				else
				{
					session.setAttribute("flag", "false");
					loggerlogin.info("Validate:doPost exiting method");
					res.sendRedirect("LoginPage.jsp");
				}
			} catch (Exception e) {
				loggerlogin.error("Redirect request suspended due to errors" + e.getMessage());;
			}
	}

}
