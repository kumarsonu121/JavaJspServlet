package com.fastenal.servlets;

import java.io.IOException;
import java.util.HashSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fastenal.Database.SignupDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Signup")
public class SignupValidate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    final Logger logger = LogManager.getLogger(SignupValidate.class);
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		logger.info("SignupValidate:doPost entered method");
		String uname= req.getParameter("uname");
		String pass= req.getParameter("pass");
		String cpass= req.getParameter("cpass");
		HashSet<String> set= new HashSet<String>();
		set.add(pass);
		HttpSession session= req.getSession();
		
		if(set.contains(cpass))
		{
			SignupDAO sd= new SignupDAO();
			try {
				if(sd.insertUser(uname, pass))
				{
				session.setAttribute("username", uname);
				session.setAttribute("password", pass);
				logger.info("SinupValidate:doPost exiting method");
				res.sendRedirect("Videos.jsp");
				}
				else
				{
					session.setAttribute("flag", "false");
					logger.info("SinupValidate:doPost exiting method");
					res.sendRedirect("SignupPage.jsp");
				}
			} catch (Exception e) {
				logger.error("unable to redirect"+ e.getMessage());
			}
		}
		else
		{
			try {
				session.setAttribute("match", "false");
				res.sendRedirect("SignupPage.jsp");
			} catch (IOException e) {
				logger.error("unable to redirect");
			}
		}
	}
	

}
