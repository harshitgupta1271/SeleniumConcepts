package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class locators {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open Selenium official website
        driver.get("https://www.selenium.dev/");

        // Maximize browser window
        driver.manage().window().maximize();

        // Example: Locate search input box using 'name' locator and enter text
        driver.findElement(By.name("q")).sendKeys("selenium");

        // Example: Check if logo with id 'Layer_1' is displayed
        Boolean check = driver.findElement(By.id("Layer_1")).isDisplayed();
        System.out.println(check);

        // Example: Click on 'Documentation' link using full link text
        driver.findElement(By.linkText("Documentation")).click();

        // Example: Click using partial link text (note typo in "Documention")
         driver.findElement(By.partialLinkText("Documention")).click();

        // Example: Find elements by class name 'mb-2' and print the size
        List<WebElement> nav = driver.findElements(By.className("mb-2"));
         System.out.println(nav);
        System.out.println(nav.size());

        // Example: Find all anchor tags (links) and print total count
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        // Example: Find all image tags and print the total count
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());

        // Close the browser
        driver.quit();
    }
}
