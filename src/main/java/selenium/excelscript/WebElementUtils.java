package selenium.excelscript;

import org.openqa.selenium.WebElement;

public class WebElementUtils {
	
	public static void textboxEnter(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static void checkbox(WebElement element, boolean isChecked) {
		if (element.isSelected()) {
			if (!isChecked) {
				element.click();
			}
		} else {
			if (isChecked) {
				element.click();
			}
		}
	}
	
	

}
