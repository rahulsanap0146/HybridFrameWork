package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;
import com.utility.ExcelUtility;

public class LoginTest extends BaseClass {
	LoginPage lp =null;
	ExcelUtility eu=null;
	@Test
	public void test(){
		lp= new LoginPage(driver);
		lp.validLogin();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | dashboard");
	}
	
}
