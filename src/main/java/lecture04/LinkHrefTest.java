package lecture04;

import java.time.Clock;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class LinkHrefTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\chromedriver_win32\\chromedriver.exe");
		DriverFactory.initialize();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/ajax.html");
		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("Number of elements: " +elements.size());
		
		elements.forEach((x) -> System.out.println("Attr: " + x.getAttribute("value")));
//		for (int i=0; i<elements.size();i++){
//			System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
//		}
		
		WebElement yesElement = driver.findElement(By.id("yes"));
		WebElement noElement = driver.findElement(By.id("no"));

		yesElement.click();
		WebElement checkButton = driver.findElement(By.id("buttoncheck"));
		checkButton.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		noElement.click();
		checkButton.click();

		//		driver.close();

	}

}
