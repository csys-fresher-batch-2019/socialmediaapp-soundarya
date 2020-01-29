package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.userlist.UserListClass;

public class TestDisplayAll {

	public static void main(String[] args) {
		UserListClass dis=new UserListClass();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the users email ID:");
		String emailid=s.nextLine();
		dis.fullDetails(emailid);
	}

}
