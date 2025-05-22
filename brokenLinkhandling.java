package day1;

//Importing necessary classes
import java.net.HttpURLConnection; // For handling HTTP connections
import java.net.URL; // To represent the URL object
import java.util.List; // For using List collection

import org.openqa.selenium.By; // For locating elements by tag, id, etc.
import org.openqa.selenium.WebDriver; // Main interface for controlling the browser
import org.openqa.selenium.WebElement; // Represents an HTML element
import org.openqa.selenium.chrome.ChromeDriver; // Implementation of WebDriver for Chrome


public class brokenLinkhandling {

	public static void main(String[] args) {
		
		// Create an instance of ChromeDriver to launch Chrome browser
				WebDriver driver = new ChromeDriver();
				
				// Navigate to the given URL
				driver.get("http://www.deadlinkcity.com/");
				
				// Find all the anchor (<a>) tags on the page and store them in a list
				List<WebElement> anchortags = driver.findElements(By.tagName("a"));
				
				// Initialize a counter to keep track of the number of broken links
				int noOfBrokenLinks = 0;
				
				// Loop through each anchor tag (hyperlink)
				for(WebElement anchor : anchortags) {
					
					// Get the href attribute (actual URL) from the anchor tag
					String link = anchor.getAttribute("href");
					
					// Check if the link is null or empty, and skip it if it is
					if(link == null || link.isEmpty()) {
						System.out.println("href value is null or empty");
						continue; // Skip to the next iteration
					}
					
					try {
						// Create a URL object from the href link
						URL urlLink = new URL(link);
						
						// Open an HTTP connection to the URL
						HttpURLConnection conn = (HttpURLConnection) urlLink.openConnection();
						
						// Actually connect to the URL (sends a request)
						conn.connect();
						
						// Get the HTTP response code
						// If it's >= 400, it usually means a client or server error (broken link)
						if(conn.getResponseCode() >= 400) {
							System.out.println("Link is broken---> " + link);
							noOfBrokenLinks++; // Increment broken link counter
						} else {
							// If response code is less than 400, the link is valid
							System.out.println("Not a broken link-----> " + link);
						}
					}
					catch(Exception e) {
						// Catch any exception (e.g., malformed URL, connection issues)
						// Currently empty, but you may want to log the error in real usage
					}
				}
				
				// Print the total number of broken links found on the page
				System.out.println("Number of broken links: " + noOfBrokenLinks);
		
		

		
		

	}

}
