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


    //declar variabila WebDriver
    public WebDriver driver;

    //creez o metoda de test, folosesc TestNg annotation:
    @Test
    public void selectSubmenu(){

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Airbnb Ireland
            driver.get("https://www.airbnb.ie");
            driver.manage().window().maximize();

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Handle Cookie Consent Banner (if present)
            try {
                WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]")));
                acceptCookies.click();
                System.out.println("Accepted cookies.");
            } catch (Exception e) {
                System.out.println("No cookie banner found.");
            }

            // Ensure the page is fully loaded
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (!js.executeScript("return document.readyState").equals("complete")) {
                System.out.println("Page is still loading...");
            }

            // Wait for the Cabins menu to be present in the DOM
            WebElement cabinsMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Cabins']")));
            System.out.println("Cabins menu is present in DOM.");

            // Check if the element is inside an iframe - not needed
            /*int iframeCount = driver.findElements(By.tagName("iframe")).size();
            if (iframeCount > 0) {
                System.out.println("Detected " + iframeCount + " iframe(s). Checking if the element is inside an iframe...");
                for (WebElement iframe : driver.findElements(By.tagName("iframe"))) {
                    driver.switchTo().frame(iframe);
                    try {
                        if (driver.findElements(By.xpath("//span[text()='Cabins']")).size() > 0) {
                            System.out.println("Cabins menu found inside an iframe.");
                            break;
                        }
                    } catch (NoSuchElementException ignored) {
                    }
                    driver.switchTo().defaultContent(); // Switch back to main content
                }
            } */

            // Scroll to the element if needed
            js.executeScript("arguments[0].scrollIntoView(true);", cabinsMenu);

            // Wait for it to be clickable and click
            cabinsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cabins']")));
            cabinsMenu.click();
            System.out.println("Clicked on Cabins menu.");

            // Wait for the submenu to be open
            Boolean activeMenu = wait.until(ExpectedConditions.attributeToBe(cabinsMenu, "aria-expanded", "true"));
            Assert.assertNotNull(activeMenu, "Cabins menu did not open!");
            System.out.println("Cabins menu opened successfully.");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }


    // Find the list of elements
    List<WebElement> listItems = driver.findElements(By.xpath("//*[@id='site-content']//div[@itemprop='itemListElement']"));

// Ensure the list contains items before interacting
if (listItems.size() > 0) {  // Use size() instead of isEmpty()
        WebElement firstItem = listItems.get(0); // Get the first item
        System.out.println("First List Item Text: " + firstItem.getText());

        // Scroll into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstItem);

        // Explicit wait to ensure element is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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


}



