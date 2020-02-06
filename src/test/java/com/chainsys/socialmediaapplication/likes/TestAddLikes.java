package com.chainsys.socialmediaapplication.likes;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.LikesClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestAddLikes {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {

		LikesClass add=new LikesClass();
		@SuppressWarnings("resource")
		Scanner s =new Scanner(System.in);
		LOGGER.debug("Ënter Post Id");
		add.setLikePostId(s.nextInt());
		s.nextLine();
		LOGGER.debug("Enter email");
		add.setLikeEmail(s.nextLine());
		add.addLikes(add);
		
		
	}

}
