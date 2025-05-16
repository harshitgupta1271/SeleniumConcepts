package day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day2 {
    public static void main(String[] args) throws InterruptedException {

      

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://stage.oodleslab.com/#/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        username.sendKeys("maneesh@oodles.io");

        WebElement userpass = driver.findElement(By.xpath("//input[@id='password']"));
        userpass.clear();
        userpass.sendKeys("Oodles@Stage");

        // Accept cookies
        driver.findElement(By.xpath("//button[@class='cookies-btn']")).click();

        // Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Navigate to People section
        driver.findElement(By.xpath("//img[@alt='People']")).click();
        driver.findElement(By.xpath("//a[@href='#/people/user']")).click();

        // Select 10 rows per page
        WebElement dropdown = driver.findElement(By.id("size"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("10");

        // Loop through 100 pages (or as many as needed)
     //   https://testautomationpractice.blogspot.com/
        for (int i = 1; i <= 100; i++) {
            // Wait for spinner to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.pageload-spinner.ng-star-inserted")));
                

            // Click the page number (skip if already on page 1)
            if (i > 1) {
               
                    driver.findElement(By.xpath("//span[contains(@class, 'p-paginator-pages')]//button[normalize-space(text())='" + i + "']")).click();
                     
            }
           
        }
    }
}
