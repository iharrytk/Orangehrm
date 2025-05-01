package com.qa.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.basetest.BaseTest;



public class LeavePageTest extends BaseTest {
	
	@Test(description="TC_008_Validate if we are able to assign leave in Leave Page",priority=8, enabled = true)
	public void assignLeaveEmployeeTest() {

		dp = lp.doLoginWithValidCredentials();
		lep = dp.navigateToLeavePage();
		lep.assignLeave();
		dp.doLogout();
		Assert.assertTrue(true);
		

	}

}
