package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepickersAndCalender {
	
	public static void selectPastDate(WebDriver driver,String month, String year,String day) {
		

		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
	
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		

		int row = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();

		int col = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td")).size();
		
		List<WebElement> listOfDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		for(WebElement Ele : listOfDays) {
			if(Ele.getText().equals(day)) {
				Ele.click();
				break;
			}
		}
		
	}
	
	public static void selectFutureDate(WebDriver driver,String month, String year,String day) {
		
        // looping till the month and year both gets matched
		while(true) {
			// get current month and year
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			// keep matching with our intended date if matched stop it
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			// keep clicking on next next button untill while condition get failed
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
          // get the number of rows from the table
		int row = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr")).size();
         
		 // get the number of rcols from the table
		int col = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td")).size();
		
		
		// fill all the days in list 
		List<WebElement> listOfDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		
		
		// looping on list to match a particular day
		for(WebElement Ele : listOfDays) {
			if(Ele.getText().equals(day)) {
				Ele.click();
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		// click on date input
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String day = "17";
		String month = "April";
		String year = "2024";
		
	//	selectFutureDate(driver,month,year,day);
		selectPastDate(driver,month,year,day);

		
		
		
	}

}
