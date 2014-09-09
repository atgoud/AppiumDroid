package com.linkedin.cases;

import org.testng.annotations.Test;

import com.linkedin.init.Common;
import com.linkedin.init.MyCommon;
import com.linkedin.pages.indexpages.CreateNewAccount_IndexPage;

public class CreateNewAccount extends com.linkedin.init.SeleniumInit  {
	
	
	Common common = new com.linkedin.init.Common(driver);
	com.linkedin.init.MyCommon mycommon = new MyCommon();

	@Test
	public void verify_register_page(){
		
		mycommon.log_case("TESTCASE_001 : To verify that user see Register Page.");
		
		mycommon.log_step("Step 1 : Open URL (http://www.linkedin.com)");
		
		CreateNewAccount_IndexPage.openUrl();
		
		
		mycommon.log_testover();
		
	}
	
	@Test
	public void verify_labels_onpage(){
		
		mycommon.log_case("TESTCASE_002 : To verify that all labels are visible properly.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.label_verification(currentTest);
		
		mycommon.log_testover();
	}
			
	@Test
	public void verify_mendatory_fields(){
		
		mycommon.log_case("TESTCASE_003 : To verify all mandatory fields in page.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.mendatory_field_verify(currentTest);
		
		mycommon.log_testover();
	}
	
	@Test
	public void verify_joinnow_button(){
		
		mycommon.log_case("TESTCASE_004 : To verify that \"Join Now\" button is work properly");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_button(currentTest);
		
		mycommon.log_testover();
		
		
	}
	
	@Test
	public void click_joinnow_button(){
		
		mycommon.log_case("TESTCASE_005 :To verify that \"Join Now\" button is clickable");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.click_button(currentTest);
		
		mycommon.log_testover();
		
		
	}
	
	@Test
	public void textbox_edit(){
		
		mycommon.log_case("TESTCASE_006 : To verify that all text fields are editable.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.edit_textfield(currentTest);
		
		mycommon.log_testover();
			
	
		
	}
		
	
	@Test(dataProvider= "invalidnames" ,  dataProviderClass = CreateNewAccount_IndexPage.class)
	public void invalidFirstname(String name,int cases){
		
		mycommon.log_case("TESTCASE_" +cases+ " : To verify that First Name field should have only characters.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_firstname(currentTest,name);
		
		mycommon.log_testover();
		
	}
	
	
	
//	@Test
//	public void invalidFirstname_specchar(){
//		
//		mycommon.log("  TESTCASE_008 : To verify that First Name field is not have Special characters or Numbers.  ");
//		
//		mycommon.log(" Step 1 : Open URL (http://www.linkedin.com) ");
//		
//		CreateNewAccount_Verification.openURL();
//		
//		CreateNewAccount_IndexPage.verify_firstname(currentTest);
//	}
	
	@Test(dataProvider= "invalidlnames" ,dataProviderClass = CreateNewAccount_IndexPage.class)
	public void invalidLastName(String name,int cases){
		
		mycommon.log_case("TESTCASE_" +cases+ " : To verify that Last Name field should have only characters.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_lastname(currentTest,name);
		
		mycommon.log_testover();
		
	}
	
	
	
	
	@Test(dataProvider= "invalidmailid" , dataProviderClass = CreateNewAccount_IndexPage.class)
	public void invalid_emailid(String name,int cases){
		
		
		mycommon.log_case("TESTCASE_" +cases + " : To verify that user is enter valid emailid.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_emailid(currentTest,name);
		
		mycommon.log_testover();
		
	}
	
	@Test(dataProvider= "invalidpassword" , dataProviderClass = CreateNewAccount_IndexPage.class)
	public void invalid_password(String name,int cases){
		
		
		mycommon.log_case("TESTCASE_" + cases + " : To verify that user is enter valid Password.");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_password(currentTest,name);
		
		mycommon.log_testover();
		
	}
	
	@Test
	public void register_success(){
		
		mycommon.log_case("TESTCASE_39 : To verify that user is see register successful page after enter valid data");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.validdata();
		
		mycommon.log_testover();
		
		
	}
	
	@Test
	public void tab_functionality(){
		
		mycommon.log_case("TESTCASE_40 : To verify that user is see register successful page after enter valid data");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verifyTabKey();
		
		
		
	}
	
	@Test
	public void onclick_functionality(){
		
		mycommon.log_case("TESTCASE_41 : To verify that user is see register successful page after enter valid data");
		
		mycommon.log_step("Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_onclickfunctionality();
		
		mycommon.log_testover();
		
	}
	
	@Test
	public void verify_validation_msg(){
		
		mycommon.log_case("TESTCASE_42 : To verify that validation message appear properly");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_validation();
		
		mycommon.log_testover();
		
	}
	
	@Test
	public void useragreement_link(){
		
		mycommon.log_case("TESTCASE_43 : To verify that User Agreement link is working properly");
		
		mycommon.log_step(" Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_ua_link();
		
		mycommon.log_testover();
		
		
	}
	
	@Test
	public void privacypolicy_link(){
		
		mycommon.log_case("TESTCASE_44 : To verify that Privacy Policy link is working properly");
		
		mycommon.log_step("Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_pp_link();
		
		mycommon.log_testover();
		
		
	}
	
	@Test
	public void cookiepolicy_link(){
		
		mycommon.log_case("TESTCASE_45 : To verify that Cookie Policy link is working properly");
		
		mycommon.log_step("Step 1 : Open URL (http://www.linkedin.com) ");
		
		CreateNewAccount_Verification.openURL();
		
		CreateNewAccount_IndexPage.verify_cp_link();
		
		mycommon.log_testover();
		
		
	}
	
	

}
