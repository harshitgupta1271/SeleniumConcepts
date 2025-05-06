package Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Wait to allow elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the page
        driver.get("https://ui.vision/demo/webtest/frames/");

        // ---------------- Frame 1 ---------------- reaching to frame 1 
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);  // switch using XPath-located WebElement
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello");
        driver.switchTo().defaultContent();  // go back to main page

        // ---------------- Frame 2 ---------------- reaching to frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);  // switch to Frame 2
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello");
        driver.switchTo().defaultContent();  // go back to main page again if needed
        
     // ---------------- Frame 3 ---------------- reaching to frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("hello");
        
        
     // ---------------- iframe inside frame3 ----------------
        
        driver.switchTo().frame(0); // reaching to iframe 0 from frame 3
        driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
        driver.switchTo().defaultContent();  // go back to main page again if needed
        
         Thread.sleep(2000);
        // Optional: close the browser
         driver.quit();
    }
}
