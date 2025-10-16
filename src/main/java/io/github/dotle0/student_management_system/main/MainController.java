package io.github.dotle0.student_management_system.main;

import java.awt.Label;

import javafx.fxml.FXML;

public class MainController {
	 @FXML
	 private Label greetingLabel;

	 @FXML
	 protected void onButtonClick() {
	    greetingLabel.setText("Hello from the controller!");
	 }
}
