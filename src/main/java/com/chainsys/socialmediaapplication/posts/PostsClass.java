package com.chainsys.socialmediaapplication.posts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class PostsClass  implements PostsDAO{
	
	public int postId;
	public String email;
	public String postType;
	public String caption;
	public String viewability;
	LocalDate datePosted;
	
	@Override
	public String toString() {
		return "PostsClass [postId=" + postId + ", email=" + email + ", postType=" + postType + ", caption=" + caption
				+ ", viewability=" + viewability + ", datePosted=" + datePosted + "]";
	}
	
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println("connected");
		return con;
	}


	public int NoOfPosts(String email)
	{
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select count(*) as no_of_posts from posts where email='"+email+"'";
		    System.out.println(sql);
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
			{
				int count=rs.getInt("no_of_posts");
				System.out.println(count);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
		
	}

    public void updatePost(PostsClass up)
    {
    	try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "update posts set date_posted = current_timestamp,caption='"+caption+"' where email='"+email+"' and post_id="+postId;
		    System.out.println(sql);
		    int rows=stmt.executeUpdate(sql);
		    System.out.println(rows +"updated");
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

	public void addPosts(PostsClass add) {
		/*DateFormat df=new SimpleDateFormat("dd/MM/yyyy ss:mm:HH");
		Date now=new Date(); 
		String postDateFormat=df.format(now);
		String postDate=postDateFormat;
		java.sql.Date date=new java.sql.Date(0000-00-00);
		//System.out.println("Enter posted date");
		//LocalDate postDate=LocalDate.parse(s.nextLine());*/
		try {
			Connection con=conMethod();
			String sql = "insert into posts (post_id,email,post_type,caption,viewability,date_posted) values (po_id_se.nextval,?,?,?,?,current_timestamp)";
			System.out.println(sql);
			PreparedStatement pst =con.prepareStatement(sql);
			//pst.setInt(1, postId);
			pst.setString(1,add.email);
			pst.setString(2,add.postType);
			pst.setString(3,add.caption);
			pst.setString(4,add.viewability);
			//pst.setDate(5,java.sql.Date.valueOf(postDate));
			//pst.setDate(5,java.sql.Date.valueOf(java.time.LocalDate.now()));
		//	pst.setTimestamp(5,java.sql.Timestamp(System.currentTimeMillis()));
			int rows=pst.executeUpdate();
			System.out.println(rows+"Rows updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public String[] display() {
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select u.user_name,p.post_type,p.caption,p.date_posted from user_list u inner join posts p on u.email=p.email";
		    System.out.println(sql);
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
			{
				String username=rs.getString("user_name");
				System.out.println(username);
				String posttype=rs.getString("post_type");
				System.out.println(posttype);
				String caption=rs.getString("caption");
				System.out.println(caption);
				String dateposted=rs.getString("date_posted");
				System.out.println(dateposted);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return null;
	}

	


}

