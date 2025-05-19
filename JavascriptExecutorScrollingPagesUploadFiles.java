package day1;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class JavascriptExecutorScrollingPagesUploadFiles {

	public static void main(String[] args) {
		
		
		// Launches a new Chrome browser instance
		WebDriver driver = new ChromeDriver();
		// Alternatively, you can use ChromeDriver directly:
		// ChromeDriver driver = new ChromeDriver();

		// Opens the target URL in the browser
		driver.get("https://testautomationpractice.blogspot.com/");

		// Locates the input box element with id="name" using XPath
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='name']"));
		WebElement rdobttn = driver.findElement(By.xpath("//input[@id='male']"));

		// Typecasting WebDriver instance to JavascriptExecutor so we can execute JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Alternatively, if you're using ChromeDriver directly, you could also write:
		// JavascriptExecutor js = driver;

		// Executes JavaScript to set the value "John" in the input box alternate to selenium click
		js.executeScript("arguments[0].setAttribute('value', 'John')", inputbox);
		// alternate to click
		js.executeScript("arguments[0].click()", rdobttn );
		
		

		
		

	}

}
