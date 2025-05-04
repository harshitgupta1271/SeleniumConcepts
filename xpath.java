package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Navigate to websites
         driver.get("https://demo.nopcommerce.com/");
         driver.get("https://www.opencart.com/");

        // -------------------------
        // Single attribute XPath
        // -------------------------
        // Locates input box using a single attribute (id)
         driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("t-shirts");

        // -------------------------
        // Double attribute XPath
        // -------------------------
        // Locates input box using two attributes: id and placeholder
        driver.findElement(By.xpath("//input[@id='small-searchterms'][@placeholder='Search store']")).sendKeys("t-shirts");

        // -------------------------
        // XPath with logical operators
        // -------------------------

        // 'and' operator: both conditions must be true
         driver.findElement(By.xpath("//input[@id='small-searchterms' and @placeholder='Search store']")).sendKeys("t-shirts");

        // 'or' operator: at least one condition must be true
         driver.findElement(By.xpath("//input[@id='small-searchterms' or @placeholder='Search store']")).sendKeys("t-shirts");

        // -------------------------
        // XPath with inner text
        // -------------------------
        // Clicks an element with exact visible text
        driver.findElement(By.xpath("//*[text()='Very bad']")).click();

        // -------------------------
        // Check element visibility and extract its text
        // -------------------------
         boolean value = driver.findElement(By.xpath("//h2[text()='Significant Achievements']")).isDisplayed();
         String text = driver.findElement(By.xpath("//h2[text()='Significant Achievements']")).getText();
         System.out.println("Is element displayed? " + value);
        System.out.println("Text of the element: " + text);

        // -------------------------
        // XPath with contains()
        // -------------------------
        // Useful for partial match — in this case, part of the 'placeholder' attribute
         driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter your email address')]")).sendKeys("hgupta1218");

        // -------------------------
        // XPath with starts-with()
        // -------------------------
        // Matches placeholder text that starts with given string
         driver.findElement(By.xpath("//input[starts-with(@placeholder, 'En yo em')]")).sendKeys("hgupta1218");

        // -------------------------
        // Chained XPath
        // -------------------------
       //  Navigates through HTML hierarchy: div > a > img
         boolean value = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
         System.out.println(value);
    }
}
