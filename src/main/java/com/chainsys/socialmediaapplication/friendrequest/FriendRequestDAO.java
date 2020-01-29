package com.chainsys.socialmediaapplication.friendrequest;
//import java.util.List;
public interface FriendRequestDAO {
	//Insert friend request details
	//insert into friend_request (requestor,acceptor,current_status) values ('sound@gmail.com','mala@gmail.com','accepted');
     void insertRequest(FriendRequestClass ins);
	
	//select * from friend_request where (requestor = 'sound@gmail.com') and current_status = 'accepted';
	String[] getFriendrequest(String requestor,String currentStatus);
	
	//select * from friend_request where requestor = 'sound@gmail.com';
	String[] getRequestorList(String requestor);
	
	//update friend_request set current_status='accepted' where requestor=? and acceptor=?;
	void updateStatus(String currentStatus,String requestor,String acceptor);
	
}
