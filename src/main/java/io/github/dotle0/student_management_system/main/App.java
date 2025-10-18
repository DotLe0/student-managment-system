package io.github.dotle0.student_management_system.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application
{

	@Override
    public void start(Stage stage) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/io/github/dotle0/student_management_system/main/main-view.fxml"));
		 Scene scene = new Scene(fxmlLoader.load());
		 stage.setTitle("Student Management System");
		 stage.setScene(scene);
		 stage.show();
    }

    public static void main( String[] args )
    {
    	launch(args);
    }

}
