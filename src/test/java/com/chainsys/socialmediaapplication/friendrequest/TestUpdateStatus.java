package com.chainsys.socialmediaapplication.friendrequest;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class TestUpdateStatus {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		FriendRequestClass updatests=new FriendRequestClass();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		
		LOGGER.debug("Enter the requestor:");
		String req=s.nextLine();
		s.nextLine();
		LOGGER.debug("Enter the acceptor:");
		String acp=s.nextLine();
		s.nextLine();
		LOGGER.debug("Enter the status:");
		String csts=s.nextLine();
		updatests.updateStatus(csts,req,acp);

	}
	
}
