package com.chainsys.socialmediaapplication.userlist;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

public class TestInsertUsers
{
	 private static final Logger LOGGER = Logger.getInstance();
	public static void main(String[] args) {
		UserListClass insert=new UserListClass();
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		LOGGER.debug("Enter User name:");
		insert.setUserName(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter email:");
		insert.setEmail(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter age :");
		insert.setAge(s.nextInt());
		s.nextLine();
		LOGGER.debug("Enter gender:");
		insert.setGender(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter dob:");
		insert.setDob(LocalDate.parse(s.nextLine()));
		s.nextLine();
		LOGGER.debug("Enter city:");
		insert.setCity(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter country:");
		insert.setCountry(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter Status:");
		insert.setStatus(s.nextLine());
		s.nextLine();
		LOGGER.debug("Enter Password:");
		insert.setUserPassword(s.nextLine());
		insert.insertUsers(insert);
	}

}
