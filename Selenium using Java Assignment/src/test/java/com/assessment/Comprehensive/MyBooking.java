package com.assessment.Comprehensive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyBooking {

	WebDriver driver;

	@Test
	public void flightBooking() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		Thread.sleep(3000);
		
		// Perform click on Popup

		WebElement popup = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		popup.click();
		Thread.sleep(3000);
		
		//Click on flight tab

		WebElement flightstab = driver.findElement(By.xpath("//span [text()='Flights']"));
		flightstab.click();
		Thread.sleep(3000);

		WebElement text = driver.findElement(By.xpath("//li[text() = 'Round Trip']"));
		text.click();
		Thread.sleep(3000);

		// Locate elements for the From Location

		
		WebElement from = driver.findElement(By.xpath("//span[text ()='From']"));
		from.click();
		Thread.sleep(3000);

		WebElement search = driver.findElement(By.xpath("//input [@placeholder='From']"));
		search.sendKeys ("Hyderabad");
		Thread.sleep(3000);

		WebElement hyd = driver.findElement(By.xpath("//p[text()='Hyderabad, India']"));
		hyd.click();
		Thread.sleep(3000);

		// Locate elements for the To Location

		WebElement to = driver.findElement (By.xpath("//span[text()='To']"));
		to.click();
		Thread.sleep(3000);

		WebElement find = driver.findElement (By.xpath("//input[@placeholder='To']"));
		find.sendKeys ("MAA");
		Thread.sleep(3000);

		WebElement chennai = driver.findElement(By.xpath("//p[text ()='Chennai, India']"));
		chennai.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,100)");
		Thread.sleep(3000); 
		
		WebElement startdate = driver.findElement(By.xpath("//div[@aria-label='Sun Nov 19 2023']"));
		startdate.click();
		Thread.sleep(3000);

		WebElement enddate = driver.findElement(By.xpath("//div[@aria-label='Sun Nov 26 2023']"));
		enddate.click();
		Thread.sleep (3000);

		WebElement finalsearch = driver.findElement (By.xpath("//a[text()='Search']"));
		finalsearch.click();
		
		
		String title = driver.getTitle();
		if (title.contains ("makeMytrip")) {

			Assert.assertTrue(title.contains("makeMytrip"));
			System.out.println("The Search page is displayed as expected");

			} else {

			System.out.println("The Search page is not displayed as expected");
			}
			driver.close();
			
	}
}

	
      
		

				

			