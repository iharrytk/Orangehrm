package com.qa.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeavePage  {
	
	private WebDriver driver;
	private By assignLeave=By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[7]/a");
	private By employeeNameInAssignLeave=By.xpath("//input[@placeholder='Type for hints...']");
	private By leaveTypeDropDownInAssignLeave=By.xpath("//div[@class='oxd-select-text--after']/i");
	private By employeeNAme=By.xpath("//span[text()='Charlotte  Smith']");
	private By leaveFromInAssignLeave=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	//private By leaveToInAssignLeave=By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
	private By assignInLeaveType=By.xpath("//button[text()=' Assign ']");
	
	public LeavePage(WebDriver driver) {
		
	this.driver=driver;
	
	}

	
	public void assignLeave() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(assignLeave)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInAssignLeave)).sendKeys("charlotte");
		wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNAme));
		Actions ac=new Actions(driver);
		ac.moveToElement(driver.findElement(employeeNAme)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeDropDownInAssignLeave)).click();
		By leaveTypeInAssignLeave=By.xpath("//div[@class='oxd-select-option']//span[text()='CAN - Bereavement']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeInAssignLeave));
		ac.moveToElement(driver.findElement(leaveTypeInAssignLeave)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(leaveFromInAssignLeave)).sendKeys("2025-20-12");
		wait.until(ExpectedConditions.visibilityOfElementLocated(assignInLeaveType)).click();
		
		
	}
}
