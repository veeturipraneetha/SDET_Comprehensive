package SDET_Comprehensiive.SDET_Comprehensiive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {


	public static void main (String args[]) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com");
		Thread.sleep(3000);
		
		// Perform click on Popup
		
		driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
		WebElement popup2 = driver.findElement(By.cssSelector("a[class='close']"));
		popup2.click();
		driver.switchTo().defaultContent();
		
		WebElement popup = driver.findElement(By.cssSelector("span[class='commonModal__close']"));
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

		WebElement hyd = driver.findElement(By.xpath("//li[@id=\"react-autowhatever-1-section-0-item-0\"]"));
		hyd.click();
		Thread.sleep(3000);

		// Locate elements for the To Location

		WebElement to = driver.findElement (By.xpath("//span[text()='To']"));
		to.click();
		Thread.sleep(3000);

		WebElement find = driver.findElement (By.xpath("//input[@placeholder='To']"));
		find.sendKeys ("MAA");
		Thread.sleep(3000);

		WebElement chennai = driver.findElement(By.xpath("//li[@id=\"react-autowhatever-1-section-0-item-0\"]"));
		chennai.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,100)");
		Thread.sleep(3000); 
		
		WebElement arrow = driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
		for(int i =0;i<=4;i++) {
			arrow.click();
		}
		
		WebElement startdate = driver.findElement(By.xpath("//div[@aria-label='Tue Nov 19 2024']"));
		startdate.click();
		Thread.sleep(3000);

		WebElement enddate = driver.findElement(By.xpath("//div[@aria-label='Tue Nov 26 2024']"));
		enddate.click();
		Thread.sleep (3000);

		WebElement finalsearch = driver.findElement (By.xpath("//a[text()='Search']"));
		finalsearch.click();
		
		
		String title = driver.getTitle();
		if (title.contains ("MakeMyTrip")) {

			
			System.out.println("The Search page is displayed as expected");

			} else {

			System.out.println("The Search page is not displayed as expected");
			}
			driver.close();
			
	}
}

	
      
		

				

			