package com.chainsys.socialmediaapplication.friendrequest;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestInsertFriendRequest {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		FriendRequestClass ins=new FriendRequestClass();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter Requestor email:");
		ins.setRequestor(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter Acceptor email:");
		ins.setAcceptor(s.nextLine());
		s.nextLine();
		//LOGGER.debug("Enter Current Status:");
		//ins.currentStatus=s.nextLine();
		ins.insertRequest(ins);
	}

}
