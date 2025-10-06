package io.github.dotle0.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args )
    {
    	final String jdbcUrl = "jdbc:sqlite:SMSDB.db";
    	
    	try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			
			String sql = "CREATE TABLE courseGrade ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "student_id INT NOT NULL,"
					+ "course_id INT NOT NULL,"
					+ "grade FLOAT,"
					+ "FOREIGN KEY (student_id) REFERENCES students(id),"
					+ "FOREIGN KEY (course_id) REFERENCES course(id),"
					+ "UNIQUE (student_id, course_id));";
			PreparedStatement prep = connection.prepareStatement(sql);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void wellcomeText() {
    	System.out.println("Wellcome to Student-Managment-System");
    }
}
