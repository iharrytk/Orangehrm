package com.qa.orangehrm.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.orangehrm.driverfactory.DriverFactory;
import com.qa.orangehrm.pages.DashboardPage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.PIMPage;

public class BaseTest {
	
	private WebDriver driver;
	protected DriverFactory df;
	protected SoftAssert sa;
	protected LoginPage lp;
	protected DashboardPage dp;
	protected PIMPage pp;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browservalue) {
		df=new DriverFactory(driver);
		Properties prop=df.init_prop();
		if(browservalue!=null) {
			prop.setProperty("browser", browservalue);
		}
		driver=df.init_driver(prop);
		
		
		sa=new SoftAssert();
		lp=new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
		
	}

}
