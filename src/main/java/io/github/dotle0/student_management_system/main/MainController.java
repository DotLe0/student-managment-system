package io.github.dotle0.student_management_system.main;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainController {

	@FXML
	private AnchorPane contentArea;

	@FXML
	private Label greetingLabel;
	@FXML
	private Button studentsBtn;
	@FXML
	private Button coursesBtn;
	@FXML
	private Button gradesBtn;
	
	
	public void initialize() throws IOException {
		loadView("students.fxml");
	}
	
	public void showStudents() throws IOException {
		loadView("students.fxml");
	}
	
	public void showCourses() throws IOException {
		loadView("courses.fxml");
	}
	
	public void showGrades() throws IOException {
		loadView("grades.fxml");
	}

	private void loadView(String fxml) throws IOException {
		AnchorPane pane = FXMLLoader
				.load(getClass().getResource("/io/github/dotle0/student_management_system/main/" + fxml));
		contentArea.getChildren().setAll(pane);
	}
}
