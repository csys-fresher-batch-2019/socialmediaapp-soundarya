package com.chainsys.socialmediaapplication.userlist;

import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestNameLikeClass {

	public static void main(String[] args) {
		UserListClass namelike = new UserListClass();
		String searchname="mala";
		namelike.nameLike(searchname);
	}

}
