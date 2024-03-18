package sit707_week2;

import org.apache.commons.io.FileUtils;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/markd/Desktop/Rzeczy/chromedriver/chromedriver-win64/chromedriver.exe");
		
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstname = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstname);
		// Send first name
		firstname.sendKeys("Mark");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastname = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastname);
		lastname.sendKeys("Przybylkiewicz");
		
		WebElement phonenumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phonenumber);
		phonenumber.sendKeys("0424566909");
		
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		email.sendKeys("mprzybyl@deakin.edu.au");
		
		WebElement password = driver.findElement(By.id("password"));
		System.out.println("Found element: " + password);
		password.sendKeys("Password1");
		
		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPassword);
		confirmPassword.sendKeys("Password5");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		 WebElement createAccount = driver.findElement(By.xpath("//button[contains(text(), 'Create account')]"));
		 createAccount.click();
         
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		 TakesScreenshot scrShot = ((TakesScreenshot)driver);
		 File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		 File DestFile = new File("C:/Users/markd/Desktop/Master_In_IT/SIT707 Software Quality and Testing/screenshot.png");
		
		 try {FileUtils.copyFile(SrcFile, DestFile);
		 System.out.println("Screenshot saved at " + DestFile.getAbsolutePath());
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
