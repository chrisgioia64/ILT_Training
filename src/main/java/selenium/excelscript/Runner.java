package selenium.excelscript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lecture04.DriverFactory;

public class Runner {
	
	public static void main(String[] args) {
		List<FormDataItem> items = ExcelUtils.readData();
		DriverFactory.initialize();
		WebDriver driver = new ChromeDriver();
		
		// Close pop-up
//		WebElement divElement = driver.findElement(By.id("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0"));
//		WebDriver driver2 = driver.switchTo().frame(divElement);
//		WebElement ele = driver2.findElement(By.id("cbb"));
//		ele.click();
		
		for (FormDataItem item : items) {
			try {
				driver.get(FormDataPage.URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				FormDataPage fdp = new FormDataPage(driver);
				fdp.fillPage(item);
				Utils.sleep(4000);
				item.setPasses(true);
			} catch (Exception ex) {
				System.out.println("Adding form item failed for " + item.getFirstName() + " " + item.getLastName());
				System.err.println(ex.getMessage());
				item.setPasses(false);
			}
		}
		
		ExcelUtils.writeOutData(items);
		
		driver.quit();
	}
	
	private static void printFrames(WebDriver driver) {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for (WebElement f : frames) {
			System.out.println(f.getAttribute("id") + ":" + f.getAttribute("class"));
		}
	}

}
