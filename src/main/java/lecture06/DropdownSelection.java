package lecture06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import lecture04.DriverFactory;

public class DropdownSelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverFactory.initialize();
		ChromeDriver driver = new ChromeDriver();
		String baseUrl = "https://demoqa.com/select-menu";
		
		driver.get(baseUrl);
		
		WebElement oldStyleDropdown = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(oldStyleDropdown);
		for (WebElement element : select.getOptions()) {
			System.out.println(element.getText());
		}
		
		select.selectByVisibleText("Magenta"); // selects by inner text
//		select.selectByValue("2"); // selects by the "value" attribute
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement newStyleDropdown = driver.findElement(By.id("withOptGroup"));
//		select = new Select(newStyleDropdown);
//		select.selectByIndex(2);
	}

}
