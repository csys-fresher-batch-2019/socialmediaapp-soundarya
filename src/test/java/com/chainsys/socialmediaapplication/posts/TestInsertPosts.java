package com.chainsys.socialmediaapplication.posts;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.posts.PostsClass;

public class TestInsertPosts {

	public static void main(String[] args) {
		PostsClass add=new PostsClass();
		Scanner s=new Scanner(System.in);
		//System.out.println("Enter post id");
		//add.postId=s.nextInt();
		//s.nextLine();
		System.out.println("Enter email");
		add.email=s.nextLine();
		s.nextLine();
		System.out.println("Enter post Type");
		add.postType=s.nextLine();
		s.nextLine();
		System.out.println("Enter caption");
		add.caption=s.nextLine();
		s.nextLine();
		System.out.println("Enter viewability");
		add.viewability=s.nextLine();
		s.nextLine();
		add.addPosts(add);
	}

}