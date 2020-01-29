package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.login.LoginClass;

public class UpdatePassword {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		UserListClass update=new UserListClass();
		System.out.println("Ënter email:");
		String email=s.nextLine();
		System.out.println("Ënter old password:");
		String op=s.nextLine();
		System.out.println("Ënter new password:");
		String np=s.nextLine();
		update.updatePassword(email,op, np);
	}

}
