package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Jdbcoperation {
	public static String url = "jdbc:mysql://localhost:3306/Institute";
	public static String username = "root";
	public static String password = "Y1012Jqkhkp";
	public static Connection connection  = null;
	public static Statement statement = null;
	public static PreparedStatement prepareStatement = null;
	
    public static String insert = "insert into trainer(course, salary,exp,name)values(?,?,?,?)";
    
	
	public static void  create()
	{
		
			
   try 
   {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection  =  DriverManager.getConnection(url, username, password);
  statement = connection.createStatement();
	statement.executeUpdate("create table trainer(tid int primary key auto_increment,"+"name varchar(20) not null,course varchar(10) default 'java',"+"salary int not null,exp int)");
	
   
  } catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
    finally {
       try
       {
    	 statement.close();
    	 connection.close();
	}  catch (SQLException e) {
		// TODO: handle exception
     e.printStackTrace();
	
	}
    }
   }
	}

