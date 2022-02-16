package lecture04;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class GuruTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverFactory.initialize();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/login.html");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for (WebElement f : frames) {
			System.out.println(f.getAttribute("id") + ":" + f.getAttribute("class"));
		}
		
		WebElement divElement = driver.findElement(By.id("ccpa-consent-notice"));
		WebDriver driver2 = driver.switchTo().frame(divElement);
		WebElement ele = driver2.findElement(By.id("saveAndExit"));
		ele.click();
		
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("passwd"));
		
		email.sendKeys("christophergioia64@gmail.com");
		password.sendKeys("gogo");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.getWindowHandles());
		
		
		WebElement submit = driver.findElement(By.id("SubmitLogin"));
		submit.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().back();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		System.out.println("popup clicked");
		
		email = driver.findElement(By.id("email"));
		password = driver.findElement(By.id("passwd"));
		
		email.clear();
		password.clear();
		email.sendKeys("jojo@gmail.com");
		password.sendKeys("abc123");
		submit = driver.findElement(By.id("SubmitLogin"));
		submit.click();
	}

}
