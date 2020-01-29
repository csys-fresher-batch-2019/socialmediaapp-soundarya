package com.chainsys.socialmediaapplication.friendrequest;

import com.chainsys.socialmediaapplication.friendrequest.FriendRequestClass;

public class TestGetRequestorList {

	public static void main(String[] args) {
		FriendRequestClass getreq=new FriendRequestClass();
		String requestor="sound@gmail.com";
		getreq.getRequestorList(requestor);
	}

}
