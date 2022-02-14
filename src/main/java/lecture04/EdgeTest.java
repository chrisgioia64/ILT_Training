package lecture04;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class EdgeTest{
	public static void main(String[] args) {

		//Setting system properties of EdgeDriver
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");

		//Creating an object of EdgeDriver
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		//Deleting all the cookies
		driver.manage().deleteAllCookies();

		//Specifiying pageLoadTimeout and Implicit wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		//launching the specified URL
		driver.get("https://www.google.com/");

		//Locating the elements using name locator for the text box
		driver.findElement(By.name("q")).sendKeys("BrowserStack Guide");
		
		
		// locator for Google search button
		WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();
		

//		List<WebElement> h2 = driver.findElements(By.tagName("h9"));
//		System.out.println(h2.size());

		List<WebElement> elements = driver.findElements(By.tagName("h3"));
		for (WebElement element : elements) {
			List<WebElement> links = element.findElements(By.tagName("a"));
			if (links.size() > 0) {
				System.out.println(element.getText() + " " + links.get(0).getAttribute("href"));
			} else {
				System.out.println(element.getText());
			}
		}
		
		driver.quit();
		
	}
}