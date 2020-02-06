package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

import com.chainsys.socialmediaapplication.dao.PostsDAO;
import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class PostsClass  implements PostsDAO{
	 private static final Logger LOGGER = Logger.getInstance();
	 private int postId;
	 private String email;
	 private String postType;
	 private String caption;
	 private String viewability;
	public int getPostId() {
		return postId;
	}



	public void setPostId(int postId) {
		this.postId = postId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPostType() {
		return postType;
	}



	public void setPostType(String postType) {
		this.postType = postType;
	}



	public String getCaption() {
		return caption;
	}



	public void setCaption(String caption) {
		this.caption = caption;
	}



	public String getViewability() {
		return viewability;
	}



	public void setViewability(String viewability) {
		this.viewability = viewability;
	}



	public LocalDate getDatePosted() {
		return datePosted;
	}



	public void setDatePosted(LocalDate datePosted) {
		this.datePosted = datePosted;
	}



	public static Logger getLogger() {
		return LOGGER;
	}


	LocalDate datePosted;
	
	@Override
	public String toString() {
		return "PostsClass [postId=" + postId + ", email=" + email + ", postType=" + postType + ", caption=" + caption
				+ ", viewability=" + viewability + ", datePosted=" + datePosted + "]";
	}
	


	public int NoOfPosts(String email)
	{
		 String sql = "select count(*) as no_of_posts from posts where email='"+email+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)) {
			
		   
		    LOGGER.debug(sql);
		    
		    while(rs.next())
			{
				int count=rs.getInt("no_of_posts");
				LOGGER.debug(count);
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
    	 String sql = "update posts set date_posted = current_timestamp,caption='"+caption+"' where email='"+email+"' and post_id="+postId;
    	try (Connection con=ConnectionUtil.conMethod();
    		    Statement stmt=con.createStatement()){
			
		   
		    LOGGER.debug(sql);
		    int rows=stmt.executeUpdate(sql);
		    LOGGER.debug(rows +"updated");
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

	public void addPosts(PostsClass add) {
		
		String sql = "insert into posts (post_id,email,post_type,caption,viewability,date_posted) values (po_id_se.nextval,?,?,?,?,current_timestamp)";
		try (Connection con=ConnectionUtil.conMethod();PreparedStatement pst =con.prepareStatement(sql);)
		{
			
			LOGGER.debug(sql);
			
			//pst.setInt(1, postId);
			pst.setString(1,add.email);
			pst.setString(2,add.postType);
			pst.setString(3,add.caption);
			pst.setString(4,add.viewability);		
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Rows updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public String[] display() {
		String sql = "select u.user_name,p.post_type,p.caption,p.date_posted from user_list u inner join posts p on u.email=p.email ";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement(); ResultSet rs=stmt.executeQuery(sql)) {
			
		    
		    LOGGER.debug(sql);
		   
		    while(rs.next())
			{
				String username=rs.getString("user_name");
				LOGGER.debug(username);
				String posttype=rs.getString("post_type");
				LOGGER.debug(posttype);
				String caption=rs.getString("caption");
				LOGGER.debug(caption);
				String dateposted=rs.getString("date_posted");
				LOGGER.debug(dateposted);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return null;
	}

	public String[] displayFriendsPost(String req, String acp) {
		String sql = "select * from posts where  email in (\r\n" + 
	    		"select acceptor from friend_request where requestor = '"+req+"'and acceptor='"+acp+"' and current_status='accepted' )";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql)) {
			
		    while(rs.next())
			{
		    			int postId=rs.getInt("post_id");
		    			LOGGER.debug(postId);		
					 	String email=rs.getString("email");
						LOGGER.debug(email);
						String posttype=rs.getString("post_type");
						LOGGER.debug(posttype);
						String caption=rs.getString("caption");
						LOGGER.debug(caption);
						String dateposted=rs.getString("date_posted");
						LOGGER.debug(dateposted); 
				
			}LOGGER.debug("You are still not accepted by your friend");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	public String[] displayPublicPost(String acp) {
		String sql = "select * from posts where email='"+acp+"' and viewability='public'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql);) {
			
		    while(rs.next())
			{
		    			int postId=rs.getInt("post_id");
		    			LOGGER.debug(postId);		
					 	String email=rs.getString("email");
						LOGGER.debug(email);
						String posttype=rs.getString("post_type");
						LOGGER.debug(posttype);
						String caption=rs.getString("caption");
						LOGGER.debug(caption);
						String dateposted=rs.getString("date_posted");
						LOGGER.debug(dateposted); 
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		return null;
	}

	


}

