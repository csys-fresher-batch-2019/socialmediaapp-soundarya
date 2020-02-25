package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class CommentsClass {
	 private static final Logger LOGGER = Logger.getInstance();
	 private String userName;
	 private String caption;
	 private  int cmtPostId;
	 private String cmtEmail;
	 private String cmts;
	 private String cmtDate1;

		public String getCmtDate1() {
		return cmtDate1;
	}


	public void setCmtDate1(String cmtDate1) {
		this.cmtDate1 = cmtDate1;
	}


		public String getUserName() {
			return userName;
		}


		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getCaption() {
			return caption;
		}


		public void setCaption(String caption) {
			this.caption = caption;
		}

	
	public int getCmtPostId() {
		return cmtPostId;
	}


	public void setCmtPostId(int cmtPostId) {
		this.cmtPostId = cmtPostId;
	}


	public String getCmtEmail() {
		return cmtEmail;
	}


	public void setCmtEmail(String cmtEmail) {
		this.cmtEmail = cmtEmail;
	}


	public String getCmts() {
		return cmts;
	}


	public void setCmts(String cmts) {
		this.cmts = cmts;
	}


	public static Logger getLogger() {
		return LOGGER;
	}


	@Override
	public String toString() {
		return "CommentsClass [userName=" + userName + ", caption=" + caption + ", cmtPostId=" + cmtPostId
				+ ", cmtEmail=" + cmtEmail + ", cmts=" + cmts + ", cmtDate=" + cmtDate1 + "]";
	}
	public String toString1() {
		return "CommentsClass [userName=" + userName + ", caption=" + caption 
				+ ", cmtEmail=" + cmtEmail + ", cmts=" + cmts + ", cmtDate1=" + cmtDate1 + "]";
	}
	public String toString2() {
		return "CommentsClass [cmtEmail=" + cmtEmail + ", cmts=" + cmts + ", cmtDate1=" + cmtDate1 + "]";
	}
	
	public void insertComments(CommentsClass ins)
	{
		String sql = "insert into comments (cmt_post_id,cmt_email,cmts,cmt_date) values (?,?,?,current_timestamp)";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst =con.prepareStatement(sql)) {
			
			
			LOGGER.debug(sql);
			
			
			pst.setInt(1,ins.cmtPostId);
			pst.setString(2,ins.cmtEmail);
			pst.setString(3,ins.cmts);
			
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public List<CommentsClass> displayPostsWithComments()
	{
		List<CommentsClass> list = new ArrayList<CommentsClass>();
		String sql = "select u.user_name,p.caption,c.cmts,c.cmt_email,c.cmt_date from user_list u,posts p,comments c where u.email=p.email and p.post_id=c.cmt_post_id";
		try (Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			
			
		    
		    LOGGER.debug(sql);
		    
		    while(rs.next())
			{
				String username=rs.getString("user_name");
				
				String caption=rs.getString("caption");
				
				String cmts=rs.getString("cmts");
				
				String cmtEmail=rs.getString("cmt_email");
				
				String cmtDate1=rs.getString("cmt_date");
				
				CommentsClass c = new CommentsClass();
				c.setUserName(username);
				c.setCaption(caption);
				c.setCmts(cmts);
				c.setCmtEmail(cmtEmail);
				c.setCmtDate1(cmtDate1);;
				list.add(c);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		return list;
		
	}


	public String getCmtDate() {
		return cmtDate1;
	}


	public void setCmtDate(String cmtDate1) {
		this.cmtDate1 = cmtDate1;
	}


	public int noOfComments(int cmtPostId) {
		System.out.println(cmtPostId);
		String sql = "select count(*) as no_of_comments from comments where cmt_post_id=?" ;
		int totalcount = 0;
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst=con.prepareStatement(sql))
		{
		pst.setInt(1,cmtPostId);
				
			try(    ResultSet rs=pst.executeQuery()) 
		{
			
		    if(rs.next())
			{
				totalcount=rs.getInt("no_of_comments");
				LOGGER.debug("Total Comments:" + totalcount);
			}
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		}catch (Exception e) {
			// TODO: handle exception
		}
		return totalcount;
	}

	public List<CommentsClass> displayComments(CommentsClass l) {
		List<CommentsClass> list = new ArrayList<CommentsClass>();
		String sql = "select cmt_email,cmt_date,cmts from comments where cmt_post_id=?" ;
		try(Connection con=ConnectionUtil.conMethod();
				PreparedStatement pst =con.prepareStatement(sql)) {
			
			LOGGER.debug(sql);
			pst.setInt(1, l.getCmtPostId());
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
		    	
				String email=rs.getString("cmt_email");
				String cmt=rs.getString("cmts");
				String date=rs.getString("cmt_date");
				LikesClass l1=new LikesClass();
				l.setCmtEmail(email);
				l.setCmts(cmt);
				l.setCmtDate(date);
				
				list.add(l);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
	}



	

}
