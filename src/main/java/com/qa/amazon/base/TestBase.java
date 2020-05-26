package com.qa.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fileInput;
	

	
	public TestBase() throws IOException{
		
		File file =new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		fileInput=new FileInputStream(file);
		prop=new Properties();
		prop.load(fileInput);
		
	}

	public void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		}else if(browserName.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
				
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
       	
	}
	


}
	
