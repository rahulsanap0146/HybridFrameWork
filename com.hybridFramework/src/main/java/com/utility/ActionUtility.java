package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class ActionUtility extends BaseClass {

	private WebDriver driver;
	public void typeIn(WebElement element,String text){
		element.sendKeys(text);
	}
	
	public void click(WebElement element){
		element.click();
	}
	
	public void dragAndDrop(WebElement source,WebElement target){
		Actions acts= new Actions(driver);
		acts.dragAndDrop(source, target).perform();
	}
	
	public WebElement getElement(String locType,String locValue){
		if(locType.equals("xpath"))
			return driver.findElement(By.xpath(locValue));
		if(locType.equals("id"))
			return driver.findElement(By.id(locValue));
		return null;
	}
}
