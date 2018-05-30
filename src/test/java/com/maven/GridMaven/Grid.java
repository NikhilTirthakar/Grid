package com.maven.GridMaven;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Grid 
{
   WebDriver driver;
   @Test
   public void f()
   {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();

   }
   @BeforeTest
   public void beforetest() throws MalformedURLException
   {
	   DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
		  desiredCapabilities.setBrowserName("chrome");
		desiredCapabilities.setPlatform(Platform.WIN8_1);
		  
		  driver = new RemoteWebDriver(new URL("http://192.168.1.102:4444/wd/hub"),desiredCapabilities);
		  
		  driver.manage().window().maximize();
		  driver.get("http://opensource.demo.orangehrmlive.com/");
		  
   }
   @AfterTest
   public void aftertest()
   {
	   driver.quit();
   }
}
