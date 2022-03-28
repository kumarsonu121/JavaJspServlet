package com.fastenal.servlets;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class SigningOut extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    final Logger logger = LogManager.getLogger(SigningOut.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		logger.info("SigningOut:doGet entering method");
		HttpSession session= req.getSession();
		session.removeAttribute("username");
		session.invalidate();
		try {
			logger.info("SigningOut:doGet exiting method");
			res.sendRedirect("Home.jsp");
		} catch (IOException e) {
			logger.error("could not redirect"+ e.getMessage());
		}
	}

}
