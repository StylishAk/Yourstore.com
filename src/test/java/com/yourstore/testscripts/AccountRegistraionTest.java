package com.yourstore.testscripts;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yourstore.base.BaseClass;
import com.yourstore.pageobjectmodel.AccountSuccesspage;
import com.yourstore.pageobjectmodel.HomePage;
import com.yourstore.pageobjectmodel.RegistrationPage;
import com.yourstore.utils.ExcelLib;

public class AccountRegistraionTest extends BaseClass {
	
	RegistrationPage registerPage;
	AccountSuccesspage accountSuccessPage;
	
	public AccountRegistraionTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = browserSetup(prop.getProperty("browserName"));
		HomePage hm = new HomePage(driver);
		registerPage = hm.navigateToRegisterPage();
		
	}
	
	@Test(dataProvider ="registerData")
public void verifyRegisteringAccountByProvidingAllFields(String firstName , String lastName , String email , String telephone , String password ) {
		
		accountSuccessPage = registerPage.registerWithAllFields(firstName,lastName , email, telephone, password);
	//	Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success page is not displayed");
	
	}
	
	@DataProvider(name = "registerData")
	public Object[][] getRegisterSupplyData() {
		
		Object[][] data = ExcelLib.getTestDataFromExcel("Registration Details");
		return data;
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
