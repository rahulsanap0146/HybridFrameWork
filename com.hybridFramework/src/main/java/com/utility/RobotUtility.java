package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.base.BaseClass;

public class RobotUtility extends BaseClass {
	
	Robot r=null;
	public void pressEnter(){
		try {
			 r = new Robot();
			 r.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public void pressTab(){
		try {
			r= new Robot();
			r.keyPress(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
}
