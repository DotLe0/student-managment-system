package io.github.dotle0.student_management_system.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import model.*;
import util.DBhelper;

public class App
{
    public static void main( String[] args ) throws SQLException
    {
    	wellcomeText();
    	
    	
    	
    	CourseDAO courseDao = new CourseDAO(DBhelper.getConnection());
    	
    	List<Course> courses = courseDao.showAllCourses();

    	for(Course course : courses) {
    		courseDao.removeCourse(course);
    	}
    	
    	DBhelper.closeConnection();
    	
    }
    
    public static void wellcomeText() {
    	System.out.println("Wellcome to Student-Managment-System");
    }
}
