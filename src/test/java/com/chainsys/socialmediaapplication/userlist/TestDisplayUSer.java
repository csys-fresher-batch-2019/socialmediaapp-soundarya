package com.chainsys.socialmediaapplication.userlist;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.CommentsClass;
import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestDisplayUSer {
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) throws IOException {
		UserListClass u=new UserListClass();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter the users email ID:");
		String emailid=s.nextLine();
		List<UserListClass> list = u.displayUser(emailid);
		for (UserListClass userListClass : list) {
			System.out.println(userListClass.display());
		}
		}

}
