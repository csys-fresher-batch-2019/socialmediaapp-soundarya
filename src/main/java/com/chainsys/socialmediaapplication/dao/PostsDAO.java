package com.chainsys.socialmediaapplication.dao;

import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public interface PostsDAO {

	//add posts
	public void addPosts(PostsClass add);
	
	//count no of posts
	//select count(*) as no_of_posts from posts where email='aishu@gmail.com';
	int NoOfPosts(String email);
	
	//update posts set date_posted = current_timestamp,caption='hello' where email='sound@gmail.com';
    public void updatePost(PostsClass up);
    
    //displaying the user name and posted status for the particular user
    //select u.user_name,p.post_type,p.caption,p.date_posted from user_list u inner join posts p on u.email=p.email;
	public String[] display();
	
	public String[] displayFriendsPost(String req,String acp);
	
	public String[] displayPublicPost( String acp);

}
