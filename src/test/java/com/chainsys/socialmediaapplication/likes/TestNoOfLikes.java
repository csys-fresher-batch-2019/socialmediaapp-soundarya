package com.chainsys.socialmediaapplication.likes;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.CommentsClass;
import com.chainsys.socialmediaapplication.daoimpl.LikesClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestNoOfLikes {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		CommentsClass cnt=new CommentsClass();
		@SuppressWarnings("resource")
		Scanner s =new Scanner(System.in);
		LOGGER.debug("Enter post id:");
	    int id=s.nextInt();
	    cnt.noOfComments(id);
	    
	}

}
