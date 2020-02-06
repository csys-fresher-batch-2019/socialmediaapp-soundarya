package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.chainsys.socialmediaapplication.dao.LikesDAO;
import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class LikesClass implements LikesDAO{
	 private static final Logger LOGGER = Logger.getInstance();
	 private int likePostId;
	 private String likeEmail;
	
	
	

	public int getLikePostId() {
		return likePostId;
	}


	public void setLikePostId(int likePostId) {
		this.likePostId = likePostId;
	}


	public String getLikeEmail() {
		return likeEmail;
	}


	public void setLikeEmail(String likeEmail) {
		this.likeEmail = likeEmail;
	}


	public static Logger getLogger() {
		return LOGGER;
	}


	public void addLikes(LikesClass add) {
		String sql = "insert into likes(like_post_id,like_email,like_date) values (?,?,current_timestamp)";
		try (Connection con=ConnectionUtil.conMethod();PreparedStatement pst=con.prepareStatement(sql)){
			
			
			LOGGER.debug(sql);
			
			pst.setInt(1, likePostId);
			pst.setString(2, likeEmail);
		   
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public int noOfLikes(int likePostId) {
		String sql = "select count(*) as no_of_likes from likes where like_post_id=?";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst=con.prepareStatement(sql);) {
			
			
			LOGGER.debug(sql);
			
			pst.setInt(1,likePostId);
		   
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int count=rs.getInt("no_of_likes");
				LOGGER.debug("No of likes :"+count);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	

}
