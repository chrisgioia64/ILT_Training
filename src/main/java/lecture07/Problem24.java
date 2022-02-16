package lecture07;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Problem24 {

	public static List<WebDriver> getDrivers() {
		List<WebDriver> drivers = new LinkedList<>();
		drivers.add(new ChromeDriver());
		drivers.add(new FirefoxDriver());
		return drivers;
	}
	
	public static void evaluate(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("christophergioia64@gmail.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("foo");
		
		
		WebElement signInButton = driver.findElement(By.cssSelector("button[name=login]"));
		signInButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		evaluate(driver);
		
		driver = new FirefoxDriver();
		evaluate(driver);
	}

}
