package com.chainsys.socialmediaapplication.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class CommentsClass {
	 private static final Logger LOGGER = Logger.getInstance();
	 private  int cmtPostId;
	 private String cmtEmail;
	 private String cmts;
	
	
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
		return "CommentsClass [cmtPostId=" + cmtPostId + ", cmtEmail=" + cmtEmail + ", cmts=" + cmts + "]";
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
	public String[] displayPostsWithComments()
	{
		String sql = "select u.user_name,p.caption,c.cmts,c.cmt_email from user_list u,posts p,comments c where u.email=p.email and p.post_id=c.cmt_post_id";
		try (Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			
		    
		    LOGGER.debug(sql);
		    
		    while(rs.next())
			{
				String username=rs.getString("user_name");
				LOGGER.debug(username);
				String caption=rs.getString("caption");
				LOGGER.debug(caption);
				String cmts=rs.getString("cmts");
				LOGGER.debug(cmts);
				String cmtEmail=rs.getString("cmt_email");
				LOGGER.debug(cmtEmail);
			}
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		return null;
		
	}

	

}
