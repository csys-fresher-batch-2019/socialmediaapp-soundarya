package com.chainsys.socialmediaapplication.posts;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public class TestUpdatePost {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		PostsClass up=new PostsClass();
		
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter email");
		up.setEmail(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter post Id");
		up.setPostId(s.nextInt());
		s.nextLine();
		LOGGER.debug("Enter caption");
		up.setCaption(s.nextLine());
		up.updatePost(up);
		
	}



}
