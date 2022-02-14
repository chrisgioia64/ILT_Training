package lecture04;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "http://output.jsbin.com/usidix/1";
		driver.get(baseUrl);

		WebElement goButton = driver.findElement(By.tagName("input"));
//		goButton.click();
		
		goButton = driver.findElement(By.xpath("/body/input"));
		goButton.click();
		
//		for (String windowHandle : driver.getWindowHandles()) {
//			System.out.println(windowHandle);
//		}
		
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("passed");	
			alert.accept();
		} catch (NoAlertPresentException ex) {
			System.out.println("failed");
		}
		
		
		
//	    driver.quit();
	}

}
