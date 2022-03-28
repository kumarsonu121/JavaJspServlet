package com.fastenal.Database;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fastenal.passwordEncryption.PassHashGenerator;

public class LoginDAO {
	
	public boolean checkUser(String uname, String pass) throws SQLException {
		
		final Logger logger = LogManager.getLogger(LoginDAO.class);
		logger.info("LoginDAO:checkUser entered the method");
		final String url="jdbc:mysql://localhost:3306/ksonu";
		final String u_name= "ksonu";
		final String u_pass= "@XYZWxyzw12";
		Connection con = null;
		PreparedStatement st = null;
		try {
			String sql= "SELECT * from Users where user_name= ? and user_password= ?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url, u_name, u_pass);
			st= con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, PassHashGenerator.generateHash(pass));
			ResultSet rs= st.executeQuery();
			
			if(rs.next()) {
				logger.info("LoginDAO:checkUser exiting method");
				return true;
			}	
		} catch (Exception e) {
			logger.error("error connecting to database" + e.getMessage());
		}
		
		 finally { 
			 st.close(); 
			 con.close(); 
			 }
		 
		
		return false;
	}

}
