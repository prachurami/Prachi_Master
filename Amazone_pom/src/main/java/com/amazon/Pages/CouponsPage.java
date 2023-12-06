package com.amazon.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class CouponsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='coupon-search-bar-container']/label")
	WebElement labeltext;

	@FindBy(xpath="//div[contains(@class,'acsUxWidget')]/div/div/div/div/div/div/img")
	WebElement Image1;
	
	@FindBy(xpath="//div[contains(@class,'acsUxWidget')]/div/div/div/div/div/div/div/img")
	WebElement FailImage;
	
	@FindBy(xpath="//div[@id='nav-subnav']/a")
	List<WebElement> header;
	
	@FindBy(xpath="//*[@id=\"a-autoid-23-announce\"]")
	WebElement ShowMoreCoupons;
	
	//Intilitisation
	public CouponsPage() {
		PageFactory.initElements(driver, this);
		
}
	public String labeltextmethod() {
		return labeltext.getText();
	}
	
	public String couponetitle() {
		return driver.getTitle();
	}
	
	public boolean ImageDisplayMethod() {
		return Image1.isDisplayed();
	}
	
	
	public boolean FailImageDisplayMethod() {
		return FailImage.isDisplayed();
	}
	public int headercount() {
		return header.size();
	}
	public String couponsmore() {
		ShowMoreCoupons.click();
		return ShowMoreCoupons.getText();
	}
}
