package com.qa.amazon.pageObjects;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.*;
import com.qa.amazon.utils.*;
public class LoginPage extends TestBase {

public Xls_Reader reader;
public String filePath="C:\\Users\\umasankar\\eclipse-workspace\\AmazonLoginTest\\src\\main\\java\\com\\qa\\amazon\\testData\\AmazonTestData.xlsx";
@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
WebElement linkSignIn;

@FindBy(xpath="//*[@id=\"nav-flyout-ya-signin\"]/a/span")
WebElement btnSignIn;

@FindBy(id="createAccountSubmit")
WebElement btnCreateAccount;

@FindBy(id="ap_customer_name")
WebElement txtName;

@FindBy(id="ap_phone_number")
WebElement txtPhoneNumber;

@FindBy(id="ap_email")
WebElement txtEmail;

@FindBy(id="ap_password")
WebElement txtPassword;


@FindBy(id="continue")
WebElement btnContinue;

@FindBy(xpath="//div[contains(text(),'The mobile')]")
WebElement errorMessage;



	
	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);
		
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String CreateLoginPage() throws InterruptedException {
		
		Actions action=new Actions(driver);
		action.moveToElement(linkSignIn).build().perform();
		btnSignIn.click();
		btnCreateAccount.click();
		
		reader=new Xls_Reader(filePath);
		
		String name=reader.getData("Sheet1",1,0);
		txtName.sendKeys(name);
		
		String phone=reader.getData("Sheet1",1,1);
		txtPhoneNumber.sendKeys(phone);
		
		String email=reader.getData("Sheet1",1,2);
		txtEmail.sendKeys(email);
		
		String password=reader.getData("Sheet1",1,3);
		txtPassword.sendKeys(password);	
		btnContinue.click();
		Thread.sleep(1000);
		return errorMessage.getText();
		
	}
	
	

}
