package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.userlist.UserListClass;

public class TestUpdateActiveStatus {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter user name:");
		String name=s.nextLine();
		UserListClass update=new UserListClass();
		update.updateActiveStatus(name);

	}

}
