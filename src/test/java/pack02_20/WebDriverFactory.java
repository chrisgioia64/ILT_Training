package pack02_20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	private static final WebDriverFactory INSTANCE = new WebDriverFactory();
	
	private WebDriverFactory() {
	}
	
	public static WebDriverFactory getInstance() {
		return INSTANCE;
	}
	
	private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>() {
//		
//		@Override
//		protected WebDriver initialValue() {
//			return new ChromeDriver();
//		}
	};

	public WebDriver getDriver(BrowserType type) {
		if (threadLocal.get() == null) {
			switch (type) {
			case CHROME: 
				threadLocal.set(new ChromeDriver());
				break;
			case FIREFOX:
				threadLocal.set(new FirefoxDriver());
				break;
			case EDGE:
				threadLocal.set(new EdgeDriver());
				break;
			default:
				break;
			}
		}
		
		return threadLocal.get();
	}
}
