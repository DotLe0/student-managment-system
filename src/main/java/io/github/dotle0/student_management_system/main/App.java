package io.github.dotle0.student_management_system.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class App extends Application
{
	
	@Override
    public void start(Stage stage) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/main-view.fxml"));
		 Scene scene = new Scene(fxmlLoader.load(), 400, 300);
		 stage.setTitle("Student Management System");
		 stage.setScene(scene);
		 stage.show();
    }
	
    public static void main( String[] args )
    {
    	launch();
    }
    
}
