package com.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionsExample {

	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		String actualTitle = driver.getTitle();
		
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(actualTitle, "Your Store123");
		
		String actualUrl= driver.getCurrentUrl();
		
		softAssert.assertEquals(actualUrl, "https://tutorialsninja.com/demo/");
		
		driver.findElement(By.name("search")).sendKeys("HP",Keys.ENTER);
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		
		driver.quit();
		
		softAssert.assertAll();
	}
	
	
}
