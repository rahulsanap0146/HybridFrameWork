package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {

	public void selectByText(String text ,WebElement element){
		Select sele = new Select(element);
		sele.selectByVisibleText(text);
	}
}
