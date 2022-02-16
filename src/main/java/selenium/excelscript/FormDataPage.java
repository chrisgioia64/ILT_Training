package selenium.excelscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public FormDataPage(WebDriver driver) {
		this.driver = driver;
		
		firstNameField = driver.findElement(By.cssSelector("#firstName"));
		lastNameField = driver.findElement(By.cssSelector("#lastName"));
		emailField = driver.findElement(By.cssSelector("#userEmail"));
		maleRadioButton = driver.findElement(By.cssSelector("input[name='gender'][value='Male']"));
		femaleRadioButton = driver.findElement(By.cssSelector("input[name='gender'][value='Female']"));
		mobileField = driver.findElement(By.cssSelector("#userNumber"));
		dobField = driver.findElement(By.cssSelector("#dateOfBirthInput"));
		
		subjectsField = driver.findElement(By.cssSelector("#subjectsInput"));
		sportsHobbyCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-1"));
		readingHobbyCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-2"));
		musicHobbyCheckbox = driver.findElement(By.cssSelector("#hobbies-checkbox-3"));
		addressField = driver.findElement(By.cssSelector("#currentAddress"));
		
		stateDropdown = driver.findElement(By.cssSelector("#react-select-3-input"));
		cityDropdown = driver.findElement(By.cssSelector("#react-select-4-input"));
	}
	
	public void fillPage(FormDataItem item) {
		firstNameField.sendKeys(item.getFirstName());
		lastNameField.sendKeys(item.getLastName());
		emailField.sendKeys(item.getEmail());
		fillGender(item.getGender());
		mobileField.sendKeys(item.getMobileNumber());
		fillDOB(item);
		fillHobbies(item.getHobbies());
		addressField.sendKeys(item.getAddress());
		
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
		dobField.clear();
		dobField.sendKeys(dobString);
	}
	
	private void fillHobbies(List<String> hobbies) {
		WebElementUtils.checkbox(sportsHobbyCheckbox, 
				hobbies.contains("Sports"));
		WebElementUtils.checkbox(readingHobbyCheckbox, 
				hobbies.contains("Reading"));
		WebElementUtils.checkbox(musicHobbyCheckbox, 
				hobbies.contains("Music"));
	}
	
}
