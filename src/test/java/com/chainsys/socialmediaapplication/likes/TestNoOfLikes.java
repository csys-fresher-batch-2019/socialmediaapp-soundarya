package com.chainsys.socialmediaapplication.likes;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.likes.LikesClass;

public class TestNoOfLikes {

	public static void main(String[] args) {
		LikesClass cnt=new LikesClass();
		Scanner s =new Scanner(System.in);
		System.out.println("Enter post id:");
	    int id=s.nextInt();
	    cnt.noOfLikes(id);
	    
	}

}
