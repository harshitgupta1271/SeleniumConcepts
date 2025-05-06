package Day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class handlingAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		
		
		// Handling a simple alert with only OK button using explicit wait method
		 WebDriver driver = new ChromeDriver();
		 WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert simpleAlert = mywait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept();
        
	
		
		
		
		

	}

}
