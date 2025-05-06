package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAuthenticationPopUp {

	public static void main(String[] args) throws InterruptedException {
		

		 WebDriver driver = new ChromeDriver();
		 
		 // handling authentication pop by filling username and password in the url link
		 driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		 
		 Thread.sleep(2000);
		 
		 
		 driver.close();
		 

	}

}
