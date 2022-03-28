package com.fastenal.passwordEncryption;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest; 

public class PassHashGenerator {
 
 public static String generateHash(String password)
 {
	 final Logger logger = LogManager.getLogger(PassHashGenerator.class);
	 logger.info("PassHashGenerator:generateHash Enetered method");
	 String encryptedpassword = null;
	 try   
     {  
         MessageDigest m = MessageDigest.getInstance("MD5");  
         m.update(password.getBytes());  
         byte[] bytes = m.digest();  
         StringBuilder s = new StringBuilder();  
         for(int i=0; i< bytes.length ;i++) {  
             s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
         }  
         encryptedpassword = s.toString();  
     }   
     catch (NoSuchAlgorithmException e)   
     {  
         logger.error("error encrypting password", e.getMessage()); 
     }  
	 logger.info("PassHashGenerator:generateHash exiting method");
	 return encryptedpassword;
 }
}
