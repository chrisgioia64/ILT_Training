package lecture04;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class PageLoadTimeoutTest {
	

	public static void main(String[] args) {

		//Setting system properties of EdgeDriver
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);

		//Creating an object of EdgeDriver
		driver.manage().window().maximize();

		//Deleting all the cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		
		long start = System.currentTimeMillis();
		try {
			driver.get("https://www.cnn.com/");
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
		long elapsed = System.currentTimeMillis() - start;
		
		
		System.out.println(elapsed);
		driver.quit();
		
	}


}
