package com.learn.issuetracker.model;

/*
 * Model class for storing Employee details. Complete the code as per the comments given below
*/
public class Employee {

	private int emplId;
	private String name;
	private String location;

	public Employee() {
	}

	/*
	 * Complete the parameterized Constructor
	 */
	public Employee(int emplId, String name, String location) {
		this.emplId=emplId;
		this.name=name;
		this.location=location;
	}

	/*
	 * Complete the Getter and Setters
	 */
	public int getEmplId() {
		return this.emplId;
	}

	public void setEmplId(int emplId) {
		this.emplId=emplId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
			this.location=location;
	}

	/*
	 * Override toString() here
	 */

	@Override
	public String toString() {
		return "Employee [emplId=" + emplId + ", name=" + name + ", location=" + location + "]";
	}

}