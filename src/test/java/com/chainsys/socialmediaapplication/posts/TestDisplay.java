package com.chainsys.socialmediaapplication.posts;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;
import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public class TestDisplay {

	public static void main(String[] args) {
		PostsClass dis=new PostsClass();
		
		List<PostsClass> list = dis.display();
		
		for (PostsClass postsClass : list) {
			System.out.println(postsClass.toString1());
		}
		
		
	}

}
