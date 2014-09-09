package com.linkedin.pages.indexpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import com.linkedin.init.Common;
import com.linkedin.init.MyCommon;
import com.linkedin.init.Test_Result;
import com.linkedin.pages.AbstractPage;
import com.linkedin.pages.CreateNewAccount_Verification;

public class CreateNewAccount_IndexPage extends AbstractPage{
	
	Common common = new Common(driver);
	MyCommon mycommon = new MyCommon();

	public CreateNewAccount_IndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@DataProvider(name = "invalidnames" ,parallel=true)
	public static Object[][] invalidnames(){
		
		return new Object[][] {
				{"",7} , {" Rahul", 8} , {"R@hu!_",9} , {"Rah Ul" , 10}  
		};
	}
	
	@DataProvider(name = "invalidlnames" ,parallel=true)
	public static Object[][] invalidlnames(){
		
		return new Object[][] {
				{"",11} , {" Rahul", 12} , {"R@hu!_",13} , {"Rah Ul" , 14}  
		};
	}
	
	@DataProvider(name = "invalidmailid" ,parallel=true)
	public static Object[][] invalidmailid(){
		
		return new Object[][] {
				
				{" rahul.pandya@mailinator.com" , 15} , 
				{"rahul.pndya@" , 16} , 
				{"rahul pandya@mailinator.com" , 17} , 
				{"rahul.pandyamailinator.com" , 18} , 
				{"@mailinator.com" , 19} , 
				{"rahul.pandya00@@mailinator.com" , 20} , 
				{"rahul..pandya@mailinator.com" , 21} , 
				{"rahul.pandya@-mailinator.com" , 22} , 
				{"#$%^%^&%#^&*@mailinator.com" , 23} , 
				{"Rahul Pandya <rahul.pandya@mailinator.com>" , 24} ,
				{"rahul.pandya00@mailinator." , 25} , 
				{"rahul.pandya@web.net" , 26} ,
				{"rahul.pandya@111.com" , 27} , 
				{"rahul.pandya@mailinator.com (Rahul Pandya)" , 28} ,
				{"rahul.pandya@mailinatorhotmail.com" , 29} ,
				{"rahul.pandya@xyz.com" , 30} , 
				{"" , 31} , 
				{"pandya.rahul00@gmail.com" , 32}
				
		
		};
	}
	
	@DataProvider(name = "invalidpassword" ,parallel=true)
	public static Object[][] invalidpassword(){
		
		return new Object[][] {
				{"Jammmiieee",33} , {"123456", 34} , {"emailid",35} , {"" , 36} , {"ra12@" , 37} ,
				{"rahulpa12" , 38}
		};
	}
	
	@FindBy(xpath = ".//*[@id='control_gen_1']/li[1]/label")
	private WebElement login_email_label;
	
	@FindBy(xpath = ".//*[@id='control_gen_1']/li[2]/label")
	private WebElement login_password_label;
	
	@FindBy(xpath = ".//*[@id='search']/form/h3")
	private WebElement search_label;
	
	CreateNewAccount_Verification CreateNewAccount_Verification = new CreateNewAccount_Verification(driver);
	
	
	
	public void openUrl() {
		// TODO Auto-generated method stub
		
		String title = "LinkedIn";
		
		CreateNewAccount_Verification.openURL();
		
        if(driver.getTitle().endsWith(title)){
        	
        	mycommon.log_step(" Step 2 : Verify Registration Page ");
        	common.log("<h3> Register page open successfully "+Test_Result.PASSED +"</h3>");
        }
        
        else{
        	
        	common.log("<h3> Register page open failed "+Test_Result.FAILED +"</h3></h3>");
        	
        }
		
	}
	
	public void label_verification(String onForm){
		
		mycommon.log_step(" Step 2 : Verify All labels of page ");
		
		CreateNewAccount_Verification.LabelverificationMethod(login_email_label, onForm);
		CreateNewAccount_Verification.LabelverificationMethod(login_password_label, onForm);
		CreateNewAccount_Verification.LabelverificationMethod(search_label, onForm);
		
		common.log("Label verification done successfully <br>");
			
	}
	
	@FindBy(xpath = ".//*[@id='firstName-coldRegistrationForm']")
	private WebElement firstname_textfield;
	
	@FindBy(xpath = ".//*[@id='lastName-coldRegistrationForm']")
	private WebElement lastname_textfield;
	
	@FindBy(xpath = ".//*[@id='email-coldRegistrationForm']")
	private WebElement email_textfield;
	
	@FindBy(xpath = ".//*[@id='password-coldRegistrationForm']")
	private WebElement password_textfield;
	
	public void mendatory_field_verify(String onForm){
		
		mycommon.log_step(" Step 2 : Verify All mendatory of registration page ");
		
		CreateNewAccount_Verification.fieldsVerification(firstname_textfield, onForm);
		CreateNewAccount_Verification.fieldsVerification(lastname_textfield, onForm);
		CreateNewAccount_Verification.fieldsVerification(email_textfield, onForm);
		CreateNewAccount_Verification.fieldsVerification(password_textfield, onForm);
		
		common.log("All mendatory fields are verified successfully " + Test_Result.PASSED +" <br>");
		
		
	}
	
	@FindBy(xpath = ".//*[@id='btn-submit']")
	private WebElement joinNow_button;
	
	
	

	public void verify_button(String onForm) {
		
		mycommon.log_step(" Step 2 : Verify \"Join Now\" button registration page ");
		
		if(joinNow_button.isDisplayed()){
			
			common.log(joinNow_button.getText()+" button is Displayed on "+onForm+" " +Test_Result.PASSED +"</h3>");
			
			}
			
			else{
				common.log(joinNow_button.getText()+" textbox isn't Displayed on "+onForm+" "+Test_Result.FAILED +"</h3>");
			}
		
	}

	@FindBy(xpath = ".//*[@id='global-error']/div")
	private WebElement validation_msg;
	
	public void click_button(String onForm) {
		
		mycommon.log_step(" Step 2 : Click on \"Join Now \" button on registration page ");
		
		joinNow_button.click();
		
		if(validation_msg.isDisplayed()){
			
			common.log(joinNow_button.getText()+" Button click successfully "+Test_Result.PASSED +"</h3>");
			
			}
			
			else{
				common.log(joinNow_button.getText()+" Button click failed "+Test_Result.FAILED +"</h3>");
			}
		
	}

	public void edit_textfield(String onForm) {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Enter value in textfields ");
		
		CreateNewAccount_Verification.verifyTextfield(firstname_textfield,onForm);
		CreateNewAccount_Verification.verifyTextfield(lastname_textfield,onForm);
		CreateNewAccount_Verification.verifyTextfield(email_textfield,onForm);
		CreateNewAccount_Verification.verifyTextfield(password_textfield,onForm);
		
		common.pause(2);
		
		common.log("All textfields are editable "+Test_Result.PASSED +"</h3> <br>");
		
		
	}
	

	public void verify_firstname(String onForm,String name) {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Enter First Name ");
		
		String first_name = name;
		
		common.pause(2);
		
		firstname_textfield.sendKeys(first_name);
		
		common.log("Enter First Name: <strong><em>" +first_name+"");
		
		common.pause(2);
		
		mycommon.log_step(" Step 3 : Enter Last Name ");
		
		String last_name = Common.generateRandomChars(5);
		
		lastname_textfield.sendKeys(last_name);
		
		common.log("Enter Last Name:<strong><em> " +last_name);
		
		common.pause(2);
		
		mycommon.log_step(" Step 4 : Enter Emailid ");
		
		String email = createRandommail(7);
		
		email_textfield.sendKeys(email);
		
		common.log("Enter emailid: <strong><em>" +email);
		
		common.pause(2);
		
		mycommon.log_step(" Step 5 : Enter Password ");
		
		String password = Common.generateRandomChars(9);
		
		password_textfield.sendKeys(password);
		
		common.log("Enter Password: <strong><em>" +password);
		
		common.pause(2);
		
		mycommon.log_step(" Step 6 : Click \"Join Now\" button ");
		
		joinNow_button.click();
		
		common.pause(2);
		
		CreateNewAccount_Verification.firstname_validation();
		
		common.pause(2);
		
		
		
	}
	
	public String createRandommail(int number){
		
		StringBuffer smail = new StringBuffer();
		smail.append(Common.generateRandomChars(number) + "@mailinator.com");
		
		String mail = smail.toString();
		
		common.pause(2);
		
		return mail;
	}

	public void verify_lastname(String onForm, String name) {
		// TODO Auto-generated method stub
		mycommon.log_step(" Step 2 : Enter First Name ");
		
		String last_name = name;
		
		String first_name = Common.generateRandomChars(5);
		
		common.pause(2);
		
		firstname_textfield.sendKeys(first_name);
		
		common.log("Enter First Name: <strong><em>" +first_name+"");
		
		common.pause(2);
		
		mycommon.log_step(" Step 3 : Enter Last Name ");
		
		
		
		lastname_textfield.sendKeys(last_name);
		
		common.log("Enter Last Name: <strong><em>" +last_name);
		
		common.pause(2);
		
		mycommon.log_step(" Step 4 : Enter Emailid ");
		
		String email = createRandommail(7);
		
		email_textfield.sendKeys(email);
		
		common.log("Enter emailid: <strong><em>" +email);
		
		common.pause(2);
		
		mycommon.log_step(" Step 5 : Enter Password ");
		
		String password = Common.generateRandomChars(9);
		
		password_textfield.sendKeys(password);
		
		common.log("Enter Password: <strong><em>" +password);
		
		common.pause(2);
		
		mycommon.log_step(" Step 6 : Click \"Join Now\" button ");
		
		joinNow_button.click();
		
		common.pause(2);
		
		CreateNewAccount_Verification.lastname_validation();
		
		common.pause(2);
		
	}

	public void verify_emailid(String onForm, String name) {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Enter First Name ");
		
		String email = name;
		
		String first_name = Common.generateRandomChars(5);
		
		common.pause(2);
		
		firstname_textfield.sendKeys(first_name);
		
		common.log("Enter First Name: <strong><em>" +first_name+"");
		
		common.pause(2);
		
		mycommon.log_step(" Step 3 : Enter Last Name ");
		
		String last_name = Common.generateRandomChars(5);
		
		lastname_textfield.sendKeys(last_name);
		
		common.log("Enter Last Name: <strong><em>" +last_name);
		
		common.pause(2);
		
		mycommon.log_step(" Step 4 : Enter Emailid ");
		
		//String email = createRandommail(7);
		
		email_textfield.sendKeys(email);
		
		common.log("Enter emailid: <strong><em>" +email);
		
		common.pause(2);
		
		mycommon.log_step(" Step 5 : Enter Password ");
		
		String password = Common.generateRandomChars(9);
		
		password_textfield.sendKeys(password);
		
		common.log("Enter Password: <strong><em>" +password);
		
		common.pause(2);
		
		mycommon.log_step(" Step 6 : Click \"Join Now\" button ");
		
		joinNow_button.click();
		
		common.pause(2);
		
		CreateNewAccount_Verification.emailid_validation();
		
		common.pause(2);
		
	}

	public void verify_password(String onForm, String name) {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Enter First Name ");
		
		//String email = name;
		
		String first_name = Common.generateRandomChars(5);
		
		common.pause(2);
		
		firstname_textfield.sendKeys(first_name);
		
		common.log("Enter First Name: <strong><em>" +first_name+"");
		
		common.pause(2);
		
		mycommon.log_step(" Step 3 : Enter Last Name ");
		
		String last_name = Common.generateRandomChars(5);
		
		lastname_textfield.sendKeys(last_name);
		
		common.log("Enter Last Name: <strong><em>" +last_name);
		
		common.pause(2);
		
		mycommon.log_step(" Step 4 : Enter Emailid ");
		
		String email = createRandommail(7);
		
		email_textfield.sendKeys(email);
		
		common.log("Enter emailid: <strong><em>" +email);
		
		common.pause(2);
		
		mycommon.log_step(" Step 5 : Enter Password ");
		
		//String password = Common.generateRandomChars(9);
		
		String password = name;
		
		password_textfield.sendKeys(password);
		
		common.log("Enter Password: <strong><em>" +password);
		
		common.pause(2);
		
		mycommon.log_step(" Step 6 : Click \"Join Now\" button ");
		
		joinNow_button.click();
		
		common.pause(2);
		
		CreateNewAccount_Verification.password_validation();
		
		common.pause(2);
		
	}

	public void validdata() {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Enter First Name ");
		
		//String email = name;
		
		String first_name = Common.generateRandomChars(5);
		
		common.pause(2);
		
		firstname_textfield.sendKeys(first_name);
		
		common.log("Enter First Name: <strong><em>" +first_name+"");
		
		common.pause(2);
		
		mycommon.log_step(" Step 3 : Enter Last Name ");
		
		String last_name = Common.generateRandomChars(5);
		
		lastname_textfield.sendKeys(last_name);
		
		common.log("Enter Last Name: <strong><em>" +last_name);
		
		common.pause(2);
		
		mycommon.log_step(" Step 4 : Enter Emailid ");
		
		String email = createRandommail(7);
		
		email_textfield.sendKeys(email);
		
		common.log("Enter emailid: <strong><em>" +email);
		
		common.pause(2);
		
		mycommon.log_step(" Step 5 : Enter Password ");
		
		String password = Common.generateRandomChars(9);
		
		
		
		password_textfield.sendKeys(password);
		
		common.log("Enter Password: <strong><em>" +password);
		
		common.pause(2);
		
		mycommon.log_step(" Step 6 : Click \"Join Now\" button ");
		
		joinNow_button.click();
		
		common.pause(2);
		
		CreateNewAccount_Verification.datavalidation_success();
		
		common.pause(2);
		
	}
	
	@FindBy(xpath = ".//*[@id='session_key-login']")
	private WebElement login_email_textfield;
	
	@FindBy(xpath = ".//*[@id='session_password-login']")
	private WebElement login_password_textfield;
	

	public void verifyTabKey() {
		// TODO Auto-generated method stub
		
		mycommon.log_step("Step 2 : Press \"Tab\" key on keyboard " );
		
		common.pause(2);
		
		login_email_textfield.sendKeys("pandya.rahul00@gmail.com");
		common.pause(2);
		login_email_textfield.sendKeys(Keys.TAB);
		
		common.pause(1);
		
		
		
		
		
		
		
	}

	public void verify_onclickfunctionality() {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Enter First Name ");
		
		//String email = name;
		
		String first_name = Common.generateRandomChars(5);
		
		common.pause(2);
		
		firstname_textfield.sendKeys(first_name);
		
		common.log("Enter First Name: <strong><em>" +first_name+"");
		
		common.pause(2);
		
		mycommon.log_step(" Step 3 : Enter Last Name ");
		
		String last_name = Common.generateRandomChars(5);
		
		lastname_textfield.sendKeys(last_name);
		
		common.log("Enter Last Name: <strong><em>" +last_name);
		
		common.pause(2);
		
		mycommon.log_step(" Step 4 : Enter Emailid ");
		
		String email = createRandommail(7);
		
		email_textfield.sendKeys(email);
		
		common.log("Enter emailid: <strong><em>" +email);
		
		common.pause(2);
		
		mycommon.log_step(" Step 5 : Enter Password ");
		
		String password = Common.generateRandomChars(9);
		
		
		
		password_textfield.sendKeys(password);
		
		common.log("Enter Password: <strong><em>" +password);
		
		common.pause(2);
		
		mycommon.log_step(" Step 6 : Click \"Enter\" in your keyboard ");
		
		//joinNow_button.click();
		
		password_textfield.sendKeys(Keys.ENTER);
		
		common.pause(2);
		
		CreateNewAccount_Verification.onclick_verify();;
		
		common.pause(2);
		
		
		
	}

	public void verify_validation() {
		// TODO Auto-generated method stub
		
		mycommon.log_step("Step 2 : Click on \" Join Now \" button");
		
		common.pause(2);
		
		joinNow_button.click();
		
		CreateNewAccount_Verification.validation();
		
	}
	
	@FindBy(xpath = ".//*[@id='guest-home-reg-form']/fieldset/div/p[1]/a[1]")
	private WebElement user_agreement_lnk;
	
	@FindBy(xpath = ".//*[@id='guest-home-reg-form']/fieldset/div/p[1]/a[2]")
	private WebElement privacy_policy_lnk;
	
	@FindBy(xpath = ".//*[@id='guest-home-reg-form']/fieldset/div/p[1]/a[3]")
	private WebElement cookie_policy_lnk;

	public void verify_ua_link() {
		// TODO Auto-generated method stub
		
		mycommon.log_step(" Step 2 : Click on \" User Agreement \" Link");
		
		common.pause(2);
		
		user_agreement_lnk.click();
		
		CreateNewAccount_Verification.verify_ua();
		
		common.pause(2);
		
		
		
	}

	public void verify_pp_link() {
		// TODO Auto-generated method stub
		
		mycommon.log_step("Step 2 : Click on \" Privacy Policy \" Link");
		
		common.pause(2);
		
		privacy_policy_lnk.click();
		
		CreateNewAccount_Verification.verify_pp();
		
		common.pause(2);
		
	}

	public void verify_cp_link() {
		// TODO Auto-generated method stub
		
		mycommon.log_step("Step 2 : Click on \" Cookie Policy \" Link");
		
		common.pause(2);
		
		cookie_policy_lnk.click();
		
		CreateNewAccount_Verification.verify_cp();
		
		common.pause(2);
		
	}

	

	

}
