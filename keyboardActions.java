package day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardActions {

	public static void main(String[] args) {
		

		// Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        // Type text into the first text area
        WebElement input1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        input1.sendKeys("Welcome");

        // Create Actions instance
        Actions act = new Actions(driver);

        // Click to ensure the element has focus
        input1.click();

        // CTRL + A (Select All)
        act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        // CTRL + C (Copy)
        act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        // Press TAB to move to the second text area
        act.sendKeys(Keys.TAB).perform();

        // CTRL + V (Paste)
        act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        // Optional: add a small pause to visually confirm
        // Thread.sleep(1000);

        // Optional: close browser
        // driver.quit();
 

	}

}
