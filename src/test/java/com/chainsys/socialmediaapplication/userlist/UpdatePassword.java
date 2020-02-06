package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
//import com.chainsys.socialmediaapplication.daoimpl.LoginClass;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class UpdatePassword {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		UserListClass update=new UserListClass();
		LOGGER.debug("Ënter email:");
		String email=s.nextLine();
		LOGGER.debug("Ënter old password:");
		String op=s.nextLine();
		LOGGER.debug("Ënter new password:");
		String np=s.nextLine();
		update.updatePassword(email,op, np);
	}

}
