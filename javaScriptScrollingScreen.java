package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class javaScriptScrollingScreen {

	public static void main(String[] args) throws InterruptedException {
		
       
		// Launch a new Chrome browser
		WebDriver driver = new ChromeDriver();

		// Navigate to the nopCommerce demo website
		driver.get("https://demo.nopcommerce.com/");

		// Maximize the browser window to make all content visible
		driver.manage().window().maximize();

		// Cast the WebDriver to JavascriptExecutor to execute JavaScript code
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down vertically by 1500 pixels from the top of the page
		js.executeScript("window.scrollBy(0,1500)");

		// Print the current vertical scroll position (distance from the top of the page)
		System.out.println(js.executeScript("return window.pageYOffset;"));

		// Locate the "News" section on the page using XPath
		WebElement ele = driver.findElement(By.xpath("//strong[normalize-space()='News']"));

		// Scroll the "News" element into view (browser will scroll until the element is visible)
		js.executeScript("arguments[0].scrollIntoView()", ele);

		// Scroll to the very bottom of the page using document.body.scrollHeight
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// Print the new scroll position (should be near or at the bottom)
		System.out.println(js.executeScript("return window.pageYOffset;"));

		// Wait for 2 seconds so the scroll effect can be visually seen before scrolling up again
		Thread.sleep(2000);

		// Scroll back up to the top by reversing the scroll amount
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
		
		

	}

}
