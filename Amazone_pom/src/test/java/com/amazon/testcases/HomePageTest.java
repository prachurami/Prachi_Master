package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.Pages.HomePage;
import com.amazon.base.TestBase;

public class HomePageTest extends TestBase {
	HomePage hp;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		hp=new HomePage();			
	}
	
	@Test(priority=1)
	public void LoginPageTitle() throws InterruptedException {
		
		String ActualTitle=hp.verifyHomePageTitle();
		String ExpectedTitle="Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
			Assert.assertEquals(ActualTitle, ExpectedTitle);	
		Thread.sleep(4000);
	}
	@Test(priority=2)
	public void SignIn() throws InterruptedException {
		hp.sign_in(prop.getProperty("username"),prop.getProperty("password"));
		String ACT=hp.NameAfterLogin();
		String EXP="Hello, prachi";
		Assert.assertEquals(ACT, EXP);	
		//Thread.sleep(3000);
		}
	
	@Test(priority=3)
	public void ValidateNumberOfLinksInHeader() throws InterruptedException {
		Thread.sleep(3000);
		Integer ACT=hp.NumberHeaderLinks();
		String number=prop.getProperty("headerlinks");
		//System.out.println(number+2);
	    // int EXP=Integer.parseInt(number);
	     Integer num1 = Integer.valueOf(number);
	     System.out.println(num1+2);
	//	System.out.println(EXP.getClass());
	
		Assert.assertEquals(ACT, num1);
		
		
	}
	@Test(priority=4)
	public void Awsaction() throws InterruptedException {
		//Thread.sleep(9000);
		hp.clicking_On_AWS();
		Thread.sleep(6000);
		
	System.out.println(driver.getTitle());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
	
