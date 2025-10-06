package io.github.dotle0.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args )
    {
    	String jdbcUrl = "jdbc:sqlite:SMSDB.db";
    	
    	try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			
			String sql = "CREATE TABLE students ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "firstName TEXT NOT NULL,"
					+ "lastName TEXT NOT NULL,"
					+ "classLevel TEXT NOT NULL,"
					+ "";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void wellcomeText() {
    	System.out.println("Wellcome to Student-Managment-System");
    }
}
