package com.verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.Common;
import com.framework.MyCommon;
import com.framework.Test_Result;
import com.pages.AbstractPage;

public class VerificationPage extends AbstractPage {

	public VerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Common common = new Common(driver);
	MyCommon mycommon = new MyCommon();
	
	public void verifyElement(WebElement element){
		
		try{
			
			if(element.isDisplayed()){
				
				mycommon.loging(element.getText() + " is successfully displayed " + Test_Result.PASSED);
				
				common.pause(1);
				
			}else{
				mycommon.loging(element.getText() + " is successfully displayed " + Test_Result.FAILED);
				
				common.pause(1);
			}
			
		}catch(Exception e){
			
			mycommon.loging(element.getText() + " is successfully displayed " + Test_Result.PASSED);
		}
	}

}
