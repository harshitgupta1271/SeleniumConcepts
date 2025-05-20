package day1;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeOptions {

	public static void main(String[] args) {
		 // Step 1: Create a ChromeOptions object to customize Chrome's behavior
        ChromeOptions options = new ChromeOptions();

        //Step 2: Allow Chrome to accept insecure SSL certificates
        // Useful when testing sites with self-signed or expired SSL certificates
        options.setAcceptInsecureCerts(true);

        // Step 3: Hide the automation banner
        // This hides the "Chrome is being controlled by automated test software" message
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Step 4: Enable incognito mode (private browsing)
        // Chrome will start without saving cookies, cache, or history
        options.addArguments("--incognito"); // chrome extension are not enabled  for incognito mode

        // Step 5: Add a browser extension (optional)
        // Useful when testing with tools like SelectorsHub or any Chrome extension
        // Make sure the path points to a valid `.crx` extension file
        File file = new File("/home/harshit/Documents/ee/NewApp/day1/SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        options.addExtensions(file);

        // Step 6: Launch Chrome with the customized options
        WebDriver driver = new ChromeDriver(options);

        //  Step 7: Navigate to a test website with a self-signed SSL certificate
        // This URL is safe and used for testing SSL handling
        driver.get("https://self-signed.badssl.com/");

        // Step 8: Print the title of the current page to verify successful navigation
        System.out.println("Title: " + driver.getTitle());

        // Step 9: Close the browser after execution
       // driver.quit();

	}

}
