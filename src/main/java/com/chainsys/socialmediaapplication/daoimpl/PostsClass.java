package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmediaapplication.dao.PostsDAO;
import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class PostsClass  implements PostsDAO{
	 private static final Logger LOGGER = Logger.getInstance();
	 private String userName;
	 private int postId;
	 private String email;
	 private String postType;
	 private String caption;
	 private String viewability;
	 private String datePosted;
	 
	 public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

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



	public String getDatePosted() {
		return datePosted;
	}



	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}



	public static Logger getLogger() {
		return LOGGER;
	}


	
	
	@Override
	public String toString() {
		return "PostsClass [userName=" + userName + ", postId=" + postId + ", email=" + email + ", postType=" + postType
				+ ", caption=" + caption + ", viewability=" + viewability + ", datePosted=" + datePosted + "]";
	}
	
	public String toString1() {
		return "PostsClass [userName=" + userName + ",  postType=" + postType
				+ ", caption=" + caption + ",  datePosted=" + datePosted + "]";
	}

	public String toString2() {
		return "PostsClass [ postId=" + postId + ", email=" + email + ", postType=" + postType
				+ ", caption=" + caption + ",  datePosted=" + datePosted + "]";
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

	public List<PostsClass> display() {
		List<PostsClass> list = new ArrayList<PostsClass>();
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
				String datePosted=rs.getString("date_posted");
				LOGGER.debug(datePosted);
				
				PostsClass p=new PostsClass();
				p.setUserName(username);
				p.setPostType(posttype);
				p.setCaption(caption);
				p.setDatePosted(datePosted);
				
				list.add(p);
				
				
				
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return list;
	}

	public List<PostsClass> displayFriendsPost(String req, String acp) {
		List<PostsClass> list = new ArrayList<PostsClass>();
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
						 Date dateposted=rs.getDate("date_posted");
						LOGGER.debug(dateposted); 
				
						
						PostsClass p=new PostsClass();
						p.setPostId(postId);
						p.setEmail(email);
						p.setPostType(posttype);
						p.setCaption(caption);
						p.setDatePosted(datePosted);
						
						list.add(p);
						
			}LOGGER.debug("You are still not accepted by your friend");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}


	public 	List<PostsClass> displayPublicPost() {
		List<PostsClass> list = new ArrayList<PostsClass>();
		String sql = "select * from posts where viewability='public'";
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
						
						PostsClass p=new PostsClass();
						p.setPostId(postId);
						p.setEmail(email);
						p.setPostType(posttype);
						p.setCaption(caption);
						p.setDatePosted(dateposted);
						
						list.add(p);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		return list;
	}

	


}

