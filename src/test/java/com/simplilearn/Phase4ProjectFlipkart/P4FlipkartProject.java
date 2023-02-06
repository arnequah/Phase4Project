package com.simplilearn.Phase4ProjectFlipkart;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class P4FlipkartProject {
	
AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException {
		// 1) Launch the Flipkart app
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "1A191FDF600B2S");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.flipkart.android");
		cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	}
	
	@Test
	public void FlipkartProject() throws InterruptedException {
		//Type ‘mobile’ in the search-box
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Search for products']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.EditText[@text='Search for Products, Brands and More']").sendKeys("Mobile");
		driver.findElementByXPath("//android.widget.TextView[@text='mobiles']").click();
		
		
		//Click on the first search result
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Infinix HOT 20 Play (Fantasy Purple, 64 GB)']").click();
		
		
		//Click on ‘Add to cart’ button
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Add to cart']").click();
		
		
		//Click on ‘Go to cart’ button
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Go to cart']").click();
		
		//Verify you see ‘My Cart’ as heading of the activity
		Thread.sleep(1000);
		Boolean myCartisPresent = driver.findElementByXPath("//android.widget.TextView[@text='My Cart']").isDisplayed();
		
		Assert.assertTrue(myCartisPresent);
		
	}


	@AfterTest
	public void CloseApp() {
		
		driver.quit();
	}

}
