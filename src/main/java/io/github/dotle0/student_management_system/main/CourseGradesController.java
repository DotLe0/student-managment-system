package io.github.dotle0.student_management_system.main;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.github.dotle0.student_management_system.dao.CourseDAO;
import io.github.dotle0.student_management_system.dao.CourseGradeDAO;
import io.github.dotle0.student_management_system.model.Course;
import io.github.dotle0.student_management_system.model.CourseGrade;
import io.github.dotle0.student_management_system.model.Student;
import io.github.dotle0.student_management_system.util.DBhelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CourseGradesController {
	
	//Add course grade
	//remove course grade
	//get student average grade
	//get student average grade for a course
	//get all grades for a student
	@FXML
	private TableView tableGrades = new TableView<CourseGrade>();
	
	@FXML
	private TextField studentFirstName;
	@FXML
	private TextField studentLastName;
	@FXML
	private TextField courseName;
	@FXML
	private TextField grade;
	
	
	public void addCourseGrade() throws SQLException {
		CourseGradeDAO courseGradeDao = new CourseGradeDAO(DBhelper.getConnection());
		
		Student student = new Student(studentFirstName.getText(), studentLastName.getText(), null);
		Course course = new Course(courseName.getText());
		
		courseGradeDao.addCourseGrade(student, course, Integer.parseInt(grade.getText()));
		
		System.out.println("Added course grade");
	}
	
	public void removeCourseGrade() throws SQLException {
		CourseGradeDAO courseGradeDao = new CourseGradeDAO(DBhelper.getConnection());
		
		Student student = new Student(studentFirstName.getText(), studentLastName.getText(), null);
		Course course = new Course(courseName.getText());
		
		courseGradeDao.removeGrade(student, course, Integer.parseInt(grade.getText()));
		
		System.out.println("Removed course grade");
	}
	
	public void getStudentAverageGrade() throws SQLException {
		CourseGradeDAO courseGradeDao = new CourseGradeDAO(DBhelper.getConnection());
		
		Student student = new Student(studentFirstName.getText(), studentLastName.getText(), null);
		
		courseGradeDao.getStudentAverageGrade(student);
		
		// with a pop up message
	}
	
	public void getStudentAverageGradeForACourse() throws SQLException {
		CourseGradeDAO courseGradeDao = new CourseGradeDAO(DBhelper.getConnection());
		
		Student student = new Student(studentFirstName.getText(), studentLastName.getText(), null);
		Course course = new Course(courseName.getText());
		
		courseGradeDao.getStudentAverageGradeForCourse(student, course);
		//with a pop up message
	}
	
	public void getAllGradesForAStudent() throws SQLException {
		CourseGradeDAO courseGradeDao = new CourseGradeDAO(DBhelper.getConnection());
		
		Student student = new Student(studentFirstName.getText(), studentLastName.getText(), null);
		Course course = new Course(courseName.getText());
		
		courseGradeDao.getAllGradesForStudent(student);
		//table view
		
	}
}
