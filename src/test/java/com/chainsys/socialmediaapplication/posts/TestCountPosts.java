package com.chainsys.socialmediaapplication.posts;

import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public class TestCountPosts {
	public static void main(String[] args) {
		PostsClass countpost=new PostsClass();
		String email="aishu@gmail.com";
		countpost.NoOfPosts(email);
	}
}
