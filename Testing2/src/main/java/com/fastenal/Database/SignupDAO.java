package com.fastenal.Database;

import java.sql.*;
import com.fastenal.passwordEncryption.PassHashGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignupDAO {
	
	public boolean insertUser(String uname, String pass) throws SQLException {
		
		final Logger logger = LogManager.getLogger(SignupDAO.class);
		logger.info("SignupDAO:insertUser entered method");
	    final String url = "jdbc:mysql://localhost:3306/ksonu";
	    final String u_name = "ksonu"; 
	    final String u_pass = "@XYZWxyzw12";
		Connection con = null;
		PreparedStatement st = null;
		try {
			String sql= "insert into Users(user_name, user_password) values(?, ?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url, u_name, u_pass);
			st= con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, PassHashGenerator.generateHash(pass));
			int result= st.executeUpdate();
			
			if(result==1) {
				logger.info("SignupDAO:insertUser exiting method");
				return true;
			}
			
		} catch (Exception e) {
			logger.error("unable to connect to databse" + e.getMessage());
		}
		    finally {
		    	st.close();
		    	con.close();
		    }
		
		   return false;
	    }
	
	  }


