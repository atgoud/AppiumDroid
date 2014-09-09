package com.linkedin.init;

public class MyCommon extends SeleniumInit{

	Common common = new Common(driver);
	
	public void logger(String log){
		
		System.out.println(log);
	}
	
	/** Method to get Random Date */
	
	public int RandomDateGenerator(){
		
			int date = 1 + (common.randomNumericValueGenerate(30));
			
			return date;
		
	}
	
	/** Method to get Random Year from 1910to 2010 */
	
	public int RandomYearGenerator() {
		
		int year = 1910 + ((int)(Math.random()*100));
		
		return year;
	}
	
	/** Method to get Random Month Number */
	
	public int RandomMonthGenerator() {
		
		int month = 1 + ((int)(Math.random()*12));
		
		return month;
	}
	
	public String RandomMonthName(){
		
		int month = 1 + ((int)(Math.random()*12));
		
		String mnth;
	
		
		switch(month){
		
		case 1: mnth = "January"; break;
		
		case 2: mnth = "February"; break;
		
		case 3: mnth = "March"; break;
		
		case 4: mnth = "April"; break;
		
		case 5: mnth = "May"; break;
		
		case 6: mnth = "June"; break;
		
		case 7: mnth = "July"; break;
		
		case 8: mnth = "August"; break;
		
		case 9: mnth = "September"; break;
		
		case 10: mnth = "October"; break;
		
		case 11: mnth = "November"; break;
		
		case 12: mnth = "December"; break;
		
		default: mnth = "January"; break;
		
		
	}
		
		return mnth;
	}
	
	public void log_case(String test_case){
		
		common.log("<h4><strong><em>----- " + test_case + " -----</em></strong></h4>");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(test_case );
		System.out.println("---------------------------------------------------------------------------");
		
	}
	
	public void log_step(String test_step){
		
		common.log("<h3> " + test_step + " </h3><br>");
		System.out.println(test_step);
		
	}
	
	public void log_testover(){
		
		common.log("Case successfully PASSED <hr>");
		System.out.println("Case successfully PASSED");
		
		common.pause(2);
		
	}
}
