package com.chainsys.socialmediaapplication.friendrequest;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;
public class TestGetAcceptorList {

	public static void main(String[] args) {
		FriendRequestClass getreq=new FriendRequestClass();
		String acceptor="sound@gmail.com";
		List<FriendRequestClass> list = getreq.getAcceptorList(acceptor);
		for (FriendRequestClass friendRequestClass : list) 
		{
			System.out.println(friendRequestClass.toString());
		}
	}

}
