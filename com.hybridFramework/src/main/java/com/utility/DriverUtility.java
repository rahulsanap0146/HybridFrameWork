package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class DriverUtility extends BaseClass {

	WebDriver driver;

	public void switchToFrameById(String id){
		driver.switchTo().frame(id);
	}
	
	public void switchToFrameByIndex(int index){
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameByElement(WebElement element){
		driver.switchTo().frame(element);
	}
	
	public void switchToWindow(String id){
		driver.switchTo().window(id);
	}
}
