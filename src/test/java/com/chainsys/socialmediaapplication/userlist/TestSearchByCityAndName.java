package com.chainsys.socialmediaapplication.userlist;

import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestSearchByCityAndName {

	public static void main(String[] args) {
		UserListClass sbycity = new UserListClass();
		String a="a";
		String city="madurai";
		sbycity.searchByCityAndName(a,city);
	}
}
