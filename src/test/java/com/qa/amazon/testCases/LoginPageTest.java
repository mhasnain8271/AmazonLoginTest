package com.qa.amazon.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.*;
import com.qa.amazon.pageObjects.*;
public class LoginPageTest extends TestBase {

	public LoginPage loginPage;
	public LoginPageTest() throws IOException {
		super();
		
	}
		
		
		@BeforeMethod
		public void setUp() throws IOException{
			initialization();
			loginPage = new LoginPage();	
		}
		
		
		@Test(priority=1)
		public void PageTitleTest(){
			String title=loginPage.getTitle();
			Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		}
		
		
	
		@Test(priority=2)
		public void validateErrorMessageTest() throws InterruptedException{
			String error=loginPage.CreateLoginPage();
			Assert.assertEquals(error, "The mobile number you entered does not seem to be valid");
		}
		
	
		
		
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		


}
