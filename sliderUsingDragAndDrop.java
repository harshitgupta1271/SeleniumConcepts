package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sliderUsingDragAndDrop {

	public static void main(String[] args) {
		
		
		
		  // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        // Create Actions instance
        Actions act = new Actions(driver);

        // Locate the min and max slider handles
        WebElement minSlider = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][1]"));
        WebElement maxSlider = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')][2]"));

        // Print default locations
        System.out.println("Default location of min slider: " + minSlider.getLocation());
        System.out.println("Default location of max slider: " + maxSlider.getLocation());

        // Move min slider 100 pixels to the right
        act.dragAndDropBy(minSlider, 100, 0).perform();

        // Move max slider 50 pixels to the left (negative x-direction)
        act.dragAndDropBy(maxSlider, -50, 0).perform();

        // Print new locations
        System.out.println("New location of min slider: " + minSlider.getLocation());
        System.out.println("New location of max slider: " + maxSlider.getLocation());

        // Optional: close browser
        // driver.quit();

		
		
		
	}

}
