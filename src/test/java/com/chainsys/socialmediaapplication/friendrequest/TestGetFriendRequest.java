package com.chainsys.socialmediaapplication.friendrequest;
import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;
public class TestGetFriendRequest {
	public static void main(String[] args) {
		FriendRequestClass getreq=new FriendRequestClass();
		String req="sound@gmail.com";
		String csts="accepted";
		
		List<FriendRequestClass> list = getreq.getFriendrequest(req,csts );
		for (FriendRequestClass friendRequestClass : list) 
		{
			System.out.println(friendRequestClass.toString());
		}
	}
}
