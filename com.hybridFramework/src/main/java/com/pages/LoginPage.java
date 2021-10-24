package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id = "email")
	private WebElement uname;

	@FindBy(id = "password")
	private WebElement pass;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//img")
	private WebElement jbkLogo;

	@FindBy(xpath = "//b")
	private WebElement jbkTagLine;

	@FindBy(xpath = "//h4")
	private WebElement courseName;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public DashboardPage validLogin(){
		uname.clear();
		pass.clear();
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginBtn.click();
		return new DashboardPage(driver);		
	}
	
	public void inValidLogin(String username,String password){
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginBtn.click();
	}

}
