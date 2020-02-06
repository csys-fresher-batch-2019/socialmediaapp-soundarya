package com.chainsys.socialmediaapplication.friendrequest;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;

public class TestGetAcceptorList {

	public static void main(String[] args) {
		FriendRequestClass getreq=new FriendRequestClass();
		String acceptor="sound@gmail.com";
		getreq.getAcceptorList(acceptor);
	}

}
