package com.qa.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	private WebDriver driver;

	private By pageTitle = By.xpath("//span/h6[text()='Dashboard']");
	private By PIMlink = By.xpath("//span[text()='PIM']");
	private By userLogoutDropdown=By.xpath("//p[@class='oxd-userdropdown-name']");
	private By logoutLink=By.xpath("//ul[@class='oxd-dropdown-menu']/li/a[text()='Logout']");
	

	public DashboardPage(WebDriver driver) {

		this.driver = driver;
	}

	public String getDashboardTitle() {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		String dashboardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
		System.out.println("The title of dashboard page is:" + dashboardTitle);
		return dashboardTitle;
	}

	public PIMPage navigateToPIMPage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(PIMlink)).click();
		return new PIMPage(driver);

	}
	
	public void doLogout() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userLogoutDropdown)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).click();
		
		
		
	}
	
	

}
