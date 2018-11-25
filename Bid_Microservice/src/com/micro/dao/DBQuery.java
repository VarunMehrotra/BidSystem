package com.micro.dao;
import java.sql.*;

public class DBQuery {
	
	public static ResultSet getResult(String sql) {
		ResultSet resultSet = null;
		try {
			Connection connection = DBConnection.getConnection();
			
			Statement stmt = connection.createStatement();
			resultSet = stmt.executeQuery(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return resultSet;
	}
	
	public static void insertResult(String sql) {
		try {
			Connection connection = DBConnection.getConnection();
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
