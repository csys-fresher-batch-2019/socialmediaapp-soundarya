package com.chainsys.socialmediaapplication.comments;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.CommentsClass;

public class TestDisplayPostsWithComments {

	public static void main(String[] args) {
		
		CommentsClass dis=new CommentsClass();
		List<CommentsClass> list = dis.displayPostsWithComments();
		for (CommentsClass commentsClass : list) {
			
			System.out.println(commentsClass.toString1());
		}

	}

}
