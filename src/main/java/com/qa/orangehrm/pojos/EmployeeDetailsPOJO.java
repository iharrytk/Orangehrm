package com.qa.orangehrm.pojos;

public class EmployeeDetailsPOJO {
	private String firstName;
	private String middleName;
	private String lastName;
	private String employeeId;
	
	public EmployeeDetailsPOJO(String firstName, String middleName, String lastName, String employeeId) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsPOJO [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", employeeId=" + employeeId + ", getFirstName()=" + getFirstName() + ", getMiddleName()="
				+ getMiddleName() + ", getLastName()=" + getLastName() + ", getEmployeeId()=" + getEmployeeId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	

}
