package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.dataproviders.AddEmployeeDataProvider;
import com.qa.orangehrm.dataproviders.SearchEmployeeDataProvider;
import com.qa.orangehrm.pojos.EmployeeDetailsPOJO;

public class PIMPageTest extends BaseTest {

	@Test(dataProvider = "employeedata", dataProviderClass = AddEmployeeDataProvider.class, enabled = true,priority=4)
	public void addingEmployeeTest(String firstName, String middleName, String lastName, String empid) {

		dp = lp.doLoginWithValidCredentials();
		pp = dp.navigateToPIMPage();
		String actualMessage = pp.addEmployee(firstName, middleName, lastName, empid);
		Assert.assertEquals(actualMessage, "Personal Details");
		dp.doLogout();

	}

	@Test(dataProvider = "employeedata1", dataProviderClass = AddEmployeeDataProvider.class,description="TC_004_Validate if employee  is being added in the PIM Page",priority=5, enabled = true)
	public void addingEmployeeTestt(EmployeeDetailsPOJO pj) {

		dp = lp.doLoginWithValidCredentials();
		pp = dp.navigateToPIMPage();
		String actualMessage = pp.addEmployee(pj.getFirstName(), pj.getMiddleName(), pj.getLastName(),
				pj.getEmployeeId());
		Assert.assertEquals(actualMessage, "Personal Details");
		dp.doLogout();

	}

	@Test(dataProvider = "searchEmployeedata", dataProviderClass = SearchEmployeeDataProvider.class,description="TC_005_Validate if employee is found after search in the PIM Page",priority=6)
	public void searchEmployeeTest(String name) {

		dp = lp.doLoginWithValidCredentials();
		pp = dp.navigateToPIMPage();
		String actualMessage = pp.searchEmployee(name);
		System.out.println("The actual message returned after searching an employee:"+actualMessage);
		Assert.assertTrue(actualMessage.contains("(1) Records Found"));
		dp.doLogout();

	}

}
