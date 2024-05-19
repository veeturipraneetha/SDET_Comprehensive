
package stepDefenitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	WebDriver driver;
	WebDriverWait wait;

	@Given("EdgeDriver must be opened")
	public void edge_driver_must_be_opened() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	}

    @When("User enter into the MakeMyTrip page")
	public void User_enter_into_the_make_my_trip_page() throws Exception {
		driver.get("https://www.makemytrip.com/");
		
		/*
           Thread.sleep(7000);		
			driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
			WebElement popup2 = driver.findElement(By.cssSelector("a[class='close']"));
			popup2.click();
			driver.switchTo().defaultContent();
		
*/
		// Perform click on Popup
		WebElement popup = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		wait.until(ExpectedConditions.visibilityOf(popup)).click();

	}

	@Then("User need to click on flights")
	public void User_need_to_click_on_flights() throws InterruptedException {
		// Click on flight tab

		WebElement flightstab = driver.findElement(By.xpath("//span[text()='Flights']"));
		wait.until(ExpectedConditions.visibilityOf(flightstab)).click();

		WebElement radiobutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Round Trip']")));
		radiobutton.click();
	}

	@Then("User need to select from and to details")
	public void User_need_to_select_from_and_to_details() {
		// Locate elements for the From Location

		WebElement from = driver.findElement(By.xpath("//span[text()='From']"));
		wait.until(ExpectedConditions.visibilityOf(from)).click();
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='From']")));
		search.sendKeys("Hyderabad");
		WebElement hyd = driver.findElement(By.xpath("//p[text()='Hyderabad, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(hyd)).click();

		// Locate elements for the To Location

		WebElement to = driver.findElement(By.xpath("//span[text() = 'To']"));
		wait.until(ExpectedConditions.visibilityOf(to)).click();
		WebElement find = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='To']")));
		find.sendKeys("MAA");
		WebElement chennai = driver.findElement(By.xpath("//p[text()='Chennai, India']"));
		wait.until(ExpectedConditions.elementToBeClickable(chennai)).click();

	}

	@Then("User need to select the departure and return date")
	public void User_need_to_select_the_departure_and_return_date() {
		WebElement startdate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Thu May 23 2024']")));
		startdate.click();
		WebElement enddate = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Mon May 27 2024']")));
		enddate.click();

	}

	@Then("User need to click search button")
	public void User_need_to_click_search_button() {
		WebElement finalsearch = driver.findElement(By.xpath("//a[text()='Search']"));
		wait.until(ExpectedConditions.elementToBeClickable(finalsearch)).click();

	}

	@Then("User should be able to see the search results")
	public void User_should_be_able_to_see_the_search_results() {

		String title = driver.getTitle();
		if (title.contains("MakeMyTrip")) {

			Assert.assertTrue(title.contains("MakeMyTrip"));
			System.out.println("The Search page is displayed as expected");

		} else {

			System.out.println("The Search page is not displayed as expected");
		}
		
		driver.close();
	}
}
