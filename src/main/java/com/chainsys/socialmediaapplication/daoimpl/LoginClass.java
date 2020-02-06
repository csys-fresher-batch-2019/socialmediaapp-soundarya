package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class LoginClass {
	private static final Logger LOGGER = Logger.getInstance();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public static Logger getLogger() {
		return LOGGER;
	}
	private String userName;
	private String userPassword;
	
	
	public void adminLogin(String email, String password) {
		String sql = "select login_email,login_password from login where login_email='"+email+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			
			
			LOGGER.debug(sql);
			
			if(rs.next())
			{
				String email1=rs.getString("login_email");
				//LOGGER.debug(email1);
				String password1=rs.getString("login_password");
				//LOGGER.debug(password1);
				if(email1.equals(email) && password1.equals(password))
					LOGGER.debug(email1+" Successfully Logged in");
			}
			else
			{
				LOGGER.debug("Login Failed");	

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
