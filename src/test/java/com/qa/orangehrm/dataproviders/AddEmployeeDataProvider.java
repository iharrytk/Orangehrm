package com.qa.orangehrm.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.orangehrm.pojos.EmployeeDetailsPOJO;

public class AddEmployeeDataProvider {

	@DataProvider(name="employeedata")
	public Object[][] employeeDetails() {

		return new Object[][] {

				{"har","tha","jaya","587"}, 
				{"jay","kri","shna","999"}

		};

	}
	
	@DataProvider(name="employeedata1")
	public Object[][] employeeDetailspojo() {

		return new Object[][] {

				{new EmployeeDetailsPOJO("ajju","babu","jaya","587")}, 
				{new EmployeeDetailsPOJO("jay","kri","shna","999")}

		};

	}

}
