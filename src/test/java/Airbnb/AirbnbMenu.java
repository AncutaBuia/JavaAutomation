package Airbnb;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AirbnbMenu {


    //Declare variabile: WebDriver
    public WebDriver driver;

    //Create test method, using TestNg annotation:
    @Test
    public void selectMenu() {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Airbnb Ireland
        driver.get("https://www.airbnb.ie");
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Ensure the page is fully loaded
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (!js.executeScript("return document.readyState").equals("complete")) {
                System.out.println("Page is still loading...");
            }

            // Wait for the Cabins menu to be present in the DOM
            WebElement cabinsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Cabins']")));
            System.out.println("Cabins menu is present in DOM.");

            // Scroll to the element if needed
            //js.executeScript("arguments[0].scrollIntoView(true);", cabinsMenu);

            // Wait for it to be clickable and click
            cabinsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cabins']")));
            cabinsMenu.click();
            System.out.println("Clicked on Cabins menu.");

 //Open element from submenu list:
    // Find the list of elements
    List<WebElement> listItems = driver.findElements(By.xpath("//*[@id='site-content']//div[@itemprop='itemListElement']"));

    // Ensure the list contains items before interacting
    if (listItems.size() > 0) {
        WebElement firstItem = listItems.get(0); // Get the first item
        System.out.println("First List Item Text: " + firstItem.getText());

        // Scroll into view
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstItem);
        wait.until(ExpectedConditions.elementToBeClickable(firstItem));

        // Perform click action
        try {
            firstItem.click();
            System.out.println("First item clicked successfully.");
        } catch (Exception e) {
            System.out.println("Failed to click first item. Trying JavaScript click.");
            js.executeScript("arguments[0].click();", firstItem); // Fallback JS click
        }
    } else {
        System.out.println("No list items found.");
    }
        //Close driver
        driver.quit();
    }

}





