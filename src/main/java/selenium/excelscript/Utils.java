package selenium.excelscript;

import org.openqa.selenium.WebElement;

public class Utils {
	
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
