package newpro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class handlingDropdown {

    public static void main(String[] args) {
        
        // Optional if using WebDriverManager:
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ============================================================================
        // HANDLING SINGLE NORMAL DROPDOWN
        // ============================================================================
        
        // driver.get("https://testautomationpractice.blogspot.com/");
        
        // WebElement countryDropdownElement = driver.findElement(By.xpath("//select[@id='country']"));
        // Select countryDropdown = new Select(countryDropdownElement);

        // Select by different methods:
        // countryDropdown.selectByVisibleText("France");
        // countryDropdown.selectByValue("uk");
        // countryDropdown.selectByIndex(3);
        
        // List<WebElement> list = countryDropdown.getOptions();
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i).getText());
        // }

        // ============================================================================
        // HANDLING BOOTSTRAP AND MULTISELECT DROPDOWN
        // ============================================================================
        
        // driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
        // driver.findElement(By.xpath("//button[contains(@class,'dropdown-toggle')]")).click();
        
        // List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class ,'dropdown-menu')]//label"));
        // for (WebElement ele : list) {
        //     if (ele.getText().equals("Java") || ele.getText().equals("MySQL") || ele.getText().equals("C#")) {
        //         ele.click();
        //     }
        // }

        // ============================================================================
        // HANDLING HIDDEN DROPDOWN IN ORANGEHRM
        // ============================================================================
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Login to OrangeHRM
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Navigate to PIM module
        driver.findElement(By.xpath(" //span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
        
        // Open hidden dropdown
        driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();

        // Select value from dropdown by stoping the js execution from devtool-sources - stop button
        driver.findElement(By.xpath("//span[normalize-space()=\"Chief Financial Officer\"]")).click();
    }
}
