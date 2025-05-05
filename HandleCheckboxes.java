package Day1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

    public static void main(String[] args) throws InterruptedException {
        
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the test automation practice site
        driver.get("https://testautomationpractice.blogspot.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Locate all checkboxes with specific class and type
        List<WebElement> checkboxes = driver.findElements(
            By.xpath("//input[@class='form-check-input' and @type='checkbox']")
        );

        // ✅ Option 1: Select all checkboxes
        // for (WebElement checkbox : checkboxes) {
        //     checkbox.click();
        // }

        // ✅ Option 2: Select the last 3 checkboxes
        int selectedCount = 0;
        for (int i = checkboxes.size() - 1; i >= 0; i--) {
            checkboxes.get(i).click();
            selectedCount++;
            if (selectedCount == 3) {
                break;
            }
        }

        // ✅ Option 3: Select the first 3 checkboxes
        for (int i = 0; i < 3 && i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }

        // Wait 5 seconds to observe the selected checkboxes
        Thread.sleep(5000);

        // ✅ Unselect all checkboxes that are currently selected
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Optionally, close the browser
        driver.quit();
    }
}
