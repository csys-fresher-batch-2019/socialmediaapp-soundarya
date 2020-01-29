package com.chainsys.socialmediaapplication.test;

import java.util.Scanner;

import com.chainsys.socialmediaapplication.login.LoginClass;

public class InsertLogin {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in); 
		LoginClass add=new LoginClass();
		System.out.println("Enter Login Email" );
		add.loginEmail=s.nextLine();
		s.nextLine();
		System.out.println("Enter Login Password" );
		add.loginPassword=s.nextLine();
		add.addLogin(add);
		
	}

}
