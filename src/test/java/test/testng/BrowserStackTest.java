package test.testng;

import org.testng.annotations.Test;

import lecture04.DriverFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class BrowserStackTest {

	WebDriver driver;
	
	public static String f = "Hello";

	@BeforeClass
	public void testSetup()
	{
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		DriverFactory.initialize();
//		driver=new ChromeDriver();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openBrowser()
	{
		driver.get("https://www.browserstack.com/");
		driver.findElement(By.id("signupModalButton")).click();
		System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
	}

	@Test(description="This method validates the sign up functionality")
	public void signUp()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.id("user_full_name")).sendKeys("Christopher Gioia");
		driver.findElement(By.id("user_email_login")).sendKeys("christophergioia64@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("Koch2357");
		driver.findElement(By.xpath("//input[@name='terms_and_conditions']")).click();
		driver.findElement(By.id("user_submit")).click();
	}

	@AfterMethod
	public void postSignUp()
	{
		System.out.println(driver.getCurrentUrl());

	}

	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}

}
