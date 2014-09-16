package com.demo;

import org.testng.annotations.Test;

import com.framework.Common;
import com.framework.MyCommon;
import com.framework.SeleniumInit;
import com.pages.IndexPage;
import com.verification.VerificationPage;


public class CalculatorApp extends SeleniumInit {
	
		public CalculatorApp() {
			// TODO Auto-generated constructor stub
		}

		Common common = new Common(driver);
		MyCommon mycommon = new MyCommon();
		
		
		
	
		@Test
		public void VerifyCalc(){
			
		mycommon.log_case("TestCase : 1 To verify Calculator open successfully");
		
		common.pause(5);
		
		mycommon.log_step("Step 1: Open Calculator");
		
		common.pause(2);
		
		mycommon.log_step("Step 2: Verify all buttons of calculator");
		
		common.pause(2);
				
		indexpage.openCalc();
		
		common.pause(2);
		
		mycommon.log_testover();
		
		}
		
		int second,first;
		
		@Test
		public void AddFunctionality(){
			
			mycommon.log_case("TestCase : 2 To verify Addition Functionality of Calculator");
			
			common.pause(5);
			
			mycommon.log_step("Step 1: Open Calculator");	
			
			common.pause(5);
			
			mycommon.log_step("Step 2: Enter First Value");
			
			first = indexpage.clickonButton();
			
			common.pause(2);
			
			mycommon.log_step("Step 3: Click on + Sign");
			
			indexpage.clickPlus();
			
			common.pause(2);
			
			mycommon.log_step("Step 4: Enter Second value");
			
			second = indexpage.clickonButton();
			
			common.pause(2);
			
			mycommon.log_step("Step 5: Click on = sign");
			
			indexpage.clickEqual();
			
			common.pause(2);
			
			indexpage.verifyAddOutput(first,second);
			
			common.pause(2);
			
			mycommon.log_testover();
			
		}
}
