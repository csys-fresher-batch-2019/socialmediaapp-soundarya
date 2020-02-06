package com.chainsys.socialmediaapplication.posts;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.PostsClass;

public class TestDisplayPublicPost {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		PostsClass display=new PostsClass();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter Acceptor email:");
		String acceptor=s.nextLine();
		display.displayPublicPost(acceptor);
	}

}
