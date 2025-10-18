package io.github.dotle0.student_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import io.github.dotle0.student_management_system.model.Course;




public class CourseDAO {
	//show all courses

	private Connection connection;

	public CourseDAO(Connection connection) {
		this.connection = connection;
	}

	public void addCourse(Course c) throws SQLException {

		String sql = "INSERT INTO course (title) VALUES(?);";
		// maybe add a if to see if the course exists.
		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, c.getTitle());
		prep.executeUpdate();

		System.out.println("Added a course to DB");
	}

	public void removeCourse(Course c) throws SQLException {
		String sql = "DELETE FROM course WHERE title=?;";

		PreparedStatement prep = connection.prepareStatement(sql);
		prep.setString(1, c.getTitle());
		prep.executeUpdate();

		System.out.println("Course deleted from DB.");
	}

	public List<Course> showAllCourses() throws SQLException {
		String sql = "SELECT * FROM course;";

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Course> courses = new ArrayList<>();

		while(rs.next()) {
			courses.add(new Course(
					rs.getInt("id"),
					rs.getString("title")
					));
		}

		return courses;
	}
}
