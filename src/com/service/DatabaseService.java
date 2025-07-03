package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.Database;
import com.model.Student;
import com.dao.Query;


public class DatabaseService {
	Database databaseUtil = new Database();

	public void insertStudent(Student student) throws SQLException {
		try (Connection connection = databaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Query.insertEmployeeQuery())) {
			preparedStatement.setString(1, student.getStudentName());
			preparedStatement.setString(2, student.getStudentAddress());
			preparedStatement.setDouble(3, student.getStudentScore());

			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("Record Created Successfully");
			} else {
				System.out.println("Insert record failed");
			}
		}
	}// end of insert employee method

	public void getAllStudents() throws SQLException {

		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.selectAllEmployeeQuery())) {

			while (resultSet.next()) {
				printStudent(new Student(resultSet.getInt("student_id"), resultSet.getString("student_name"),
						resultSet.getString("student_address"), resultSet.getDouble("student_score")));
			}

		}
	}// end of get all employees

	private void printStudent(Student student) {
		System.out.println("Student id: " + student.getStudentID());
		System.out.println("Student name : " + student.getStudentName());
		System.out.println("Student Address : " + student.getStudentAddress());
		System.out.println("Student score : " + student.getStudentScore());
		System.out.println("--------------------------------------------------------------------");
	}

	public boolean getStudentById(int id) throws SQLException {
		
		boolean isFound=false;
		try (Connection connection = databaseUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.selectStudentById(id));) {
			if (resultSet.next()) {
				isFound=true;
				printStudent(new Student(resultSet.getInt("student_id"), resultSet.getString("student_name"),
						resultSet.getString("student_address"), resultSet.getDouble("student_score")));

			} else {
				System.out.println("Record not Found for id " + id);
			}
		}
      return isFound;
	}// End of get student by id
    public void deleteStudentById(int studentId) throws SQLException {
    	try(Connection connection=databaseUtil.getConnection();
    			Statement statement=connection.createStatement();){
    		int rows=statement.executeUpdate(Query.deleteStudentById(studentId));
    		if(rows>0) {
    			System.out.println("Record deleted Successfully");
    		}else {
    			System.out.println("Something Went Wrong");
    		}
    	}
    	
    }//End of deleteStudentById
    public void updateStudent(Student student) throws SQLException {
    	
    	try(Connection connection=databaseUtil.getConnection();
    			PreparedStatement preparedStatement=connection.prepareStatement(Query.updateStudentQuery(student.getStudentID()))){
    				preparedStatement.setString(1, student.getStudentName());
    				preparedStatement.setString(2, student.getStudentAddress());
    				preparedStatement.setDouble(3, student.getStudentScore());

    				int rows=preparedStatement.executeUpdate();
    				if(rows>0) {
    					System.out.println("Record updated successfully.");
    				}
    				else {
    					System.out.println("Failed to update redcord.");
    				}
    			}
    	
    }//end of update method
}
