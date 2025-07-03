package com.main;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

import com.model.Student;
import com.service.DatabaseService;

public class MainClass {
	public static void main(String[] args) {

		boolean isRunning = true;
		DatabaseService databaseservice = new DatabaseService();
		try (Scanner sc = new Scanner(System.in);) {
			while (isRunning) {
				System.out.println("Enter Choice :");
				System.out.println("1.Insert Student");
				System.out.println("2.Select All");
				System.out.println("3.Select Student by ID");
				System.out.println("4.Delete Student");
				System.out.println("5.Update Student");
				System.out.println("6.Exit");

				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {

				case 1:
					System.out.println("Enter name, address, score");

					databaseservice.insertStudent(
							new Student(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine())));
					break;
				case 2:

					databaseservice.getAllStudents();
					break;
				case 3:
					System.out.println("Enter id of an Student : ");
					databaseservice.getStudentById(Integer.parseInt(sc.nextLine()));

					break;
				case 4:

					System.out.println("Enter id of an Student : ");
					databaseservice.deleteStudentById(Integer.parseInt(sc.nextLine()));
					break;
				case 5:
					System.out.println("Enter id of an Student : ");
					int updateId = Integer.parseInt(sc.nextLine());
					boolean isFound = databaseservice.getStudentById(updateId);

					if (isFound) {
						System.out.println("Enter name,address, salary");
						Student student = new Student(updateId, sc.nextLine(), sc.nextLine(),
								Double.parseDouble(sc.nextLine()));
						databaseservice.updateStudent(student);
					}
					break;
				case 6:
					System.out.println("Thank You !");
					System.out.println("Visit Again");
					isRunning = false;
					break;

				default:
					System.out.println("Invalid Choice");
					break;
				}

			}
		} catch (Exception e) {

			throw new RuntimeException("Something went wrong: " + e.getMessage(), e);
		}
	}

}
