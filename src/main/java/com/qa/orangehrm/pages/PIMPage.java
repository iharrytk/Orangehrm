package com.qa.orangehrm.pages;

import java.time.Duration;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private By searchResultMessageInEmployeeList = By
			.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']");
	private By deleteButtonWhenDeletetingEmployee = By.xpath("//i[@class='oxd-icon bi-trash']");
	private By yesDeleteButton = By
			.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
	private By messageAfterDeletingRecord = By.xpath("//span[text()='No Records Found']");
	private By employeeListPagination = By.xpath("//div[@class='orangehrm-bottom-container']/nav/ul/li/button");
	//private By employeeRows = By.xpath(
			//"((//div[@class='oxd-table orangehrm-employee-list']//div[@class='oxd-table-body']//div[@class='oxd-table-card'])/div)");
	private By employeesLastName = By
			.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div[4]");

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

	public String deleteEmployee(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeList)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInEmployeeList)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchButtonInEmployeeList)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButtonWhenDeletetingEmployee)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(yesDeleteButton)).click();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(messageAfterDeletingRecord)).getText();

	}

	public List<String> employeeList() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeList)).click();
		List<WebElement> ele = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employeeListPagination));
		List<String> employeelist = new ArrayList<String>();
		for (int i = 0; i < ele.size(); i++) {

			try {

				int page = Integer.parseInt(ele.get(i).getText());
				System.out.println("We are in page:" + page);
				ele.get(i).click();
				//List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employeeRows));
				List<WebElement> cols = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(employeesLastName));
				//for (int j = 0; j < rows.size(); j++) {

					for (int k = 0; k < cols.size(); k++) {
						
						String lastName = cols.get(k).getText();
						System.out.println(lastName);
						employeelist.add(lastName);
					}

			//	}

			} catch (Exception e) {
				System.out.println("Not a page number in Web table");
			}
		}
		return employeelist;
	}

}
