package com.chainsys.socialmediaapplication.posts;

import java.util.List;
import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public class TestDisplayPublicPost {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		PostsClass display=new PostsClass();
		@SuppressWarnings("resource")
		
		
		List<PostsClass> list = display.displayPublicPost();
		
		for (PostsClass postsClass : list) {
			System.out.println(postsClass.toString2());
		}
	}

}
