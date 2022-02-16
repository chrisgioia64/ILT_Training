package selenium.excelscript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import lecture04.DriverFactory;

public class ScriptRunner {
	
	public static void main(String[] args) {
		List<FormDataItem> items = ExcelReaderUtils.readData();
		DriverFactory.initialize();
		WebDriver driver = new ChromeDriver();
		driver.get(FormDataPage.URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for (WebElement f : frames) {
			System.out.println(f.getAttribute("id") + ":" + f.getAttribute("class"));
		}
		
		// Close pop-up
//		WebElement divElement = driver.findElement(By.id("google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0"));
//		WebDriver driver2 = driver.switchTo().frame(divElement);
//		WebElement ele = driver2.findElement(By.id("cbb"));
//		ele.click();
		
		FormDataPage fdp = new FormDataPage(driver);
		for (FormDataItem item : items) {
			fdp.fillPage(item);
			break;
		}
		
	}

}
