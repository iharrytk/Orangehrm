package com.qa.orangehrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	
	private By username=By.xpath("//input[@name='username']");
	private By password=By.xpath("//input[@name='password']");
	private By loginButton=By.xpath("//button[@type='submit']");
	private By forgotPasswordLink=By.xpath("//p[text()=\"Forgot your password? \"]");
	private By invalidCredentialsMessage=By.xpath("//p[text()='Invalid credentials']");
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;	
	}
	
	public DashboardPage doLoginWithValidCredentials() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("Admin");
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(loginButton).click();
		return new DashboardPage(driver);
		
		
		
	}
	public String doLoginWithInvalidCredentials() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("Admin");
		driver.findElement(password).sendKeys("123");
		driver.findElement(loginButton).click();
		//String invalidMessage=driver.findElement(invalidCredentialsMessage).getText();
		String invalidMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsMessage)).getText();
		return invalidMessage;
		
	}
	public boolean forgotPasswordLink() {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));
		
		return ele.isEnabled();
	}

	


}
