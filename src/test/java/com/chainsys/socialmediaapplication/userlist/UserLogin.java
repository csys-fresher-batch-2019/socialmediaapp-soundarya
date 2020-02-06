package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class UserLogin {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s= new Scanner(System.in);
		UserListClass login=new UserListClass();
		LOGGER.debug("Enter Email ID:");
		String email=s.nextLine();
		s.nextLine();
		LOGGER.debug("Enter Password:");
		String password=s.nextLine();
		login.userLogin(email, password);
	}

}
