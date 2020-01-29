package com.chainsys.socialmediaapplication.userlist;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
//import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserListClass  implements UserListDAO {
	
	public int  userId;
	public String userName;
	public String email;
	public int age;
	public String gender;
	public LocalDate dob;
	public String city;
	public String country;
	LocalDateTime createdDate;
	public String status;
	public String userPassword;
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println("connected");
		return con;
	}
	@Override
	public String toString() {
		return "UserListClass [userId=" + userId + ", userName=" + userName + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", city=" + city + ", country=" + country + ", createdDate="
				+ createdDate + ", status=" + status + "]";
	}
		
	public String[] searchByCity(String city) {
			try{
				Connection con=conMethod();
			    Statement stmt=con.createStatement();
				String sql = "select user_name,gender from user_list where city='"+city+"'";
				System.out.println(sql);
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String userName=rs.getString("user_name");
					System.out.println(userName);
					String gender=rs.getString("gender");
					System.out.println(gender);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
    }

	public int noOfUsers()
	{
		int totalcount = 0;
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select count(*) as total_count from user_list" ;
		    ResultSet rs=stmt.executeQuery(sql);
		    if(rs.next())
			{
				totalcount=rs.getInt("total_count");
				System.out.println("Total :" + totalcount);
			}
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		return totalcount;
	}
	

	public String[] nameLike(String searchname) {
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
			String sql = " select * from user_list where user_name like '%"+searchname+"%'" ;
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println(sql);
		    while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				System.out.println(userId);
				String userName=rs.getString("user_name");
				System.out.println(userName);
				String email=rs.getString("email");
				System.out.println(email);
				int age=rs.getInt("age");
				System.out.println(age);
				String gender=rs.getString("gender");
				System.out.println(gender);
				Date dob=rs.getDate("dob");
				System.out.println(dob);
				String city=rs.getString("city");
				System.out.println(city);
				String country=rs.getString("country");
				System.out.println(country);
				Date createdDate=rs.getDate("created_date");
				System.out.println(createdDate);
				String status=rs.getString("status");
				System.out.println(status);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return null;
	}
	public String[] searchByAge(int age) {
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
			String sql = "select user_name from user_list where age >="+age;
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println(sql);
		    while(rs.next())
			{
				String userName=rs.getString("user_name");
				System.out.println(userName);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return null;
	}
	public void insertUsers(UserListClass insert) {
		
		try {
			Connection con=conMethod();
		    //Statement stmt=con.createStatement();
			//String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status) values (users_id_seq.nextval,'harrys','harrys@gmail.com',20,'male',to_date('13-01-1999','dd-MM-yyyy'),'virudhunagar','India',current_timestamp,'i_am_harry')";
			String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status,user_password) values (u_id_s.nextval,?,?,?,?,?,?,?,current_timestamp,?,?)";
			System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
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
			System.out.println(rows+"Rows inserted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public String displayUser(String emailid) {
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
			String sql = "select * from user_list  where email='"+emailid+"'";
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println(sql);
		    while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				//System.out.println(userId);
				String userName=rs.getString("user_name");
				//System.out.println(userName);
				String email=rs.getString("email");
				//System.out.println(email);
				int age=rs.getInt("age");
				//System.out.println(age);
				String gender=rs.getString("gender");
				//System.out.println(gender);
				Date dob=rs.getDate("dob");
				//System.out.println(dob);
				String city=rs.getString("city");
				//System.out.println(city);
				String country=rs.getString("country");
				//System.out.println(country);
				Date createdDate=rs.getDate("created_date");
				//System.out.println(createdDate);
				String status=rs.getString("status");
				//System.out.println(status);
				String userId1=String.valueOf(userId);
				String age1=String.valueOf(age);
				String dob1=String.valueOf(dob);
				String createdDate1=String.valueOf(createdDate);

				String newResult= "Id:"+userId1+"\n"+"Name:"+userName+"\n"+"Email:"+email+"\n"+"Age:"+age1+"\n"+"Gender:"+gender+"\n"+"Date of Birth:"+dob1+"\n"+"City:"+city+"\n"+"Country:"+country+"\n"+"Created Date:"+createdDate1+"\n"+"Status:"+status;
				//System.out.println(newResult);
				//file write
				FileUtil.WriteFile("display.txt",newResult,StandardOpenOption.APPEND);
				System.out.println("Exported Successfully");

				//file read
				String fname="display.txt";
				Path path=Paths.get(fname);
				
				byte[] bytes=Files.readAllBytes(path);
				String content=new String(bytes);
				System.out.println(content);
				System.out.println("Imported Successfully");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateActiveStatus(String username) {
		try {
			Connection con=conMethod();
		    //Statement stmt=con.createStatement();
			//String sql = "insert into user_list(user_id,user_name,email,age,gender,dob,city,country,created_date,status) values (users_id_seq.nextval,'harrys','harrys@gmail.com',20,'male',to_date('13-01-1999','dd-MM-yyyy'),'virudhunagar','India',current_timestamp,'i_am_harry')";
			String sql = "update user_list set active_status='inactive' where user_name=?";
			System.out.println(sql);
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, username);
			
			int rows=pst.executeUpdate();
			System.out.println(rows+"Rows updated");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void userLogin(String email, String password) {
		try{
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
			String sql = "select email,user_password from user_list where email='"+email+"'";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String email1=rs.getString("email");
				//System.out.println(email1);
				String password1=rs.getString("user_password");
				//System.out.println(password1);
				if(email1.equals(email) && password1.equals(password))
					System.out.println(email1+" Successfully Logged in");
			}
			else
			{
				System.out.println("Login Failed");	

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	public void updatePassword(String email,String oldPassword,String newPassword)
	{
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "update user_list set user_password = '"+newPassword+"' where email='"+email+"' and user_password='"+oldPassword+"'";
		    System.out.println(sql);
		    int rows=stmt.executeUpdate(sql);
		    System.out.println(rows +" password updated");
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String[] searchByCityAndName(String a,String city) {
		try {
			Connection con=conMethod();
		    Statement stmt=con.createStatement();
		    String sql = "select user_id,user_name,email,age,gender from user_list where user_name like '"+a+"%' and city='"+city+"'";
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
			{
		    	int userId=rs.getInt("user_id");
				System.out.println(userId);
				String userName=rs.getString("user_name");
				System.out.println(userName);
				String email=rs.getString("email");
				System.out.println(email);
				int age=rs.getInt("age");
				System.out.println(age);
				String gender=rs.getString("gender");
				System.out.println(gender);
			}
		    System.out.println(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}
}