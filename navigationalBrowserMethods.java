package Day1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigationalBrowserMethods {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        WebDriver driver = new ChromeDriver();

        // Example 1: Using get() method
        // driver.get("https://demo.nopcommerce.com/");

        // Example 2: Using navigate().to(String)
        // driver.navigate().to("https://demo.nopcommerce.com/");

        // Example 3: Using navigate().to(URL)
        // URL myUrl = new URL("https://demo.nopcommerce.com/");
        // driver.navigate().to(myUrl);

        // Navigation back and forward example
        /*
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.navigate().to("https://google.com/");

        driver.navigate().back();
        System.out.println("After back: " + driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println("After forward: " + driver.getCurrentUrl());

        driver.navigate().refresh();
        */

        // Open Instagram link and handle multiple windows
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Instagram']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<>(windowHandles);

        String parentWindow = windows.get(0);
        String childWindow = windows.get(1);

     // Switching the driver to the new browser window to get its title using the window handle

        driver.switchTo().window(childWindow);
        System.out.println("Child Window Title: " + driver.getTitle());

        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());

    }
}
