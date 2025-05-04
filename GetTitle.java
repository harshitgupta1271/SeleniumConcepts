package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Launch browser
// Open URL
// Validate title
// Close browser

public class GetTitle {

    public static void main(String[] args) {
        
        // Initialize the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to OpenCart website
        driver.get("https://www.opencart.com/");

        // Get the title of the current page
        String title = driver.getTitle();

        // Validate the title matches the expected value
        if(title.equals("OpenCart - Open Source Shopping Cart Solution")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
        }

        // Close the browser
        driver.quit();
    }
}

