package com.chainsys.socialmediaapplication.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginClass implements LoginDAO{
	
	public String loginEmail;
	public String loginPassword; 
	
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println("connected");
		return con;
	}
	
	public String login(String email,String password)
	{
		try{
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
			String sql = "select login_email,login_password from login where login_email='"+email+"' and login_password='"+password+"'";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String email1=rs.getString("login_email");
				//System.out.println(email1);
				String password1=rs.getString("login_password");
				//System.out.println(password1);
				if(email1.equals(email) && password1.equals(password))
					System.out.println(email1+" Successfully Logged in");
			}
			else
			{
				System.out.println("Login Failed");	

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	public void updatePassword(String email,String oldPassword,String newPassword)
	{
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "update login set login_password = '"+newPassword+"' where login_email='"+email+"'";
		    System.out.println(sql);
		    int rows=stmt.executeUpdate(sql);
		    System.out.println(rows +" password updated");
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void addLogin(LoginClass add) {
		try {
			Connection con=conMethod();
			String sql = "insert into login(login_email,login_password) values(?,?)";  
			System.out.println(sql);
			PreparedStatement pst =con.prepareStatement(sql);
			//pst.setInt(1, postId);
			pst.setString(1,add.loginEmail);
			pst.setString(2,add.loginPassword);
			
	
			int rows=pst.executeUpdate();
			System.out.println(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	


}
