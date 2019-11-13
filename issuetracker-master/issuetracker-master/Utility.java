package com.learn.issuetracker.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.learn.issuetracker.model.Employee;
import com.learn.issuetracker.model.Issue;

/*
 * This class has methods for parsing the String read from the files in to corresponding Model Objects
*/
public class Utility {

	/*
	 * parseEmployee takes a string with employee details as input parameter and
	 * parses it in to an Employee Object
	 */
	public static Employee parseEmployee(String employeeDetail) {
		String[] employeeDetails=employeeDetail.split(",");
		return new Employee(Integer.parseInt(employeeDetails[0]), employeeDetails[1], employeeDetails[2]);
	}

	/*
	 * parseIssue takes a string with issue details and parses it in to an Issue
	 * Object. The employee id in the Issue details is used to search for an an
	 * Employee, using EmployeeRepository class. If the employee is found then it is
	 * set in the Issue object. If Employee is not found, employee is set as null in
	 * Issue Object
	 */

	public static Issue parseIssue(String issueDetail) {
		String[] issueDetails=issueDetail.split(",");
		Optional<Employee> emp=EmployeeRepository.getEmployee(Integer.parseInt(issueDetails[6]));
		return new Issue(issueDetails[0], issueDetails[1], LocalDate.parse(issueDetails[2],DateTimeFormatter.ofPattern("dd/MM/yyyy")
				), LocalDate.parse(issueDetails[3],DateTimeFormatter.ofPattern("dd/MM/yyyy")
						), issueDetails[4], issueDetails[5],emp.isPresent()?emp.get():null);
				
	}
}
