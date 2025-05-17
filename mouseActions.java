package day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseActions {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // -----------------------------------------
        // 1. Mouse Hover Action (Flipkart Example)
        // -----------------------------------------
        driver.get("https://www.flipkart.com/account/login?ret=/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement login = driver.findElement(By.xpath("//a[@class='wsejfv']"));
        WebElement profile = driver.findElement(By.xpath("//div[normalize-space()='My Profile']"));

        Actions act = new Actions(driver);
        act.moveToElement(login).moveToElement(profile).click().build().perform();

        // -----------------------------------------
        // 2. Right Click (Context Click) Example
        // -----------------------------------------
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement rightClickBtn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        act.contextClick(rightClickBtn).perform();

        WebElement copyOption = driver.findElement(By.xpath("//span[normalize-space()='Copy']"));
        copyOption.click();

        // Handle the alert
        driver.switchTo().alert().accept();

        // -----------------------------------------
        // 3. Double Click Example (W3Schools)
        // -----------------------------------------
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        driver.manage().window().maximize();

        // Switch to iframe where the button exists
        driver.switchTo().frame("iframeResult");

        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
        WebElement copyBtn = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

        field1.clear();
        field1.sendKeys("Welcome");

        act.doubleClick(copyBtn).perform();

        // Optional: Verify if text is copied
        String copiedValue = field2.getAttribute("value");
        System.out.println("Copied Value: " + copiedValue);

        // Close the browser
        driver.quit();
    }
}
