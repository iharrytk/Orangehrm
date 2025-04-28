package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.orangehrm.basetest.BaseTest;
import com.qa.orangehrm.pages.DashboardPage;

public class LoginPageTest extends BaseTest {

	@Test(priority=1,description = "TC_003_Validate if Forgot password link is present on Login Page",enabled=true)
	public void forgotPasswordLinkTest() {
		Boolean linkavailability = lp.forgotPasswordLink();
		Assert.assertTrue(linkavailability);

	}

	@Test(priority=2,description = "TC_002_Validate Login Page with Invalid credentials",enabled=true)
	public void loginWithInvalidCredentialsTest() {

		String actualMessage = lp.doLoginWithInvalidCredentials();
		Assert.assertEquals(actualMessage, "Invalid credentials");

	}

	@Test(priority=3,description = "TC_001_Validate Login Page with valid credentials")
	public void loginWithValidCredentialsTest() {
		DashboardPage dp = lp.doLoginWithValidCredentials();
		String actualTitle = dp.getDashboardTitle();
		Assert.assertEquals(actualTitle, "Dashboard");
		dp.doLogout();
		
	}
	
	
	

}
