package com.chainsys.socialmediaapplication.friendrequest;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.friendrequest.FriendRequestClass;

public class TestInsertFriendRequest {

	public static void main(String[] args) {
		FriendRequestClass ins=new FriendRequestClass();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Requestor email:");
		ins.requestor=s.nextLine();
		s.nextLine();
		System.out.println("Enter Acceptor :");
		ins.acceptor=s.nextLine();
		s.nextLine();
		//System.out.println("Enter Current Status:");
		//ins.currentStatus=s.nextLine();
		ins.insertRequest(ins);
	}

}
