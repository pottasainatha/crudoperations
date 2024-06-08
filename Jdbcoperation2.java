package com.palle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcoperation2 {
	public static String url = "jdbc:mysql://localhost:3306/Institute";
	public static String username = "root";
	public static String password = "Y1012Jqkhkp";
	public static Connection connection = null;
	public static Statement statement = null;
	public static PreparedStatement prepareStatement = null;

	public static String insert = "insert into trainer(course, salary,exp,name)values(?,?,?,?)";

	public static void insert(String name, String course, int salary, int exp) {
		try {
			Class.forName("com.sql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, username, password);
			 prepareStatement = connection.prepareStatement(insert);
			prepareStatement.setString(1, course);
			prepareStatement.setInt(2, salary);
			prepareStatement.setInt(3, exp);
			prepareStatement.setString(4, name);
			prepareStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}