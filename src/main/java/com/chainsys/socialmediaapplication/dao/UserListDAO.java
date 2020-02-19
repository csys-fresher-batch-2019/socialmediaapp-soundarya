package com.chainsys.socialmediaapplication.dao;

import java.util.List;

//import org.jdbi.v3.sqlobject.statement.SqlQuery;
//import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.socialmediaapplication.daoimpl.UserListClass;

//import java.util.List;
public interface UserListDAO {
	//@SqlUpdate("insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status,user_password,profile_pic) values (u_id_s.nextval,?,?,?,?,?,?,?,current_timestamp,?,?,?)")
	void insertUsers(UserListClass insert);
	//@SqlQuery("select profile_pic,user_name,email,age,gender from user_list where user_name like '?%' and city='?'")
	List<UserListClass> searchByCityAndName(String a,String city);
	//@SqlQuery("select * from user_list where user_name like '%mala%';")
	List<UserListClass> nameLike(String searchname);
	//@SqlQuery("select user_name from user_list where age >= 20;")
	String[] searchByAge(int age);
	//@SqlQuery("select count(*) as total_count from user_list where active_status='active'" )
	int noOfUsers();
	//displaying the details of particular user
	//@SqlQuery("select user_id,profile_pic,user_name,email,age,gender,dob,city,country,created_date,status,active_status from user_list  where email='?'")
	public List<UserListClass> displayUser(String emailId);
	//displaying the full details of the particular user
	// public String fullDetails(String emailId);
	//@SqlQuery("select email,user_password from user_list where email='?'")
	 public String userLogin(String userName,String password);
	//@SqlUpdate("update user_list set active_status='inactive' where user_name=?")
	 void updateActiveStatus(String username);
	//@SqlUpdate("update user_list set user_password = '?' where email='?' and user_password='?'")
	public void updatePassword(String email,String oldPassword,String newPassword);

}
