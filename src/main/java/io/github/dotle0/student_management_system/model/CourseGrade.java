package io.github.dotle0.student_management_system.model;

public class CourseGrade {
	private int id;
	private String courseId;
	private String studentId;
	private double grade;
	
	public CourseGrade(String courseId, String studentId, double grade) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	} 
}
