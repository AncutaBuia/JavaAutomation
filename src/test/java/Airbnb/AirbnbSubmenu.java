package Airbnb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AirbnbSubmenu {


    //declar variabila WebDriver
    public WebDriver driver;

    //creez o metoda de test, folosesc TestNg annotation:
    @Test
    public void selectSubmenu(){

        //deschid un Browser:
        driver = new ChromeDriver();
        //accesam pagina Web:
        driver.get("https://www.airbnb.ie");
        //maximize window
        driver.manage().window().maximize();


       //Select menu Cabins:
           // WebElement cabinsMenu = driver.findElement(By.xpath("//span[contains(text(),'Cabins')]"));
            //cabinsMenu.click();


        // Locate all list items inside #site-content
        List<WebElement> listItems = driver.findElements(By.xpath("//*[@id='site-content']//div[@itemprop='itemListElement']"));

        // Ensure the list contains items before interacting
        if (!listItems.isEmpty()) {
            WebElement firstItem = listItems.get(0); // Get the first item
            System.out.println("First List Item Text: " + firstItem.getText());

            //"Element is not clickable at point (x, y)"
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", firstItem);

            // Perform an action (e.g., click if clickable)
            firstItem.click();
        } else {
            System.out.println("No list items found.");
        }
    }
}



