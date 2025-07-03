package com.dao;

public class Query {

	public static String insertEmployeeQuery() {
		return "INSERT INTO student_info (student_name,student_address,student_score) VALUES (?,?,?)";
	}

	public static String selectAllEmployeeQuery() {
		return "SELECT * FROM student_info";
	}

	public static String selectStudentById(int studentId) {
		return "SELECT * FROM student_info where student_id = " + studentId;

	}

	public static String deleteStudentById(int studentId) {
		return "delete from student_info where student_id = " + studentId;
	}

	public static String updateStudentQuery(int studentId) {
		return "update student_info set student_name = ?,student_address = ?,student_score = ? WHERE student_id = "
				+ studentId;
	}
}
