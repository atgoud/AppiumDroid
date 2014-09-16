package com.framework;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

/**
 * Define Seller Test Data
 * 
 */

public class TestData {
	@DataProvider(name = "logdata")
	public static Object[][] Logindata() {
		Object obj[][] = { { "login1", "pass" } };

		return obj;
	}

	/*-----------------------------random data generation methods--------------------*/

	public String orgname() {

		String orgName = "KQ" + "ORG"
				+ RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyz");

		return orgName;
	}

	public String test_data() {

		  String orgName = "KQ"  
		    + RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyz");

		  return orgName;
		 }

		 public String test_data_description() {

		  String orgName = "KQ" + "WIDGET" + " DISCRIPTION"
		    + RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyz");

		  return orgName;
		 }
		 
		 
		 public String policyname() {

		  String orgName = "KQ" + "POLICY" + "NAME"
		    + RandomStringUtils.random(4, "abcdefghijklmnopqrstuvwxyz");

		  return orgName;
		 }


		 public String sevarity_name() {

		  String orgName = RandomStringUtils.random(4,"1234567890");

		  return orgName;
		 }

}

