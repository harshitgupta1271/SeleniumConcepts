package Day1;

import org.openqa.selenium.By;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverMethods {

    public static void main(String[] args) throws InterruptedException {
        
        // Launch Chrome browser
        WebDriver driver  = new ChromeDriver();

        // ---------------------------------------------------------------------
        // Common WebDriver Methods
        // ---------------------------------------------------------------------

        // Navigate to Graplix login page
        driver.get("https://dev.graplix-ai.com/");
        
        // Get the title of the webpage
        System.out.println(driver.getTitle());

        // Get the current URL of the page
        System.out.println(driver.getCurrentUrl());

        // Get the entire HTML source of the current page
        System.out.println(driver.getPageSource());

        // Get the unique ID of the current browser window (session ID)
        System.out.println(driver.getWindowHandle());

        // ---------------------------------------------------------------------
        // Window Handling - Get multiple window handles
        // ---------------------------------------------------------------------

        driver.get("https://www.carwale.com/");
        driver.findElement(By.xpath("//button[@class='media-wallpaper_slot_1-cta-container-1 js-click-tracking-wallpaper_slot_1']")).click();

        // Get all window handles opened by the driver (e.g. multiple tabs)
        Set<String> ids = driver.getWindowHandles();
        System.out.println(ids);

        // ---------------------------------------------------------------------
        // Conditional Commands
        // ---------------------------------------------------------------------

        // isDisplayed(): checks if an element is visible on the UI
       driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
       boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
      System.out.println(status);

        // isEnabled(): checks if an input field/button is enabled for interaction
       driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        boolean status = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
        System.out.println(status);

        // isSelected(): checks if a checkbox/radio button is selected
       driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        boolean status = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
        System.out.println(status);
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        boolean status1 = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
        System.out.println(status1);

        // ---------------------------------------------------------------------
        // Closing Browser Windows
        // ---------------------------------------------------------------------

        // close(): closes only the current browser window
       driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.xpath("//a[normalize-space()='Instagram']")).click();
        Thread.sleep(4000);
        driver.close();

        // quit(): closes all browser windows opened by the driver
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.xpath("//a[normalize-space()='Instagram']")).click();
        Thread.sleep(4000);
        driver.quit();
    }
}
