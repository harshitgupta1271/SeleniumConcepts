package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class printingDataFromTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th")).size();
	
		for(int i = 2;i<=rows;i++) {
			
			
			for(int j = 1;j<=cols;j++) {
				String str1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + i + "]/td[" + j + "]")).getText();
				System.out.print(str1+" ");
				
			}
			System.out.println();
		}
		
		
		
		
       
	}

}
