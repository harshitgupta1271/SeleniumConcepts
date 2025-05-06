package Day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Handling a simple alert with only OK button
        /*
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert simpleAlert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept();
        */

        // Handling a confirmation alert with OK and Cancel buttons
        /*
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);

        driver.switchTo().alert().dismiss();  // Click Cancel
        */

        // Handling a prompt alert with an input box
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);

        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Welcome");
        promptAlert.accept();

        driver.quit();
    }
}
