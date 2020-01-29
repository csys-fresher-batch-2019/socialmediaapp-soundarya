package com.chainsys.socialmediaapplication.likes;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.likes.LikesClass;

public class TestAddLikes {

	public static void main(String[] args) {

		LikesClass add=new LikesClass();
		Scanner s =new Scanner(System.in);
		System.out.println("Ënter Post Id");
		add.likePostId=s.nextInt();
		s.nextLine();
		System.out.println("Enter email");
		add.likeEmail=s.nextLine();
		add.addLikes(add);
		
		
	}

}
