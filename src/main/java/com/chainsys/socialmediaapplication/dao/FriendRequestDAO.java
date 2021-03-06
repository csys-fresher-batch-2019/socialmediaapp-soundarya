package com.chainsys.socialmediaapplication.dao;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.FriendRequestClass;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

//import java.util.List;
public interface FriendRequestDAO {
	//Insert friend request details
	//insert into friend_request (requestor,acceptor,current_status) values ('sound@gmail.com','mala@gmail.com','accepted');
     void insertRequest(FriendRequestClass ins);
	
	//select * from friend_request where (requestor = 'sound@gmail.com') and current_status = 'accepted';
     List<FriendRequestClass> getFriendrequest(String requestor,String s);
	
	//select * from friend_request where requestor = 'sound@gmail.com';
     List<FriendRequestClass> getRequestorList(String requestor);
	
     List<FriendRequestClass> getAcceptorList(String requestor);

	//update friend_request set current_status='accepted' where requestor=? and acceptor=?;
	void updateStatus(String currentStatus,String requestor,String acceptor);
	
}
