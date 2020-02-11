package com.chainsys.socialmediaapplication.userlist;

import java.util.List;

import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestSearchByCityAndName {

	public static void main(String[] args) {
		UserListClass sbycity = new UserListClass();
		String a="so";
		String city="madurai";
		
		List<UserListClass> list = sbycity.searchByCityAndName(a,city);
		for (UserListClass userListClass : list) {
			System.out.println(userListClass.display1());
		}
	}
}
