package com.amazon.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;


	public class HomePage extends TestBase{
		
		
		
		@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
		WebElement Signin;
		
		@FindBy(xpath="//input[@id='ap_email']")
		WebElement email ;
		
		@FindBy(xpath="//input[@id='ap_password']")
		WebElement password;

		@FindBy(xpath="//input[@id='continue']")
		WebElement continuebtn ;
	  
		@FindBy(xpath="//input[@id='signInSubmit']")
		WebElement fsubmitbtn ;
		
		@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
		WebElement my_name;
		
		@FindBy(xpath="//div[@id='nav-xshop']//a")
		 List<WebElement> HeaderLinks;
		
		
		//AWS Page
		@FindBy(xpath="//a[text()='Amazon Web Services']")
		WebElement AWSLink;
		
		//coupans page
		@FindBy(xpath="//a[contains(text(),'Coupons')]")
		WebElement couponspagelink;
		
		
		//Initilisation of the web elements
		public HomePage() {
			PageFactory.initElements(driver, this);
	}
		
		
		//Action Method
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
			
		public void sign_in(String un, String pwd) {
			Signin.click();
			email.sendKeys(un);
			continuebtn.click();
			password.sendKeys(pwd);
			fsubmitbtn.click();
		}	
		
		public String NameAfterLogin() {
			return my_name.getText();
			
		}
		
		
		public int NumberHeaderLinks() {
			return HeaderLinks.size();
		}
		
		public AwsPage clicking_On_AWS() {
			AWSLink.click();
			return new AwsPage();
		}
		
		
		public CouponsPage Nav_To_couponsPage(){
			couponspagelink.click();
			return new CouponsPage();
		}
	
	}

	

