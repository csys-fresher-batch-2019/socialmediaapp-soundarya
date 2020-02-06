package com.chainsys.socialmediaapplication.daoimpl;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.chainsys.socialmediaapplication.dao.UserListDAO;
import com.chainsys.socialmediaapplication.util.ConnectionUtil;
import com.chainsys.socialmediaapplication.util.FileUtil;

public class UserListClass  implements UserListDAO {
	private static final Logger LOGGER = Logger.getInstance();
	private int  userId;
	private String userName;
	private String email;
	private int age;
	private String gender;
	private LocalDate dob;
	private String city;
	private String country;
	LocalDateTime createdDate;
	private String status;
	private String userPassword;
	

	
		
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	@Override
	public String toString() {
		return "UserListClass [userId=" + userId + ", userName=" + userName + ", email=" + email + ", gender=" + gender
				+ ", dob=" + dob + ", city=" + city + ", country=" + country + ", createdDate=" + createdDate
				+ ", status=" + status + ", userPassword=" + userPassword + "]";
	}

	/*public String[] searchByCity(String city) {
		String sql = "select user_name,gender from user_list where city='"+city+"'";
			try(Connection con=ConnectionUtil.conMethod();Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
				
				//String sql = "select user_name,gender from user_list where city='"+city+"'";
				LOGGER.debug(sql);
				
				while(rs.next())
				{
					String userName=rs.getString("user_name");
					LOGGER.debug(userName);
					String gender=rs.getString("gender");
					LOGGER.debug(gender);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
    }*/

	public int noOfUsers()
	{
		String sql = "select count(*) as total_count from user_list" ;
		int totalcount = 0;
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql)) 
		{
			
		    if(rs.next())
			{
				totalcount=rs.getInt("total_count");
				LOGGER.debug("Total :" + totalcount);
			}
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		return totalcount;
	}
	

	public String[] nameLike(String searchname) {
		String sql = " select * from user_list where user_name like '%"+searchname+"%'" ;
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
				
				ResultSet rs=stmt.executeQuery(sql)) {
			
			LOGGER.debug(sql);
		    while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				LOGGER.debug(userId);
				String userName=rs.getString("user_name");
				LOGGER.debug(userName);
				String email=rs.getString("email");
				LOGGER.debug(email);
				int age=rs.getInt("age");
				LOGGER.debug(age);
				String gender=rs.getString("gender");
				LOGGER.debug(gender);
				Date dob=rs.getDate("dob");
				LOGGER.debug(dob);
				String city=rs.getString("city");
				LOGGER.debug(city);
				String country=rs.getString("country");
				LOGGER.debug(country);
				Date createdDate=rs.getDate("created_date");
				LOGGER.debug(createdDate);
				String status=rs.getString("status");
				LOGGER.debug(status);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return null;
	}
	public String[] searchByAge(int age) {
		String sql = "select user_name from user_list where age >="+age;
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
				
				ResultSet rs=stmt.executeQuery(sql)) {
			
			LOGGER.debug(sql);
		    while(rs.next())
			{
				String userName=rs.getString("user_name");
				LOGGER.debug(userName);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return null;
	}

	public String displayUser(String emailid) {
		String sql = "select * from user_list  where email='"+emailid+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);) {
			
			LOGGER.debug(sql);
		    while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				//LOGGER.debug(userId);
				String userName=rs.getString("user_name");
				//LOGGER.debug(userName);
				String email=rs.getString("email");
				//LOGGER.debug(email);
				int age=rs.getInt("age");
				//LOGGER.debug(age);
				String gender=rs.getString("gender");
				//LOGGER.debug(gender);
				Date dob=rs.getDate("dob");
				//LOGGER.debug(dob);
				String city=rs.getString("city");
				//LOGGER.debug(city);
				String country=rs.getString("country");
				//LOGGER.debug(country);
				Date createdDate=rs.getDate("created_date");
				//LOGGER.debug(createdDate);
				String status=rs.getString("status");
				//LOGGER.debug(status);
				String userId1=String.valueOf(userId);
				String age1=String.valueOf(age);
				String dob1=String.valueOf(dob);
				String createdDate1=String.valueOf(createdDate);

				String newResult= "Id:"+userId1+"\n"+"Name:"+userName+"\n"+"Email:"+email+"\n"+"Age:"+age1+"\n"+"Gender:"+gender+"\n"+"Date of Birth:"+dob1+"\n"+"City:"+city+"\n"+"Country:"+country+"\n"+"Created Date:"+createdDate1+"\n"+"Status:"+status;
				//LOGGER.debug(newResult);
				//file write
				FileUtil.WriteFile("display.txt",newResult,StandardOpenOption.APPEND);
				LOGGER.debug("Exported Successfully");

				//file read
				String fname="display.txt";
				Path path=Paths.get(fname);
				
				byte[] bytes=Files.readAllBytes(path);
				String content=new String(bytes);
				LOGGER.debug(content);
				LOGGER.debug("Imported Successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateActiveStatus(String username) {
		String sql = "update user_list set active_status='inactive' where user_name=?";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst=con.prepareStatement(sql)) {
			
		    //Statement stmt=con.createStatement();
			//String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status) values (users_id_seq.nextval,'harrys','harrys@gmail.com',20,'male',to_date('13-01-1999','dd-MM-yyyy'),'virudhunagar','India',current_timestamp,'i_am_harry')";
			
			LOGGER.debug(sql);
			
			pst.setString(1, username);
			
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Rows updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void userLogin(String email, String password) {
		String sql = "select email,user_password from user_list where email='"+email+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql)){
			
			
			LOGGER.debug(sql);
			
			if(rs.next())
			{
				String email1=rs.getString("email");
				//LOGGER.debug(email1);
				String password1=rs.getString("user_password");
				//LOGGER.debug(password1);
				if(email1.equals(email) && password1.equals(password))
					LOGGER.debug(email1+" Successfully Logged in");
			}
			else
			{
				LOGGER.debug("Login Failed");	

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void updatePassword(String email,String oldPassword,String newPassword)
	{
		String sql = "update user_list set user_password = '"+newPassword+"' where email='"+email+"' and user_password='"+oldPassword+"'";
		try (Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();){
			
		    
		    LOGGER.debug(sql);
		    int rows=stmt.executeUpdate(sql);
		    LOGGER.debug(rows +" password updated");
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String[] searchByCityAndName(String a,String city) {
		String sql = "select user_id,user_name,email,age,gender from user_list where user_name like '"+a+"%' and city='"+city+"'";
		try(Connection con=ConnectionUtil.conMethod();
			    Statement stmt=con.createStatement();
			    
			    ResultSet rs=stmt.executeQuery(sql)) {
			
		    while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				LOGGER.debug(userId);
				String userName=rs.getString("user_name");
				LOGGER.debug(userName);
				String email=rs.getString("email");
				LOGGER.debug(email);
				int age=rs.getInt("age");
				LOGGER.debug(age);
				String gender=rs.getString("gender");
				LOGGER.debug(gender);
			}
		    LOGGER.debug(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	public void insertUsers(UserListClass insert) {
		String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status,user_password) values (u_id_s.nextval,?,?,?,?,?,?,?,current_timestamp,?,?)";
		try(Connection con=ConnectionUtil.conMethod();PreparedStatement pst=con.prepareStatement(sql)) {
			
		    //Statement stmt=con.createStatement();
			//String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status) values (users_id_seq.nextval,'harrys','harrys@gmail.com',20,'male',to_date('13-01-1999','dd-MM-yyyy'),'virudhunagar','India',current_timestamp,'i_am_harry')";
			
			LOGGER.debug(sql);
			
			pst.setString(1, userName);
			pst.setString(2, email);
			pst.setInt(3, age);
			pst.setString(4, gender);
			pst.setDate(5, java.sql.Date.valueOf(dob));
			pst.setString(6, city);
			pst.setString(7, country);
			pst.setString(8, status);
			pst.setString(9, userPassword);
		   
			int rows=pst.executeUpdate();
			LOGGER.debug(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}