package lecture04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	public enum Browser {
		EDGE, FIREFOX, CHROME, IE
	}
	
	public static void initialize() {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
	}
	
	public static WebDriver getDriver(Browser browser) {
		if (browser.equals(Browser.EDGE)) {
			return new EdgeDriver();
		} else if (browser.equals(Browser.FIREFOX)) {
			return new FirefoxDriver();
		} else if (browser.equals(Browser.CHROME)) {
			return new ChromeDriver();
		} else if (browser.equals(Browser.IE)) {
			return new InternetExplorerDriver();
		}
		return null;
	}
	
}
