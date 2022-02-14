package lecture04;

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
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/login.html");
		
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
