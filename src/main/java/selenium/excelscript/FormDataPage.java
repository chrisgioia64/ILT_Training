package selenium.excelscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FormDataPage {
	
	private WebDriver driver;
	
	public static final String URL = "https://demoqa.com/automation-practice-form";

	private WebElement firstNameField;
	private WebElement lastNameField;
	private WebElement emailField;
	
	private WebElement maleRadioButton;
	private WebElement femaleRadioButton;
	
	private WebElement mobileField;
	private WebElement dobField;
	private WebElement subjectsField;
	
	private WebElement sportsHobbyCheckbox;
	private WebElement readingHobbyCheckbox;
	private WebElement musicHobbyCheckbox;
	private WebElement addressField;
	
	private WebElement stateDropdown;
	private WebElement cityDropdown;
	
	private WebElement submitButton;
	
	public FormDataPage(WebDriver driver) {
		this.driver = driver;
		
		firstNameField = driver.findElement(By.cssSelector("#firstName"));
		lastNameField = driver.findElement(By.cssSelector("#lastName"));
		emailField = driver.findElement(By.cssSelector("#userEmail"));
		
		maleRadioButton = driver.findElement(
				By.cssSelector(
						"#genterWrapper label[for='gender-radio-1']"));
		femaleRadioButton = driver.findElement(
				By.cssSelector(
						"#genterWrapper label[for='gender-radio-2']"));
		mobileField = driver.findElement(By.cssSelector("#userNumber"));
		dobField = driver.findElement(By.cssSelector("#dateOfBirthInput"));
		
		subjectsField = driver.findElement(By.cssSelector("#subjectsInput"));
		
//		sportsHobbyCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
//		readingHobbyCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-2"));
//		musicHobbyCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-3"));
		sportsHobbyCheckbox = driver.findElement(
				By.cssSelector("#hobbiesWrapper label[for='hobbies-checkbox-1']"));
		readingHobbyCheckbox = driver.findElement(
				By.cssSelector("#hobbiesWrapper label[for='hobbies-checkbox-2']"));
		musicHobbyCheckbox = driver.findElement(
				By.cssSelector("#hobbiesWrapper label[for='hobbies-checkbox-3']"));
		
		
		addressField = driver.findElement(By.cssSelector("#currentAddress"));
		
		stateDropdown = driver.findElement(By.cssSelector("#react-select-3-input"));
		cityDropdown = driver.findElement(By.cssSelector("#react-select-4-input"));
		
		submitButton = driver.findElement(By.cssSelector("#submit"));
	}
	
	public void fillPage(FormDataItem item) {
		firstNameField.sendKeys(item.getFirstName());
		lastNameField.sendKeys(item.getLastName());
		emailField.sendKeys(item.getEmail());
		emailField.sendKeys(Keys.TAB);
		fillGender(item.getGender());
		mobileField.sendKeys(item.getMobileNumber());
		fillDOB(item);
		fillSubjects(item.getSubjects());
		fillHobbies(item.getHobbies());
		addressField.sendKeys(item.getAddress());
		fillStateCity(item.getState(), item.getCity());
		
		submitButton.submit();
	}
	
	public void reset() {
		firstNameField.clear();
		lastNameField.clear();
		emailField.clear();
		mobileField.clear();
		addressField.clear();
	}
	
	private void fillGender(String gender) {
		Actions action = new Actions(driver);
		action.moveToElement(maleRadioButton);
		if (gender.equals("Male")) {
			action.moveToElement(maleRadioButton);
			this.maleRadioButton.click();
		} else if (gender.equals("Female")) {
			action.moveToElement(femaleRadioButton);
			this.femaleRadioButton.click();
		} else {
			System.out.println(gender + " is not a valid choice for gender");
		}
	}
	
	private void fillDOB(FormDataItem item) {
		Actions action = new Actions(driver);
		action.moveToElement(dobField);
		String dobString = item.getDay() + " " + item.getMonth() + " " + item.getYear();
		dobField.sendKeys(Keys.CONTROL + "a");
		dobField.sendKeys(dobString);
		dobField.sendKeys(Keys.ENTER);
	}
	
	private void fillSubjects(List<String> subjects) {
		for (String subject : subjects) {
			this.subjectsField.sendKeys(subject);
			this.subjectsField.sendKeys(Keys.ENTER);
		}
	}
	
	private void fillHobbies(List<String> hobbies) {
		//Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;		
        
        //Perform Click on LOGIN button using JavascriptExecutor
//        System.out.println(hobbies);
        if (shouldClick(sportsHobbyCheckbox, hobbies.contains("Sports"))) {
        	js.executeScript("arguments[0].click();", sportsHobbyCheckbox);
        }
        if (shouldClick(readingHobbyCheckbox, hobbies.contains("Reading"))) {
        	js.executeScript("arguments[0].click();", readingHobbyCheckbox);
        }
        if (shouldClick(musicHobbyCheckbox, hobbies.contains("Music"))) {
        	js.executeScript("arguments[0].click();", musicHobbyCheckbox);
        }
	}
	
	private boolean shouldClick(WebElement element, boolean shouldBeChecked) {
		if (element.isSelected()) {
			return !shouldBeChecked;
		} else {
			return shouldBeChecked;
		}
	}
	
	private void fillStateCity(String state, String city) {
		stateDropdown.clear();
		stateDropdown.sendKeys(state);
		stateDropdown.sendKeys(Keys.ENTER);
		cityDropdown.clear();
		cityDropdown.sendKeys(city);
		cityDropdown.sendKeys(Keys.ENTER);
	}
	
}
