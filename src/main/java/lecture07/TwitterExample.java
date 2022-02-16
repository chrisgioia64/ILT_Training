package lecture07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import lecture04.DriverFactory;

public class TwitterExample {

	/**
	 * Signing up with phone or email
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String url = "https://twitter.com";
		
		driver.get(url);
		// had to use this to wait for page to be fully loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String xPath    = "/html/body/div/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/a/div/span/span";
		WebElement ele = driver.findElement(By.xpath(xPath));
		ele.click();
		
		String namePath = "/html/body/div/div/div/div[2]/main/div/div/div/div[2]/div[2]/div[1]/div/div[2]/label/div/div[2]/div/input";
		// xpath above didn't work so using css selector
		WebElement nameElement = driver.findElement(By.cssSelector("input[name=name]"));
		nameElement.sendKeys("chris");
		String phonePath = "/html/body/div/div/div/div[2]/main/div/div/div/div[2]/div[2]/div[1]/div/div[3]/label/div/div[2]/div/input";
		// xpath above didn't work so using css selector
		WebElement phoneElement = driver.findElement(By.cssSelector("input[name=phone_number]"));
		phoneElement.sendKeys("5104999454");
		
		// couldn't find this selector. error thrown
		WebElement month = driver.findElement(By.id("SELECTOR_7"));
		Select monthSelect = new Select(month);
		monthSelect.selectByValue("3");
		
		WebElement day = driver.findElement(By.id("SELECTOR_8"));
		Select daySelect = new Select(day);
		daySelect.selectByValue("27");
		
		WebElement year = driver.findElement(By.id("SELECTOR_9"));
		Select yearSelect = new Select(year);
		yearSelect.selectByValue("1992");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String nextButtonPath = "/html/body/div/div/div/div[2]/main/div/div/div/div[2]/div[2]/div[2]/div/div/span/span";
		// the element with this full xpath couldn't be found
		WebElement nextButton = driver.findElement(By.xpath(nextButtonPath));
		nextButton.click();
	}

}
