package com.chainsys.socialmediaapplication.dao;

import com.chainsys.socialmediaapplication.daoimpl.LikesClass;

public interface LikesDAO {

	public void addLikes(LikesClass add);
	
	public int noOfLikes(int likePostId);
}
