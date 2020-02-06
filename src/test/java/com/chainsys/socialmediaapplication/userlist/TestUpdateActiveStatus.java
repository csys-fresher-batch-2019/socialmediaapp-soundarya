package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestUpdateActiveStatus {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter user name:");
		String name=s.nextLine();
		UserListClass update=new UserListClass();
		update.updateActiveStatus(name);

	}

}
