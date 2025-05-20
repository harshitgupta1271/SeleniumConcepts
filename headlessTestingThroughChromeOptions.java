package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headlessTestingThroughChromeOptions {

	public static void main(String[] args) {
		
		

        // Set Chrome options to run in headless mode (no GUI)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use "--headless=new" for newer versions of Chrome

        // Launch Chrome with the headless options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the website
        driver.get("https://demo.opencart.com/");

        // Get the actual title of the page
        String act_title = driver.getTitle();


        // Verify the page title matches expected
        if (act_title.equals("Your Store")) {
            System.out.println("Test Passed ✅");
        } else {
            System.out.println("Test Failed ❌");
        }

     
		

	}

}
