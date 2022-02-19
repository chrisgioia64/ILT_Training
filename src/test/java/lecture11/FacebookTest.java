package lecture11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookTest {

	private WebDriver driver;
	

	@Test(dependsOnMethods = { "testLogin" })
	public void testHomePage() {
		// first perform login page to make sure we are logged in
		
		// code goes here to check web elements in home page
	}
	
	@Test
	public void testLogin() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("christophergioia64@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("abc123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
}
