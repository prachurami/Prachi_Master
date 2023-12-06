package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.Pages.AwsPage;
import com.amazon.Pages.HomePage;
import com.amazon.base.TestBase;

public class AwsPageTest extends TestBase {

	AwsPage ap;

	HomePage hp;

	public AwsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initilization();
		hp = new HomePage();
		ap = new AwsPage();
		ap = hp.clicking_On_AWS();
		
		// testUtil = new TestUtil();
		// contactsPage = new ContactsPage();
		// loginPage = new LoginPage();
		// homePage = loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void validateText() throws InterruptedException {
		String ACT = ap.Methodtext();
		Thread.sleep(3000);
		String EXP = "What is cloud computing?";
		Assert.assertEquals(ACT, EXP);
	}
	
	@Test(priority=2)
	public void ValidateAwsPageTitle() {
		String ACT=ap.AwsPageTitle();
		String EXP = "What is Cloud Computing";
		Assert.assertEquals(ACT, EXP);
	}
	@Test(priority=3)
	public void ImageValidations() throws InterruptedException  {
	Thread.sleep(3000);
	boolean flag=ap.ImageDisplay();
	Assert.assertTrue(flag);
	}
	
	
}
