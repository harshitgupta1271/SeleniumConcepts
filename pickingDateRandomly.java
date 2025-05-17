package day1;

import java.util.HashMap;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pickingDateRandomly {

    // This function compares the expected month with the currently visible month and returns a decision:
    // 1 = go to next month, 0 = go to previous month, -1 = already on the correct month
    public static int decision(WebDriver driver, String currentMonth, String expmonth) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create a map for month names to numeric values
        HashMap<String, Integer> monthMap = new HashMap<>();
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);

        // Get numeric values of current and expected months
        int x = monthMap.get(expmonth);
        int y = monthMap.get(currentMonth);

        // Decide direction to navigate
        if (x > y) {
            return 1; // go next
        } else if (x < y) {
            return 0; // go previous
        } else {
            return -1; // already on desired month
        }
    }

    // This function compares the expected year with the currently visible year and returns a decision:
    // 1 = go to next year, 0 = go to previous year, -1 = already on the correct year
    public static int makeDecisionforYearFunction(WebDriver driver, String year) {
        // Get currently visible year
        String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

        int current = Integer.parseInt(currentYear);
        int expected = Integer.parseInt(year);

        if (expected > current) {
            return 1; // go next
        } else if (expected < current) {
            return 0; // go previous
        } else {
            return -1; // already on desired year
        }
    }

    // This function selects a date from the calendar widget based on expected month, year, and day
    public static void selectDatesRandom(WebDriver driver, String expmonth, String year, String day) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to correct year
        int yearDecision = makeDecisionforYearFunction(driver, year);

        while (true) {
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentYear.equals(year)) {
                break; // desired year is visible
            }

            // Navigate year-wise
            if (yearDecision == 1) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next
            } else if (yearDecision == 0) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous
            }
        }

        // Get current month and decide direction to navigate
        String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        int monthDecision = decision(driver, currentMonth, expmonth);

        while (true) {
            currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentMonth.equals(expmonth) && currentYear.equals(year)) {
                break; // desired month and year are visible
            }

            // Navigate month-wise
            if (monthDecision == 1) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // next
            } else if (monthDecision == 0) {
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // previous
            }
        }

        // Select the day from the visible calendar
        List<WebElement> listOfDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement Ele : listOfDays) {
            if (Ele.getText().equals(day)) {
                Ele.click(); // click the desired day
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the jQuery datepicker demo site
        driver.get("https://jqueryui.com/datepicker/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Switch to the iframe containing the datepicker
        driver.switchTo().frame(0);

        // Click the datepicker input to open calendar
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        // Define expected day, month, and year to select
        String day = "10";
        String expmonth = "February";
        String year = "2027";

        // Call method to pick the date
        selectDatesRandom(driver, expmonth, year, day);
    }
}
