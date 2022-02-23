package pack02_20;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lecture04.DriverFactory;

public class GoogleMathTest extends BaseTest {
	
//	private ChromeDriver driver;
	
//	@BeforeClass
//	public void setup() {
//		DriverFactory.initialize();
//	}
//	
//	@AfterMethod
//	public void tearDown() {
//		WebDriverFactory.getInstance().getDriver(BrowserType.CHROME).quit();
//		System.out.println("teardown " + Thread.currentThread().getId());
//	}
	
	@DataProvider(name = "data", parallel=true)
	public Object[][] getData() {
		Object[][] result = new Object[][] {
			{ "2+3", "5",},
			{ "5-3", "2"}
		};
		return result;
	}
	
	
	@Test(dataProvider = "data")
	public void test(String search, String result) {
		System.out.println("test " + Thread.currentThread().getId());
		
		WebDriver driver = getDriver(BrowserType.EDGE, "http://www.google.com");
		
		WebElement element = driver.findElement(By.cssSelector("input[name='q']"));
		element.sendKeys(search);
		element.sendKeys(Keys.ENTER);
		
		WebElement resultSpan = driver.findElement(By.cssSelector("#cwos"));
		assertEquals(resultSpan.getText(), result);
	}
	
	@Test
	public void test2() {
		WebDriver driver = getDriver();
		WebElement element = driver.findElement(By.cssSelector("input[name='q']"));
		element.sendKeys("oakland athletics");
		element.sendKeys(Keys.ENTER);
	}
	
//	@Test
//	public void testAdd() {
//		driver = new ChromeDriver();
//		driver.get("http://www.google.com");
//		
//		WebElement element = driver.findElement(By.cssSelector("input[name='q']"));
//		element.sendKeys("2 + 3");
//		element.sendKeys(Keys.ENTER);
//		
////		WebElement submit = driver.findElement(By.cssSelector("input[name='btnK']"));
////		submit.click();
//		
//		WebElement resultSpan = driver.findElement(By.cssSelector("#cwos"));
//		assertEquals(resultSpan.getText(), "5");
//	}
//	
//	@Test
//	public void testSub() {
//		driver = new ChromeDriver();
//		driver.get("http://www.google.com");
//		
//		WebElement element = driver.findElement(By.cssSelector("input[name='q']"));
//		element.sendKeys("5 - 3");
//		element.sendKeys(Keys.ENTER);
//		
////		WebElement submit = driver.findElement(By.cssSelector("input[name='btnK']"));
////		submit.click();
//		
//		WebElement resultSpan = driver.findElement(By.cssSelector("#cwos"));
//		assertEquals(resultSpan.getText(), "2");
//	}
	
}
