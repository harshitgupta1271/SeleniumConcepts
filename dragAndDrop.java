package day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class dragAndDrop {

	public static void main(String[] args) {
		
		  WebDriver driver = new ChromeDriver();
		  driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		  
		  driver.manage().window().maximize();
		  
		  WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));

		  WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
		  
		  Actions act = new Actions(driver);
		  
		  act.dragAndDrop(rome, italy).perform();
		  

		
		

	}

}
