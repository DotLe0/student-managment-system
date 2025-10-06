package io.github.dotle0.student_management_system.model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String classLevel;
	
	
	public Student(String firstName, String lastName, String classLevel)
	{
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
}
