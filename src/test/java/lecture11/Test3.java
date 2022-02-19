package lecture11;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
public class Test3 {

	@Parameters({ "search" })
	@Test
	public void search(String searchTerm) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.google.com/search?q=";
		String url = baseUrl + searchTerm;
		driver.get(url);
		// do some testing to verify elements
		assertEquals(searchTerm, driver.getTitle());
		driver.quit();
	}
	
	
}
