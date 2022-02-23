package pack02_20;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import lecture04.DriverFactory;

public class BaseTest {

	private static List<WebDriver> driverPool = new ArrayList<WebDriver>();
	
	@BeforeSuite
	public void setupSuite() {
		DriverFactory.initialize();
	}
	
	public WebDriver getDriver() {
		return getDriver(BrowserType.CHROME, "http://www.google.com");
	}
	
	public WebDriver getDriver(BrowserType browserType, String url) {
		WebDriver driver = WebDriverFactory.getInstance().getDriver(browserType);
		driver.get(url);
		driverPool.add(driver);
		return driver;
	}
	
	@AfterSuite
	public void tearDownSuit() {
		driverPool.forEach( x -> x.quit());
	}
	
}
