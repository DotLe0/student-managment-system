package io.github.dotle0.student_management_system.main;

import java.sql.SQLException;
import java.util.List;

import dao.*;
import model.*;
import util.DBhelper;

public class App
{
    public static void main( String[] args ) throws SQLException
    {
    	wellcomeText();
    	
    	CourseGradeDAO courseGradeDao = new CourseGradeDAO(DBhelper.getConnection());
    	StudentDAO studentDao = new StudentDAO(DBhelper.getConnection());
    	CourseDAO courseDao = new CourseDAO(DBhelper.getConnection());
    	
    	Student student1 = new Student("Liliya", "Mateeva", "12A");
    	Course course1 = new Course("Programirane");
    	Course course2 = new Course("BEL");
    	/*
    	studentDao.addStudent(student1);
    	courseDao.addCourse(course1);
    	courseDao.addCourse(course2);
    	*/
    	//courseGradeDao.addCourseGrade(student1, course1, 6);
    	//courseGradeDao.addCourseGrade(student1, course1, 4);
    	//courseGradeDao.addCourseGrade(student1, course1, 6);
    	//courseGradeDao.addCourseGrade(student1, course2, 6);

    	courseGradeDao.getStudentAverageGrade(student1);
    	courseGradeDao.getStudentAverageGradeForCourse(student1, course1);
    	
    	courseGradeDao.removeGrade(student1, course2, 6);
    	
    	DBhelper.closeConnection();
    	
    }
    
    public static void wellcomeText() {
    	System.out.println("Wellcome to Student-Managment-System");
    }
}
