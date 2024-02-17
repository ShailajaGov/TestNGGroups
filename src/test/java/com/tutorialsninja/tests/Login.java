package com.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//@Ignore
public class Login {
	
	WebDriver driver;
	
	@Parameters("url")
	@BeforeMethod
	public void setup(String UrlText)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UrlText);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Parameters({"email","password"})
	@Test(priority =1)
	public void verifyLoginWithValidCredentials(@Optional("https://tutorialsninja.com/demo/") String emailId,String pwd)
	{
		
		driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(emailId);
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}

	//@Ignore
	@Test(priority =2)
	public void verifyLoginWithInvalidValidCredentials()
	{
		
		driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(generateEmailTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value = 'Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		//generateEmailTimeStamp();
		//driver.quit();
	}
	
	@Test(priority = 3)
	public void verifyTitle()
	{
		
		String actualTitle = driver.getTitle();
		String expectedTitle= "Your Store";
		
		
		Assert.assertEquals(actualTitle,expectedTitle);
		
		//driver.quit();
	}
	
	public String generateEmailTimeStamp()
	{
		Date date = new Date();
		return date.toString().replace(' ', '_').replace(':','_')+"@gmail.com";
		
	
	}

}
