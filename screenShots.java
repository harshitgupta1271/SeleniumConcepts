package day1;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenShots {

	public static void main(String[] args) throws IOException {
		
		// Launch a new Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the demo nopCommerce website
        driver.get("https://demo.nopcommerce.com/");

        // ---------------- FULL PAGE SCREENSHOT ----------------

        // Cast driver to TakesScreenshot to capture full page
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture full-page screenshot as a file
        File sourcefile = ts.getScreenshotAs(OutputType.FILE);

        // Define the path where the full-page screenshot will be saved
        String fullPagePath = System.getProperty("user.dir") + "/screenshots/fullpage.png";
        File targetfile = new File(fullPagePath);

      

        // Move the screenshot to the target location
        sourcefile.renameTo(targetfile);

        // Confirm the save location in console
        System.out.println("Full page screenshot saved at: " + fullPagePath);

        // ---------------- ELEMENT SCREENSHOT ----------------

        // Locate a specific element (Apparel category image)
        WebElement element = driver.findElement(By.xpath("//img[@title='Show products in category Apparel']"));

        // Capture screenshot of that specific element
        File srcFile = element.getScreenshotAs(OutputType.FILE);

        // Define the path to save element screenshot
        String elementPath = System.getProperty("user.dir") + "/screenshots/element.png";
        File destFile = new File(elementPath);

        
        // Move the element screenshot to the target location
        srcFile.renameTo(destFile);

        // Confirm the save location in console
        System.out.println("Element screenshot saved at: " + elementPath);

        // Close the browser
        driver.quit();
		
		
		
		
		
		
		

	}

}
