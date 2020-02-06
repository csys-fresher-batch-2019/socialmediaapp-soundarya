package com.chainsys.socialmediaapplication.userlist;

import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestSearchByAgeClass {

	public static void main(String[] args) {
		UserListClass sage = new UserListClass();
		int age=20;
		sage.searchByAge(age);
	}

}
