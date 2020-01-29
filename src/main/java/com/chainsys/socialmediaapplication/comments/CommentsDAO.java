package com.chainsys.socialmediaapplication.comments;

public interface CommentsDAO {
	//posting comments
		//insert into comments (cmt_post_id,cmt_email,cmts) values (1,'aishu@gmail.com','hai');
		public void insertComments(CommentsClass ins);
		
		//displaying the comments for the posts posted by the users
		//select u.user_name,p.caption,c.cmts,c.cmt_email from user_list u,posts p,comments c where u.email=p.email
				//and p.post_id=c.cmt_post_id;
		
		public String[] displayPostsWithComments();
}
