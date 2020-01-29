package com.chainsys.socialmediaapplication.comments;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.comments.CommentsClass;

public class TestInsertComments {

	public static void main(String[] args) {
		CommentsClass ins=new CommentsClass();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter post id");
		ins.cmtPostId=Integer.parseInt(s.nextLine());
		s.nextLine();
		System.out.println("Enter email id");
		ins.cmtEmail=s.nextLine();
		s.nextLine();
		System.out.println("Enter comment ");
		ins.cmts=s.nextLine();
		
		ins.insertComments(ins);
		
	}

}
