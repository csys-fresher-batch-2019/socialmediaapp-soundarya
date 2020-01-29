package com.chainsys.socialmediaapplication.likes;

public interface LikesDAO {

	public void addLikes(LikesClass add);
	
	public int noOfLikes(int likePostId);
}
