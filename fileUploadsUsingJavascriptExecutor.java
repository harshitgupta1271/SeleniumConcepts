package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUploadsUsingJavascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		

		// Launches a new Chrome browser instance
		WebDriver driver = new ChromeDriver();

		// Navigates to the multiple file upload demo page
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");

		// Maximizes the browser window to ensure all elements are fully visible
		driver.manage().window().maximize();

		// Uploads a single file by sending its absolute path to the file input element
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("/home/harshit/Downloads/dummy (1).pdf");

		// Waits for 2 seconds to allow the file list to update (useful before verifying upload)
		Thread.sleep(2000);  // You must handle or declare InterruptedException for this

		// Locates the uploaded file name element from the list shown on the web page
		WebElement uploadedFile = driver.findElement(By.xpath("//ul[@id='fileList']/li"));

		// Compares the visible text of the uploaded file with the expected file name
		if (uploadedFile.getText().equals("dummy (1).pdf")) {
		    // Prints success message if file name matches
		    System.out.println("File uploaded successfully");
		} else {
		    // Prints failure message if file name does not match
		    System.out.println("File uploading failed");
		}

		// Defines absolute paths of two files to be uploaded simultaneously
		String file1 = "/home/harshit/Downloads/dummy.pdf";
		String file2 = "/home/harshit/Downloads/dummy (1).pdf";

		// Sends both file paths to the file input element, separated by newline character '\n'
		// This uploads both files together if the input element supports 'multiple' uploads
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);	
		
		
	}
	

}
