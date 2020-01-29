package com.chainsys.socialmediaapplication.friendrequest;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.friendrequest.FriendRequestClass;

public class TestUpdateStatus {

	public static void main(String[] args) {
		FriendRequestClass updatests=new FriendRequestClass();
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the requestor:");
		String req=s.nextLine();
		s.nextLine();
		System.out.println("Enter the acceptor:");
		String acp=s.nextLine();
		s.nextLine();
		System.out.println("Enter the status:");
		String csts=s.nextLine();
		updatests.updateStatus(csts,req,acp);

	}
	
}
