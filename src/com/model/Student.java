package com.model;

public class Student {
	
	private int studentID;
	
	private String studentName;
	private String studentAddress;
	private double studentScore;
	public int getStudentID() {
		return studentID;
	}
	
	public Student(String studentName, String studentAddress, double studentScore) {
		super();
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentScore = studentScore;
	}
	
	public Student(int studentID, String studentName, String studentAddress, double studentScore) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentScore = studentScore;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public double getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(double studentScore) {
		this.studentScore = studentScore;
	}
	
	

}
