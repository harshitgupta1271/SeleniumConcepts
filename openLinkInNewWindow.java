package day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class openLinkInNewWindow {

	public static void main(String[] args) throws InterruptedException {
		// Launch the Chrome browser
		WebDriver driver = new ChromeDriver();

		// Navigate to nopCommerce demo website
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// Create Actions object for keyboard and mouse interactions
		Actions act = new Actions(driver);

		// Locate the "Register" link on the homepage
		WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));

		// Hold CTRL key and click the "Register" link to open it in a new tab
		act.keyDown(Keys.CONTROL).click(registerLink).keyUp(Keys.CONTROL).perform();

		// Pause briefly to allow the new tab to load
		Thread.sleep(2000);

		// Get all open window handles and store them in a list
		List<String> ids = new ArrayList<>(driver.getWindowHandles());

		// Switch to the newly opened tab (index 1)
		driver.switchTo().window(ids.get(1));

		// Print the title of the current page to confirm the tab switch
		System.out.println("Switched to tab: " + driver.getTitle());

		// Switch back to the original tab (index 0)
		driver.switchTo().window(ids.get(0));

		// Print the title again to confirm switch back
		System.out.println("Switched to tab: " + driver.getTitle());

		// Navigate to a GitHub repository file page (in the original tab)
		driver.get("https://github.com/harshitgupta1271/SeleniumLearnings/blob/main/keyboardActions.java");

		// Open a new empty browser tab using Selenium 4's newWindow() method
	//	driver.switchTo().newWindow(WindowType.TAB);
		
		// it will open new browser window
		driver.switchTo().newWindow(WindowType.WINDOW);

		// Navigate to the Text Compare site in the new tab
		driver.get("https://text-compare.com/");
        
        
        
        


      

	}

}
