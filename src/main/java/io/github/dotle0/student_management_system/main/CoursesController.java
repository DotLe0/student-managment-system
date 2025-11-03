package io.github.dotle0.student_management_system.main;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.github.dotle0.student_management_system.dao.CourseDAO;
import io.github.dotle0.student_management_system.model.Course;
import io.github.dotle0.student_management_system.util.DBhelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CoursesController {
	@FXML
	private TableView tableCourses = new TableView<Course>();
	@FXML
	private TextField txtTitle;
	@FXML
	private Button btnAddCourse;
	@FXML
	private Button btnRemoveCourse;
	@FXML
	private Button btnShowAllCourses;
	
	public void initialize() {
		TableColumn courseTitle = new TableColumn<Course, String>("Course Title");
		courseTitle.setCellValueFactory(new PropertyValueFactory<Course, String>("title"));
		
		tableCourses.getColumns().add(courseTitle);
		
		tableCourses.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_LAST_COLUMN);
	}
	
	public void addCourse() throws SQLException {
		
		String title = txtTitle.getText();
		if(StringUtils.isEmpty(title) == true) {
			System.out.println("Invalid title for course");
			return;
		}
		
		CourseDAO courseDao = new CourseDAO(DBhelper.getConnection());
		
		Course newCourse = new Course(title);
		
		courseDao.addCourse(newCourse);
		
		DBhelper.closeConnection();
		System.out.println("Added a course");
	}
	
	public void removeCourse() throws SQLException {
		String title = txtTitle.getText();
		if(StringUtils.isEmpty(title) == true) {
			System.out.println("Invalid title for course");
			return;
		}
		
		CourseDAO courseDao = new CourseDAO(DBhelper.getConnection());
		
		Course removeCourse = new Course(title);
		
		courseDao.removeCourse(removeCourse);
		
		DBhelper.closeConnection();
		System.out.println("Removed a course");
	}
	
	public void showAllCourses() throws SQLException {System.out.println("Added a course");
		CourseDAO courseDao = new CourseDAO(DBhelper.getConnection());
		
		List<Course> courses = courseDao.showAllCourses();
		
		for(Course course : courses) {
			tableCourses.getItems().add(course);
		}
		
		DBhelper.closeConnection();
		System.out.println("Showed every course");
	}
}
