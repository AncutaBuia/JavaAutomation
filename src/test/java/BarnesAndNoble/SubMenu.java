package BarnesAndNoble;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class SubMenu {

//declar variabila WebDriver
    public WebDriver driver;

//creez o metoda de test, folosesc TestNg annotation:
    @Test
    public void selectSubmenu(){

        //deschid un Browser:
        driver = new ChromeDriver();
        //accesam pagina Web:
        driver.get("https://www.barnesandnoble.com");
        //maximize window
        driver.manage().window().maximize();


        //WebElement menuElement = driver.findElement(By.id("rhfCategoryFlyout_Fiction"));
      //  menuElement.click();


        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and hover over the menu
        WebElement menu = driver.findElement(By.id("rhfCategoryFlyout_Fiction"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();  // Hover to reveal submenu

        // Wait for submenu items to be visible
        List<WebElement> submenuItems = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='refinements']//div[@class='sidebar__section']//ul[@id='sidebar-section-BrowseFiction']"))
        );

        // Click on the first submenu item
        if (!submenuItems.isEmpty()) {
            submenuItems.get(0).click();
            System.out.println("Clicked on the first submenu item.");
        } else {
            System.out.println("No submenu items found.");
        }

        // Close the browser
        driver.quit();
    }
}



