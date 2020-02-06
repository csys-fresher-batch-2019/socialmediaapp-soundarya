package com.chainsys.socialmediaapplication.likes;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.LikesClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestNoOfLikes {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		LikesClass cnt=new LikesClass();
		@SuppressWarnings("resource")
		Scanner s =new Scanner(System.in);
		LOGGER.debug("Enter post id:");
	    int id=s.nextInt();
	    cnt.noOfLikes(id);
	    
	}

}
