package com.chainsys.socialmediaapplication.userlist;

import java.util.Scanner;

//import org.jdbi.v3.core.Jdbi;

import com.chainsys.socialmediaapplication.dao.UserListDAO;
import com.chainsys.socialmediaapplication.daoimpl.Logger;
import com.chainsys.socialmediaapplication.daoimpl.UserListClass;
import com.chainsys.socialmediaapplication.util.ConnectionUtil;

public class TestAddUsers {
	
	 private static final Logger LOGGER = Logger.getInstance();

	public static void main(String[] args) throws Exception {
		 //Jdbi jdbi= ConnectionUtil.getJdbi(); 
	    // UserListDAO user=jdbi.onDemand(UserListDAO.class);
		UserListClass insert=new UserListClass();
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
		insert.setDob(java.sql.Date.valueOf((s.nextLine())));
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
		LOGGER.debug("Upload profile picture:");
		insert.setProfilePic(s.nextLine());
		insert.insertUsers(insert);

	}

}
