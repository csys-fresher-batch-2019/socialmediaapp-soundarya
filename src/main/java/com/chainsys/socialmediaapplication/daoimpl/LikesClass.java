package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmediaapplication.dao.LikesDAO;
import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class LikesClass implements LikesDAO{
	 private static final Logger LOGGER = Logger.getInstance();
	 private int likePostId;
	 private String likeEmail;
	 private String likeDate;
	
	
	

	@Override
	public String toString() {
		return "LikesClass [likeEmail=" + likeEmail + ", likeDate=" + likeDate + "]";
	}


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

	public String getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
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


	
	@Override
	public int noOfLikes(int likePostId) {
		System.out.println(likePostId);
		String sql = "select count(*) as no_of_likes from likes where like_post_id=?" ;
		int totalcount = 0;
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql);)
		{
			pst.setInt(1, likePostId);

			try (ResultSet rs = pst.executeQuery())
			{
				if (rs.next()) {
					totalcount = rs.getInt("no_of_likes");
					LOGGER.debug("Total :" + totalcount);
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return totalcount;
	}


	@Override
	public List<LikesClass> displayLikes(LikesClass l) {
		List<LikesClass> list = new ArrayList<LikesClass>();
		String sql = "select like_email,like_date from likes where like_post_id=?" ;
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst =con.prepareStatement(sql)) {
			
			LOGGER.debug(sql);
			pst.setInt(1, l.getLikePostId());
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
		    	
				String email=rs.getString("like_email");
				String date=rs.getString("like_date");
				LikesClass l1=new LikesClass();
				l1.setLikeEmail(email);
				l1.setLikeDate(date);
				
				list.add(l1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
	}




	

}
