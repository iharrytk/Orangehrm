package com.qa.orangehrm.dataproviders;

import org.testng.annotations.DataProvider;

public class SearchEmployeeDataProvider {

	@DataProvider(name = "searchEmployeedata")
	public Object[][] searchEmployeeData() {

		return new Object[][] {

				{ "ajju" } };
	}

}
