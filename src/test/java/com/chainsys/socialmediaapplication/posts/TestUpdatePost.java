package com.chainsys.socialmediaapplication.posts;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.posts.PostsClass;

public class TestUpdatePost {

	public static void main(String[] args) {
		PostsClass up=new PostsClass();
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter email");
		up.email=s.nextLine();
		s.nextLine();
		System.out.println("Enter post Id");
		up.postId=s.nextInt();
		s.nextLine();
		System.out.println("Enter caption");
		up.caption=s.nextLine();
		up.updatePost(up);
		
	}



}
