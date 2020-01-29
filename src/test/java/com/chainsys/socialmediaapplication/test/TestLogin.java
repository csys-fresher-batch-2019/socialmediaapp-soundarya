package com.chainsys.socialmediaapplication.test;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.login.LoginClass;

public class TestLogin {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		LoginClass login=new LoginClass();
		System.out.println("Ënter email:");
		String email=s.nextLine();
		System.out.println("Ënter password:");
		String password=s.nextLine();
		login.login(email, password);
		
	}

}
