package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.Common;
import com.framework.MyCommon;
import com.framework.Test_Result;
import com.verification.VerificationPage;

public class IndexPage extends AbstractPage {

	public IndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="com.android.calculator2:id/digit1")
	private WebElement one_btn;
	
	@FindBy(id="com.android.calculator2:id/digit2")
	private WebElement two_btn;
	
	@FindBy(id="com.android.calculator2:id/digit3")
	private WebElement three_btn;
	
	@FindBy(id="com.android.calculator2:id/digit4")
	private WebElement four_btn;
	
	@FindBy(id="com.android.calculator2:id/digit5")
	private WebElement five_btn;
	
	@FindBy(id="com.android.calculator2:id/digit6")
	private WebElement six_btn;
	
	@FindBy(id="com.android.calculator2:id/digit7")
	private WebElement seven_btn;
	
	@FindBy(id="com.android.calculator2:id/digit8")
	private WebElement eight_btn;
	
	@FindBy(id="com.android.calculator2:id/digit9")
	private WebElement nine_btn;
	
	@FindBy(id="com.android.calculator2:id/digit0")
	private WebElement zero_btn;
	
	@FindBy(id="com.android.calculator2:id/dot")
	private WebElement dot_btn;
	
	@FindBy(id="com.android.calculator2:id/equal")
	private WebElement equal_btn;
	
	@FindBy(id="com.android.calculator2:id/div")
	private WebElement div_btn;
	
	@FindBy(id="com.android.calculator2:id/mul")
	private WebElement mul_btn;
	
	@FindBy(id="com.android.calculator2:id/minus")
	private WebElement sub_btn;
	
	@FindBy(id="com.android.calculator2:id/plus")
	private WebElement add_btn;
	
	@FindBy(className="android.widget.EditText")
	private WebElement editText;
	
	@FindBy(id = "com.android.calculator2:id/clear")
	private WebElement clearText_btn;
	
	@FindBy(id = "com.android.calculator2:id/del")
	private WebElement deleteText_btn;
	
	
		Common common = new Common(driver);
		MyCommon mycommon = new MyCommon();

		VerificationPage verifictionpage=new VerificationPage(driver);
		
		public void openCalc() {
			
		//	System.out.println("Hrererrerereeeeeeeeeeeeee");
			
			
			if(clearText_btn.getText().equals("CLR")){
				clearText_btn.click();
			}else{
				deleteText_btn.click();
			}
			
			
			verifictionpage.verifyElement(one_btn);
			verifictionpage.verifyElement(two_btn);
			verifictionpage.verifyElement(three_btn);
			verifictionpage.verifyElement(four_btn);
			verifictionpage.verifyElement(five_btn);
			verifictionpage.verifyElement(six_btn);
			verifictionpage.verifyElement(seven_btn);
			verifictionpage.verifyElement(eight_btn);
			verifictionpage.verifyElement(nine_btn);
			verifictionpage.verifyElement(zero_btn);
			verifictionpage.verifyElement(div_btn);
			verifictionpage.verifyElement(mul_btn);
			verifictionpage.verifyElement(sub_btn);
			verifictionpage.verifyElement(add_btn);
			verifictionpage.verifyElement(equal_btn);
			verifictionpage.verifyElement(dot_btn);
			verifictionpage.verifyElement(editText);
			
		//	System.out.println("Calc verifieeeeeeeeeddddddddddddddd!!!!!!!!!!!!!!!!!!!!");
			common.pause(2);
		}
		

		public int clickonButton() {
			
			System.out.println("I'm here");
			
			int value = common.randomNumericValueGenerate(10);
			
			getElement(value);
			
			String some_value = "" + value;
			
			mycommon.loging(some_value);
			
			System.out.println("This is me..");
			
			common.pause(2);
			
			//element.click();
			
			return value;
		}
		
		public void getElement(int Value){
			
			WebElement element=null;
			
			System.out.println(Value +"Value");
			
			switch(Value){
			
			case 1:   one_btn.click();   break;
			case 2:   two_btn.click();   break;
			case 3:   three_btn.click();   break;
			case 4:   four_btn.click();   break;
			case 5:   five_btn.click();   break;
			case 6:   six_btn.click();   break;
			case 7:   seven_btn.click();   break;
			case 8:   eight_btn.click();   break;
			case 9:   nine_btn.click();;   break;
			case 0:   zero_btn.click();   break;
			
			}
			
			common.pause(2);
			
		}

		public void clickPlus() {
			
			add_btn.click();
			
		}
		
		public void clickMinus() {
					
			sub_btn.click();
					
		}
		
		public void clickDiv() {
			
			div_btn.click();
			
		}
		
		public void clickMul() {
			
			mul_btn.click();
			
		}
		
		public void clickEqual() {
			
			equal_btn.click();
			
		}

		public void verifyAddOutput(int first, int second) {
			
			int total = first + second;
			
			if(Integer.parseInt(editText.getText()) == total){
				
				mycommon.loging( Test_Result.PASSED);
				
				common.pause(1);
			}else{
				mycommon.loging( Test_Result.FAILED);
			}
			
		}

		

}
