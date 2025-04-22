package com.qa.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {

	private WebDriver driver;

	private By addEmployee = By.xpath("//div[@class='oxd-topbar-body']//a[text()='Add Employee']");
	private By addFirstName = By.xpath("//input[@name='firstName']");
	private By addMiddleName = By.xpath("//input[@name='middleName']");
	private By addLastName = By.xpath("//input[@name='lastName']");
	private By addEmployeeId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private By saveButton = By.xpath("//button[normalize-space()='Save']");
	private By personalDetailsText = By.xpath("//h6[text()='Personal Details']");
	private By employeeList = By.xpath("//a[text()='Employee List']");
	private By employeeNameInEmployeeList = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	private By searchButtonInEmployeeList = By.xpath("//button[@type='submit']");
	private By searchResultMessageInEmployeeList = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']");

	public PIMPage(WebDriver driver) {

		this.driver = driver;
	}

	public String addEmployee(String firstName, String middleName, String lastName, String empid) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployee)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addFirstName)).sendKeys(firstName);
		driver.findElement(addLastName).sendKeys(middleName);
		driver.findElement(addMiddleName).sendKeys(lastName);
		driver.findElement(addEmployeeId).sendKeys(empid);
		driver.findElement(saveButton).click();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsText)).getText();

	}

	public String searchEmployee(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeList)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInEmployeeList)).sendKeys(name);
		driver.findElement(searchButtonInEmployeeList).click();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultMessageInEmployeeList)).getText();

	}

}
