package com.chainsys.socialmediaapplication.comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommentsClass {
	
	public  int cmtPostId;
	public String cmtEmail;
	public String cmts;
	
	
	@Override
	public String toString() {
		return "CommentsClass [cmtPostId=" + cmtPostId + ", cmtEmail=" + cmtEmail + ", cmts=" + cmts + "]";
	}
	
	
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println("connected");
		return con;
	}
	
	public void insertComments(CommentsClass ins)
	{
		try {
			Connection con=conMethod();
			String sql = "insert into comments (cmt_post_id,cmt_email,cmts,cmt_date) values (?,?,?,current_timestamp)";
			System.out.println(sql);
			PreparedStatement pst =con.prepareStatement(sql);
			
			pst.setInt(1,ins.cmtPostId);
			pst.setString(2,ins.cmtEmail);
			pst.setString(3,ins.cmts);
			
			int rows=pst.executeUpdate();
			System.out.println(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String[] displayPostsWithComments()
	{
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select u.user_name,p.caption,c.cmts,c.cmt_email from user_list u,posts p,comments c where u.email=p.email and p.post_id=c.cmt_post_id";
		    System.out.println(sql);
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
			{
				String username=rs.getString("user_name");
				System.out.println(username);
				String caption=rs.getString("caption");
				System.out.println(caption);
				String cmts=rs.getString("cmts");
				System.out.println(cmts);
				String cmtEmail=rs.getString("cmt_email");
				System.out.println(cmtEmail);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		return null;
		
	}

	

}
