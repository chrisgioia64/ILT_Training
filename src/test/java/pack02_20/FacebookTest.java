package pack02_20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lecture04.DriverFactory;

public class FacebookTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		DriverFactory.initialize();
		driver = new EdgeDriver();
	}
	
	@Test
	public void testLogin() {
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("christophergioia64@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Oakland92!");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
