package com.chainsys.socialmediaapplication.friendrequest;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;

public class TestGetFriendRequest {

	public static void main(String[] args) {
		FriendRequestClass getreq=new FriendRequestClass();
		String req="sound@gmail.com";
		String csts="accepted";
		getreq.getFriendrequest(req,csts );
	}

}
