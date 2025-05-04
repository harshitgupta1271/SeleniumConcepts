package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssLocator {

    public static void main(String[] args) {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the nopCommerce demo site
        driver.get("https://demo.nopcommerce.com/");

        // Using CSS selectors to locate the search input and send keys
        // Different examples:
        
        // 1. Using tag and id
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("t-shirts");

        // 2. Using class
        driver.findElement(By.cssSelector(".search-box-text")).sendKeys("t-shirts");

        // 3. Using attribute
         driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("t-shirt");

        // 3.1. Using reguler expression to write double quote
        driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("t-shirt");
        
        
        // 4 using tag class attribute property
        driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("t-shirt");
    }
}
