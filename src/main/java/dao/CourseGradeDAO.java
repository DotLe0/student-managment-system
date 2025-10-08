package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Course;
import model.Student;

public class CourseGradeDAO {
	//Show students grades
	//Show students grades per course
	private Connection connection;
	
	public CourseGradeDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void addCourseGrade(Student s, Course c, float grade) throws SQLException {
		String sql = "INSERT INTO CourseGrade (student_id, course_id, grade) VALUES ("
				+ "    (SELECT id FROM students WHERE firstName = ? AND lastName = ?),"
				+ "    (SELECT id FROM course WHERE title = ?),"
				+ "    ?);";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, s.getFirstName());
		stmt.setString(2, s.getLastName());
		stmt.setString(3, c.getTitle());
		stmt.setFloat(4, grade);
		
		stmt.executeUpdate();
		System.out.println("Added a grade to student.");
	}
	
	public void removeGrade(Student s, Course c, float grade)throws SQLException {
		String sql = "DELETE FROM CourseGrade WHERE "
				+ "    student_id = (SELECT id FROM students WHERE firstName = ? AND lastName = ?)"
				+ "    AND"
				+ "    course_id = (SELECT id FROM course WHERE title = ?)"
				+ "    AND grade=?;";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, s.getFirstName());
		stmt.setString(2, s.getLastName());
		stmt.setString(3, c.getTitle());
		stmt.setFloat(4, grade);
		
		stmt.executeUpdate();
		System.out.println("Deleted a grade.");
	}
	
	public void getStudentAverageGrade(Student s) throws SQLException {
		String sql = "SELECT AVG(grade) FROM CourseGrade WHERE "
				+ "    student_id=(SELECT id FROM students WHERE firstName=? AND lastName=?);";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, s.getFirstName());
		stmt.setString(2, s.getLastName());
		ResultSet rs = stmt.executeQuery();
		
		float avr = rs.getFloat(1);
		
		System.out.println("Average student grade: " + avr);
	}
	
	public void getStudentAverageGradeForCourse(Student s, Course c) throws SQLException {
		String sql ="SELECT AVG(grade) FROM CourseGrade WHERE "
				+ "    student_id=(SELECT id FROM students WHERE firstName=? AND lastName=?)"
				+ "    AND"
				+ "    course_id=(SELECT id FROM course WHERE title=?);";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, s.getFirstName());
		stmt.setString(2, s.getLastName());
		stmt.setString(3, c.getTitle());
		ResultSet rs = stmt.executeQuery();
		
		float avr = rs.getFloat(1);
		
		System.out.println("Average grade for course: " + avr);
	}
}
