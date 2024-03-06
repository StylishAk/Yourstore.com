package com.yourstore.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	public Properties prop;
	
    
    public BaseClass () {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\Configuration\\configuration.properties");
		
		try {
			FileInputStream dataFis = new FileInputStream(propFile);
		    prop.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}	
	}
    
    @Test
    public WebDriver browserSetup(String browserName) {
    	
    	if (browserName.equalsIgnoreCase("Chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver= new ChromeDriver();
    	}
    	else if (browserName.equalsIgnoreCase("Firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();	
		}
        else if(browserName.equalsIgnoreCase("edge")) {
        	WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
        else if(browserName.equalsIgnoreCase("safari")) {
        	WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();	
		}
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    	return driver;
    }

}
