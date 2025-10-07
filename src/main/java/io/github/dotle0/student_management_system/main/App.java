package io.github.dotle0.student_management_system.main;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDAO;
import model.Student;
import util.DBhelper;

public class App
{
    public static void main( String[] args ) throws SQLException
    {
    	wellcomeText();
    	
    	Student newStudent = new Student("George", "Russel", "10A");
    	
    	StudentDAO studentDao = new StudentDAO(DBhelper.getConnection());
    	
    	studentDao.removeStudent(newStudent);
    	
    	
    	List<Student> students = studentDao.getAllStudents();
    	
    	for(Student student : students) {
    		System.out.println(student.getFirstName() + " " + student.getLastName());
    	}
    	
    	DBhelper.closeConnection();
    	
    }
    
    public static void wellcomeText() {
    	System.out.println("Wellcome to Student-Managment-System");
    }
}
