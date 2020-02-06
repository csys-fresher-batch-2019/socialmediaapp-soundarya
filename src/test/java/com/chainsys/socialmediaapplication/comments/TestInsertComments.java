package com.chainsys.socialmediaapplication.comments;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.CommentsClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestInsertComments {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		CommentsClass ins=new CommentsClass();
		
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter post id");
		ins.setCmtPostId(Integer.parseInt(s.nextLine()));
		s.nextLine();
		LOGGER.debug("Enter email id");
		ins.setCmtEmail(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter comment ");
		ins.setCmts(s.nextLine());
		
		ins.insertComments(ins);
		
	}

}
