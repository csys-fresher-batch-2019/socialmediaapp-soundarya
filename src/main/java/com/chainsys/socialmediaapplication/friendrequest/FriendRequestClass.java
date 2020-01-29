package com.chainsys.socialmediaapplication.friendrequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.List;

public class FriendRequestClass {
	
	public String requestor;
	public String acceptor;
	public String currentStatus;
	
	@Override
	public String toString() {
		return "friendRequestClass [requestor=" + requestor + ", acceptor=" + acceptor + ", currentStatus="
				+ currentStatus + "]";
	}
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println("connected");
		return con;
	}
	void insertRequest(FriendRequestClass ins)
	{
		try {
			Connection con=conMethod();
			String sql = "insert into friend_request (requestor,acceptor) values (?,?)";
			System.out.println(sql);
			PreparedStatement pst =con.prepareStatement(sql);
			
			pst.setString(1,ins.requestor);
			pst.setString(2,ins.acceptor);
			//pst.setString(3,ins.currentStatus);
			
			int rows=pst.executeUpdate();
			System.out.println(rows+"Row inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	String[] getFriendrequest(String requestor,String currentStatus){
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select * from friend_request where requestor = '"+requestor+"' and current_status = '"+currentStatus+"'";
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
			{
		    
				String req=rs.getString("requestor");
				System.out.println(req);
				String acp=rs.getString("acceptor");
				System.out.println(acp);
				String status=rs.getString("current_status");
				System.out.println(status);
			}
		    System.out.println(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

	String[] getRequestorList(String requestor){
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select * from friend_request where requestor = '"+requestor+"'";
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
			{
		    
				String req=rs.getString("requestor");
				System.out.println(req);
				String acp=rs.getString("acceptor");
				System.out.println(acp);
				String status=rs.getString("current_status");
				System.out.println(status);
			}
		    System.out.println(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	void updateStatus(String currentStatus,String requestor,String acceptor)
	{
		try {
			Connection con=conMethod();
		  //  Statement =con.createStatement();
		    String sql = "update friend_request set current_status='"+currentStatus+"' where requestor=? and acceptor=?";
		    PreparedStatement pst=con.prepareStatement(sql);
		    pst.setString(1, requestor);
		    pst.setString(2, acceptor);
		    System.out.println(sql);
		    pst.executeUpdate();
		    System.out.println("Row updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
