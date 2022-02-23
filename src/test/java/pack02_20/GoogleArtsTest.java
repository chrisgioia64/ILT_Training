package pack02_20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleArtsTest extends BaseTest {

	@Test
	public void test() {
		// Step 1
		WebDriver driver = getDriver(BrowserType.CHROME, "https://artsandculture.google.com/");
		driver.findElement(By.linkText("Sign in")).click();
		
		// Step 2
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		
		WebElement passNext = driver.findElement(By.id("passwordNext"));
		wait.until(ExpectedConditions.elementToBeClickable(passNext));
		passNext.click();
		
		// Step 3
		
		// Step 4
	}
	
}
