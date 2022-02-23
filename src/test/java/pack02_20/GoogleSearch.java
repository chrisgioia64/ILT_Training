package pack02_20;

import lecture04.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) {
        DriverFactory.initialize();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://www.google.com");

        String selector = "a[aria-label='Google apps']";
        WebElement element = chromeDriver.findElement(By.cssSelector(selector));
        element.click();
        
        String googlePlaySelector = "a[href*='play.google.com']";
        element = chromeDriver.findElement(By.cssSelector(googlePlaySelector));
        element.click();

    }

}
