package com.chainsys.socialmediaapplication.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class ConnectionUtil {
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE","soundarya","soundarya");
		Logger logger=new Logger();
		logger.debug("connected");
		return con;
	}

}
