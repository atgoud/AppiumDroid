package com.linkedin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.linkedin.init.Common;
import com.linkedin.init.ILoggerStatus;
import com.linkedin.init.SeleniumInit;
import com.linkedin.init.Test_Result;

public class CreateNewAccount_Verification extends AbstractPage {
	
	Common common = new Common(driver);
	
	@FindBy(xpath = ".//*[@id='firstName-coldRegistrationForm']")
	private WebElement firstname_textfield;
	
	@FindBy(xpath = ".//*[@id='lastName-coldRegistrationForm']")
	private WebElement lastname_textfield;
	
	@FindBy(xpath = ".//*[@id='email-coldRegistrationForm']")
	private WebElement email_textfield;
	
	@FindBy(xpath = ".//*[@id='password-coldRegistrationForm']")
	private WebElement password_textfield;
	
	@FindBy(xpath = ".//*[@id='global-error']/div")
	private WebElement validation_msg;
	

	public CreateNewAccount_Verification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void openURL(){
		
		common.pause(1);
		
		common.log("Opening URL <br>");
		
		common.pause(2);
		
		if(driver.getTitle().endsWith("LinkedIn"))
			common.log("Page open succesfully");
	}
	
	public void LabelverificationMethod(WebElement webElement,String onForm)
	{
		if(webElement.isDisplayed()){
		common.log("<b>" + webElement.getText()+" <b> Label is Displayed on "+onForm+" "+Test_Result.PASSED +"</h3><br> ");
		}
		
		else{
			common.log("<b> " +webElement.getText()+" <b> Label isn't Displayed on "+onForm+""+Test_Result.FAILED +"</h3><br>");
		}
		
		//common.log("<hr></hr>");
	}
	
	
	
	
	
	

	public void fieldsVerification(WebElement webElement,String onForm) {
		// TODO Auto-generated method stub
		
		if(webElement.isDisplayed()){
			//common.log(webElement.getText()+" textbox is Displayed on "+onForm+"<br>");
			}
			
			else{
				common.log(webElement.getText()+" textbox isn't Displayed on "+onForm+"<br>");
			}
			
		common.pause(2);
	}

	public void verifyTextfield(WebElement webElement, String onForm) {
		// TODO Auto-generated method stub
		
		
		webElement.sendKeys("editable");
		common.pause(2);
		
		String text = webElement.getAttribute("value");
		
		common.pause(2);
		
		if(text.equals("editable")){
			
			//common.log(" textbox is "+ text +"<br> ");
			
		}else{
			
			common.log(" textbox is not "+ text +"<br> ");
		}
		
		common.pause(2);
	}

	@FindBy(xpath = ".//*[@id='recaptcha_area']")
	private WebElement captcha_verification;
	
	
	public void firstname_validation() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(validation_msg.isDisplayed()){
				
				common.log(" User see validation message "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}
	}

	public void lastname_validation() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(validation_msg.isDisplayed()){
				
				common.log(" User see validation message "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}
	}

	public void emailid_validation() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(validation_msg.isDisplayed()){
				
				common.log(" User see validation message "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}

	}

	public void password_validation() {
		// TODO Auto-generated method stub
		
		
		common.pause(2);
		
		try{
			
			if(validation_msg.isDisplayed()){
				
				common.log(" User see validation message "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" User can't see any validation message "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}
		
	}

	public void datavalidation_success() {
		// TODO Auto-generated method stub
		

		common.pause(2);
		
		try{
			
			if(!validation_msg.isDisplayed()){
				
				common.log(" User successfully registered "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log(" Error! User failed to register "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" Error! User failed to register "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}
		
	}

	public void onclick_verify() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(driver.getTitle().equals("Phone Verification | LinkedIn")){
				
				common.log(" ENTER key functionality working "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log(" Error! ENTER key functionality is not working "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" Error! ENTER key functionality is not working "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}
		
	}

	public void validation() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(validation_msg.isDisplayed()){
				
				common.log(" Validation message is appear properly "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log("  Validation message is not appear properly "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log("  Validation message is not appear properly "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}

		
	}

	public void verify_ua() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(driver.getTitle().equals("User Agreement|LinkedIn")){
				
				common.log("<br> User Agreement link is working properly "+Test_Result.PASSED +"</h3>");
				common.pause(2);
			}else{
				
				common.log("<br>  User Agreement link is not working properly "+Test_Result.FAILED +"</h3>");
				common.pause(2);
			}
			
		}catch(Exception e){
			
			common.log(" <br>  User Agreement link is not working properly "+Test_Result.FAILED +"</h3>");
			common.pause(2);
			
		}

		
	}

	public void verify_pp() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		try{
			
			if(driver.getTitle().equals("Privacy Policy | LinkedIn")){
				
				//common.log(" <br>Privacy Policy link is working properly "+Test_Result.PASSED +"</h3>");
				SeleniumInit.logStatus(ILoggerStatus.PASSED);
				common.pause(2);
			}else{
				
				//common.log("<br> Privacy Policy link is not working properly "+Test_Result.FAILED +"</h3>");
				SeleniumInit.logStatus(ILoggerStatus.FAILED);
				common.pause(2);
			}
			
		}catch(Exception e){
			
			//common.log(" <br>  Policy Policy link is not working properly "+Test_Result.FAILED +"</h3>");
			SeleniumInit.logStatus(ILoggerStatus.FAILED);
			common.pause(2);
			
		}
		
	}

	public void verify_cp() {
		// TODO Auto-generated method stub
		
		common.pause(2);
		
		//String policy = driver.getTitle();
		
		System.out.println(driver.getTitle());
		//System.out.println("HEEEELLLLLOOOOOOOOOOOOOOOOOOOOOOOOOOoo");
		
		
		try{
			
			if(driver.getTitle().equals("Cookie Policy  LinkedIn")){
				
				//common.log("<br> Cookie Policy link is working properly "+Test_Result.PASSED +"</h3>");
				SeleniumInit.logStatus(ILoggerStatus.PASSED);
				common.pause(2);
			}else{
				
				//common.log("<br> Cookie Policy link is not working properly "+Test_Result.FAILED +"</h3>");
				SeleniumInit.logStatus(ILoggerStatus.FAILED);
				common.pause(2);
			}
			
		}catch(Exception e){
			
			//common.log("<br>   Cookie Policy link is not working properly "+Test_Result.FAILED +"</h3>");
			SeleniumInit.logStatus(ILoggerStatus.FAILED);
			common.pause(2);
			
		}
		
	}

	

}
