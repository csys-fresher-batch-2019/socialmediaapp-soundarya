package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class FriendRequestClass {
	 private static final Logger LOGGER = Logger.getInstance();
	 private String requestor;
	 private String acceptor;
	 private String currentStatus;
	
	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	@Override
	public String toString() {
		return "friendRequestClass [requestor=" + requestor + ", acceptor=" + acceptor + ", currentStatus="
				+ currentStatus + "]";
	}
	
	public void insertRequest(FriendRequestClass ins)
	{
		String sql = "insert into friend_request (requestor,acceptor) values (?,?)";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst =con.prepareStatement(sql)) {
			
			LOGGER.debug(sql);
			pst.setString(1,ins.requestor);
			pst.setString(2,ins.acceptor);
			//pst.setString(3,ins.currentStatus);
			
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Row inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public List<FriendRequestClass> getFriendrequest(String requestor,String currentStatus){
		List<FriendRequestClass> l = new ArrayList<FriendRequestClass>();
		String sql = "select * from friend_request where requestor = '"+requestor+"' and current_status = '"+currentStatus+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql)) {
			
		    while(rs.next())
			{
		    
				String req=rs.getString("requestor");
				LOGGER.debug(req);
				String acp=rs.getString("acceptor");
				LOGGER.debug(acp);
				String status=rs.getString("current_status");
				LOGGER.debug(status);
				
				FriendRequestClass f=new FriendRequestClass();
				f.setRequestor(req);
				f.setAcceptor(acp);
				f.setCurrentStatus(status);
				
				l.add(f);
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
		
		
	}

	public List<FriendRequestClass> getRequestorList(String requestor){
		List<FriendRequestClass> l = new ArrayList<FriendRequestClass>();
		String sql = "select * from friend_request where requestor = '"+requestor+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql)) 
		{
					    while(rs.next())
			{
		    
				String req=rs.getString("requestor");
				LOGGER.debug(req);
				String acp=rs.getString("acceptor");
				LOGGER.debug(acp);
				String status=rs.getString("current_status");
				LOGGER.debug(status);
				
				
				FriendRequestClass f=new FriendRequestClass();
				f.setRequestor(req);
				f.setAcceptor(acp);
				f.setCurrentStatus(status);
				
				l.add(f);
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}
	//request for me
	
	public List<FriendRequestClass> getAcceptorList(String acceptor){
		List<FriendRequestClass> l = new ArrayList<FriendRequestClass>();
		String sql = "select * from friend_request where acceptor = '"+acceptor+"'";
		try (Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql)){
			
		    while(rs.next())
			{
		    
		    	String acp=rs.getString("acceptor");
				LOGGER.debug(acp);
				String req=rs.getString("requestor");
				LOGGER.debug(req);
				String status=rs.getString("current_status");
				LOGGER.debug(status);
				
				FriendRequestClass f=new FriendRequestClass();
				f.setRequestor(req);
				f.setAcceptor(acp);
				f.setCurrentStatus(status);
				
				l.add(f);
				
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}

	public void updateStatus(String currentStatus,String requestor,String acceptor)
	{
		String sql = "update friend_request set current_status='"+currentStatus+"' where requestor=? and acceptor=?";
		try(Connection con=ConnectionUtil.conMethod();
			    PreparedStatement pst=con.prepareStatement(sql)) {
			
		    pst.setString(1, requestor);
		    pst.setString(2, acceptor);
		    LOGGER.debug(sql);
		    pst.executeUpdate();
		    LOGGER.debug("Row updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
