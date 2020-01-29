package com.chainsys.socialmediaapplication.userlist;
//import java.util.List;
public interface UserListDAO {
	//inserting new users
	void insertUsers(UserListClass insert);
	//select user_name,gender from user_list where city='madurai';
	String[] searchByCity(String city);
	// select * from user_list where user_name like 'a%';
    String[] searchByCityAndName(String a,String city);
	// select * from user_list where user_name like '%mala%';
	String[] nameLike(String searchname);
	  //select user_name from user_list where age >= 20;
	String[] searchByAge(int age);
	//Count of users
	int noOfUsers();
	//displaying the details of particular user
	 public String displayUser(String emailId);
	//displaying the full details of the particular user
	// public String fullDetails(String emailId);
	 //update active status
	 public void userLogin(String userName,String password);
	 void updateActiveStatus(String username);
	public void updatePassword(String email,String oldPassword,String newPassword);

}