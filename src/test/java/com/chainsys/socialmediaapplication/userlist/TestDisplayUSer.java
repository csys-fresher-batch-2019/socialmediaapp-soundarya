package com.chainsys.socialmediaapplication.userlist;

import java.io.IOException;
import java.util.Scanner;

import com.chainsys.socialmediaapplication.userlist.UserListClass;

public class TestDisplayUSer {

	public static void main(String[] args) throws IOException {
		UserListClass dis=new UserListClass();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the users email ID:");
		String emailid=s.nextLine();
		dis.displayUser(emailid);
		//file write
		
	}

}
