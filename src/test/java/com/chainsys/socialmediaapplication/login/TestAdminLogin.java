package com.chainsys.socialmediaapplication.login;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.LoginClass;

public class TestAdminLogin {
	private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s= new Scanner(System.in);
		LoginClass login=new LoginClass();
		LOGGER.debug("Enter Admin Email ID:");
		String email=s.nextLine();
		s.nextLine();
		LOGGER.debug("Enter Admin Password:");
		String password=s.nextLine();
		login.adminLogin(email, password);

}
}
