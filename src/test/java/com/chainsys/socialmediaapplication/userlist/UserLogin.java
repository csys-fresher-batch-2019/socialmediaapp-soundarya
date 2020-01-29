package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

public class UserLogin {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		UserListClass login=new UserListClass();
		System.out.println("Enter Email ID:");
		String email=s.nextLine();
		s.nextLine();
		System.out.println("Enter Password:");
		String password=s.nextLine();
		login.userLogin(email, password);
	}

}
