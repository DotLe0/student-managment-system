package io.github.dotle0.student_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.github.dotle0.student_management_system.model.Student;



public class StudentDAO {
	private Connection connection;

	public StudentDAO(Connection connection) {
		this.connection = connection;
	}

	public void addStudent(Student s) throws SQLException {
		String sql = "INSERT INTO students (firstName, lastName, classLevel) VALUES (?,?,?);";

		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, s.getFirstName());
		prep.setString(2, s.getLastName());
		prep.setString(3, s.getClassLevel());

		prep.executeUpdate();
		System.out.println("Added Student to DB");
	}

	public void removeStudent(Student s) throws SQLException {
		String sql = "DELETE FROM students WHERE firstName=? AND lastName=?;";

		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, s.getFirstName());
		prep.setString(2, s.getLastName());

		prep.executeUpdate();

		System.out.println("Deleted a student from DB");
	}

	public List<Student> getAllStudents() throws SQLException {
		List<Student> students = new ArrayList<>();

		String sql = "SELECT * FROM students";

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()) {
			students.add(new Student(
					rs.getInt("id"),
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getString("classLevel")
					));
		}

		return students;
	}
}
