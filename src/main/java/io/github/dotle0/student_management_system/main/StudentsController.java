package io.github.dotle0.student_management_system.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.github.dotle0.student_management_system.dao.StudentDAO;
import io.github.dotle0.student_management_system.model.Student;
import io.github.dotle0.student_management_system.util.DBhelper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentsController {

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField classLevel;

	@FXML
	private TableView table = new TableView<Student>();
	


	// TODO method to add, remove and show all students

	public void initialize() throws IOException, SQLException {
		
		TableColumn firstNameColumn = new TableColumn<Student, String>("First name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName")); // check upper case
																										// letter if

		TableColumn lastNameColumn = new TableColumn<Student, String>("Last name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));

		TableColumn classLevelColumn = new TableColumn<Student, String>("Class level");
		classLevelColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("classLevel"));

		table.getColumns().addAll(firstNameColumn, lastNameColumn, classLevelColumn);
		
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_LAST_COLUMN);
	}
	
	public void addStudentToDB() throws SQLException {

		if(StringUtils.isEmpty(firstName.getText()) == true ||
				StringUtils.isEmpty(lastName.getText()) == true ||
				StringUtils.isEmpty(classLevel.getText()) == true) {
			System.out.println("Invalid student data");
			return;
		}
		
		Student newStudent = new Student(firstName.getText(), lastName.getText(), classLevel.getText());

		StudentDAO studentDao = new StudentDAO(DBhelper.getConnection());

		studentDao.addStudent(newStudent);

		DBhelper.closeConnection();
	}

	public void removeStudentFromDB() throws SQLException {
		
		if(StringUtils.isEmpty(firstName.getText()) == true ||
				StringUtils.isEmpty(lastName.getText()) == true ||
				StringUtils.isEmpty(classLevel.getText()) == true) {
			System.out.println("Invalid student data");
			return;
		}
		
		Student studentToRemove = new Student(firstName.getText(), lastName.getText(), classLevel.getText());

		StudentDAO studentDao = new StudentDAO(DBhelper.getConnection());

		studentDao.removeStudent(studentToRemove);

		DBhelper.closeConnection();
	}

	public void showAllStudentsInDB() throws SQLException {
		
		StudentDAO studentDao = new StudentDAO(DBhelper.getConnection());

		List<Student> students = studentDao.getAllStudents();
		
		for (Student student : students) {
			table.getItems().add(student);
		}
		
		//table.refresh();
		
		DBhelper.closeConnection();
		
		System.out.println("Got all students");

	}
}
