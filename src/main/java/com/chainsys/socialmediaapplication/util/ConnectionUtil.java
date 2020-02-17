package com.chainsys.socialmediaapplication.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import com.chainsys.socialmediaapplication.daoimpl.Logger;

public class ConnectionUtil {
	public static Connection conMethod() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		Logger logger=new Logger();
		logger.debug("connected");
		return con;
	}
	public static Jdbi getJdbi() throws Exception {
		Connection connection = ConnectionUtil.conMethod();
		Jdbi jdbi = Jdbi.create(connection);
		jdbi.installPlugin(new SqlObjectPlugin());
		return jdbi;
	}

}
