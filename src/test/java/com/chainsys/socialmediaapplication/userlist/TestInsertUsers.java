package com.chainsys.socialmediaapplication.userlist;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.socialmediaapplication.userlist.UserListClass;

public class TestInsertUsers
{
	public static void main(String[] args) {
		UserListClass insert=new UserListClass();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter User name:");
		insert.userName=s.nextLine();
		s.nextLine();
		System.out.println("Enter email:");
		insert.email=s.nextLine();
		s.nextLine();
		System.out.println("Enter age :");
		insert.age=s.nextInt();
		s.nextLine();
		System.out.println("Enter gender:");
		insert.gender=s.nextLine();
		s.nextLine();
		System.out.println("Enter dob:");
		insert.dob=LocalDate.parse(s.nextLine());
		s.nextLine();
		System.out.println("Enter city:");
		insert.city=s.nextLine();
		s.nextLine();
		System.out.println("Enter country:");
		insert.country=s.nextLine();
		s.nextLine();
		System.out.println("Enter Status:");
		insert.status=s.nextLine();
		s.nextLine();
		System.out.println("Enter Password:");
		insert.userPassword=s.nextLine();
		insert.insertUsers(insert);
	}

}
