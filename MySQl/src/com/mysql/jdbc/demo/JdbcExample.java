package com.mysql.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			// Register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Create the database connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootjdbc", "root", "root");
			// Create the statement / prepared statement object
			System.out.println("Database connected successfully!");
			
			stmt = con.createStatement();
			// Execute the SQLs
			String insertSql = "insert into user values (2, 'Sujith', 'sj', 'sujith@gill.com', '@1234', '2003-01-12', 'R')";
			int status = stmt.executeUpdate(insertSql);
			System.out.println(status);
			
			String selectSql = "select * from user";
			
			ResultSet rs = stmt.executeQuery(selectSql);
			while(rs.next()) {
				System.out.println("ID = " + rs.getString("id")
				                + " first name = " + rs.getString("firstname")
				                + " last name =" + rs.getString("lastname")
				                + " email =" + rs.getString("email")
				                + " password = " + rs.getString("password")
				                + " DOB = " + rs.getString("birth_date")
				                 + " Gender = " + rs.getString("gender")); 
			}
			
			// Close the database connection
			con.close();
			
			System.out.println("database connection closed !");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	}

}

