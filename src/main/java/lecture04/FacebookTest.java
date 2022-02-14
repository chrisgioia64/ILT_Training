package lecture04;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import lecture04.DriverFactory.Browser;

public class FacebookTest {

	public static void testLoadTime(Browser browser, int iterations, String url) {
		WebDriver driver = DriverFactory.getDriver(browser);
		
		for (int i = 0; i < 5; i++) {
			Instant now = Instant.now();
			driver.manage().deleteAllCookies();
			driver.get(url);
			Duration newlyElapsed = Duration.between(now, Instant.now());
			System.out.println(browser.toString() + " " + newlyElapsed);
		}
//		System.out.println(driver.getWindowHandles());
		
		driver.quit();
	}

	public static void main(String[] args) {
		DriverFactory.initialize();
		String baseUrl = "http://facebook.com";
		testLoadTime(Browser.CHROME, 5, baseUrl);
		testLoadTime(Browser.EDGE, 5, baseUrl);
		testLoadTime(Browser.FIREFOX, 5, baseUrl);
	}

}
