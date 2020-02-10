package com.chainsys.socialmediaapplication.friendrequest;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;

public class TestGetRequestorList {

	public static void main(String[] args) {
		FriendRequestClass getreq=new FriendRequestClass();
		String requestor="sound@gmail.com";
		
		List<FriendRequestClass> list = getreq.getRequestorList(requestor);
		for (FriendRequestClass friendRequestClass : list) 
		{
			System.out.println(friendRequestClass.toString());
		}
	}

}
