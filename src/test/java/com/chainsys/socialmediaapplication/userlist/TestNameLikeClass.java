package com.chainsys.socialmediaapplication.userlist;



import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestNameLikeClass {

	public static void main(String[] args) {
		UserListClass namelike = new UserListClass();
		String searchname="mala";
		List<UserListClass> list = namelike.nameLike(searchname);
		for (UserListClass userListClass : list) {
			System.out.println(userListClass.display());
		}
		
	}

}
