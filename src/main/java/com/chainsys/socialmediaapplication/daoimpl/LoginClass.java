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
	
	
	public String adminLogin(String email1, String password1) {
		String sql = "select login_email,login_password from login where login_email='"+email1+"' and login_password='"+password1+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			
			
			LOGGER.debug(sql);
			String str=null;
			if(rs.next())
			{
				str="success";
				String email=rs.getString("login_email");
				//LOGGER.debug(email1);
				String password=rs.getString("login_password");
				//LOGGER.debug(password1);
				if(email.equals(email1) && password.equals(password1))
					LOGGER.debug(email+" Successfully Logged in");
				return str;
			}
			else
			{
				str="failure";
				LOGGER.debug("Login Failed");	
				return str;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	public void updatePassword(String email,String oldPassword,String newPassword)
	{
		String sql = "update login set login_password = '"+newPassword+"' where login_email='"+email+"' and login_password='"+oldPassword+"'";
		try (Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();){
		    LOGGER.debug(sql);
		    int rows=stmt.executeUpdate(sql);
		    LOGGER.debug(rows +" password updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
