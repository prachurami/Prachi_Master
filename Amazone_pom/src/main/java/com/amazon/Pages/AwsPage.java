package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class AwsPage extends TestBase {

	
//page Factory - OR:
	
	@FindBy(xpath="(//h1[@id='What_is_cloud_computing.3F'])[1]")
	WebElement text1;

	@FindBy(xpath="(//ul[@role='tablist'])[1]/li[4]/div[1]/img[1]")
	WebElement Agri_Image;
	
	public AwsPage() {
		PageFactory.initElements(driver, this);
}
	
	
	
	//Actions
	public String Methodtext() {
		
		 
		System.out.println(text1.getText());
		return text1.getText();
	}
	
	
	public String AwsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ImageDisplay() {
		return Agri_Image.isDisplayed();
	}
	
	
}
