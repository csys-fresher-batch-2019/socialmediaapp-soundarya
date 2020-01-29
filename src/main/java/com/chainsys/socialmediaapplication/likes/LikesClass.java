package com.chainsys.socialmediaapplication.likes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LikesClass implements LikesDAO{

	public int likePostId;
	public String likeEmail;
	
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println("connected");
		return con;
	}
	

	public void addLikes(LikesClass add) {

		try {
			Connection con=conMethod();
			String sql = "insert into likes(like_post_id,like_email,like_date) values (?,?,current_timestamp)";
			System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, likePostId);
			pst.setString(2, likeEmail);
		   
			int rows=pst.executeUpdate();
			System.out.println(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public int noOfLikes(int likePostId) {

		try {
			Connection con=conMethod();
			Statement stmt=con.createStatement();
			String sql = "select count(*) as no_of_likes from likes where like_post_id=?";
			System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,likePostId);
		   
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int count=rs.getInt("no_of_likes");
				System.out.println("No of likes :"+count);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	

}
