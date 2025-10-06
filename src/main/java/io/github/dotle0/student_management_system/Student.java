package io.github.dotle0.student_management_system;

import java.util.List;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String classLevel;
	private List<CourseGrade> coursesGrades;
	
	
	public Student(int id, String firstName, String lastName, String classLevel)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.classLevel = classLevel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassLevel() {
		return classLevel;
	}

	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	public List<CourseGrade> getCoursesGrades() {
		return coursesGrades;
	}

	public void setCoursesGrades(List<CourseGrade> coursesGrades) {
		this.coursesGrades = coursesGrades;
	}
	
	public double calculateAverageGrade()
	{
		double total = 0;
		for(CourseGrade grade : this.coursesGrades) {
			total += grade.getGrade();
		}
		double average = total / this.coursesGrades.size();
		System.out.println("Average grade: " + average);
		return average;
	}
	
	public void AddGrade(String courseTitle, double grade) {
		Course course = new Course(courseTitle);
		CourseGrade newGrade = new CourseGrade(course, grade);
		
		this.coursesGrades.add(newGrade);
		System.out.println("New grade added");
	}
}
