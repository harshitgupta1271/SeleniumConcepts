package Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitcommands {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver(); // Launch Chrome browser

        // Open the OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize the browser window
        driver.manage().window().maximize();

        // --------------------------------------------------------------------------------
        // Thread.sleep - Static wait (not recommended, used here for demo purpose)
        // --------------------------------------------------------------------------------
        Thread.sleep(5000);  
       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        // --------------------------------------------------------------------------------
        // Implicit wait - global wait applied to all elements
        // --------------------------------------------------------------------------------
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

        // --------------------------------------------------------------------------------
        // Explicit wait - wait until specific condition is met
        // --------------------------------------------------------------------------------

       WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        // Wait for the username field to be visible and then enter text
        WebElement txtUsername = mywait.until(
          ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))
     );
     txtUsername.sendKeys("Admin");

//        // Wait for the password field to be visible and then enter password
      WebElement pass = mywait.until(
         ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))
      );
     pass.sendKeys("Password");

//        // Wait for the login button to be visible and then click
       WebElement login = mywait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))
     );
        login.click();
    }
}
