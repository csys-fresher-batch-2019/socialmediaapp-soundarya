package com.chainsys.socialmediaapplication.dao;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.LikesClass;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public interface LikesDAO {

	public void addLikes(LikesClass add);
	
	public int noOfLikes(int likePostId);
	
	List<LikesClass> displayLikes(LikesClass l);

}
