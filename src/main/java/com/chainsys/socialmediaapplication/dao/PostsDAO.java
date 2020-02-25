package com.chainsys.socialmediaapplication.dao;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public interface PostsDAO {

	//add posts
	//@SqlUpdate("insert into posts (post_id,email,post_type,caption,viewability,date_posted) values (po_id_se.nextval,?,?,?,?,current_timestamp)")
	public void addPosts(PostsClass add);
	
	//count no of posts
	//@SqlUpdate("select count(*) as no_of_posts from posts where email=?")
	int NoOfPosts(String email);
	
	//update posts set date_posted = current_timestamp,caption='hello' where email='sound@gmail.com';
    //@SqlUpdate("update posts set date_posted = current_timestamp,caption=? where email=? and post_id=?")
	public void updatePost(PostsClass up);
    
    //displaying the user name and posted status for the particular user
    //select u.user_name,p.post_type,p.caption,p.date_posted from user_list u inner join posts p on u.email=p.email;
	public List<PostsClass> display();
	
	public List<PostsClass> displayFriendsPost(String req);
	
	public List<PostsClass> displayPublicPost();
	public List<PostsClass> displayFriendsPost1(String acp);
	
	public void deletePost(PostsClass d);
}
