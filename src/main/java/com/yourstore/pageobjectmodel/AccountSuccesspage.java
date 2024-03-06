package com.yourstore.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesspage {
	
WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountSuccessPageHeading;
	
	public AccountSuccesspage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String retrieveAccountSuccessPageHeading() {
		
		String accountSuccessPageHeadingText = accountSuccessPageHeading.getText();
		return accountSuccessPageHeadingText;
	}


}
