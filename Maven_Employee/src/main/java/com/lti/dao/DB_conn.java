package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_conn 
{
	public static Connection getConn()
	{
		try 
		{   
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver connected");
		}
		catch(ClassNotFoundException ex) 
		{   
			System.out.println("Error: unable to load driver class!");
		}
		String url="jdbc:oracle:thin:@LAPTOP-F8T02IG7:1521:xe";
       String un="system";
       String pwd="Newuser123";
        Connection con=null;;
        try 
        {
			con=DriverManager.getConnection(url,un,pwd);
			System.out.println("Connection established");
		} 
        catch (SQLException e) 
        {
			//e.printStackTrace();
        	System.out.println(e);
		}
        return con;
	}
}
