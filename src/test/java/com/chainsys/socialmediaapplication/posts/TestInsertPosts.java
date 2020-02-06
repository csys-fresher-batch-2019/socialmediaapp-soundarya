package com.chainsys.socialmediaapplication.posts;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public class TestInsertPosts {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		PostsClass add=new PostsClass();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		//LOGGER.debug("Enter post id");
		//add.postId=s.nextInt();
		//s.nextLine();
		LOGGER.debug("Enter email");
		add.setEmail(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter post Type");
		add.setPostType(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter caption");
		add.setCaption(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter viewability(public/friends)");
		add.setViewability(s.nextLine());
		s.nextLine();
		add.addPosts(add);
	}

}