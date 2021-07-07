package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Log;

public class MyCartPage {

    WebDriver driver ;
    WebElement ele;


    public MyCartPage(WebDriver driver){
        this.driver=driver;
    }

    By bySubtotalProducts = By.xpath
            ("//span[@id='sc-subtotal-label-activecart' and contains(text(),'1 producto')]");

    public void validateQuantityCartItems(){
        Log.info("Validate the Quantity of items added to cart");
        ele = driver.findElement(bySubtotalProducts);
        ele.isDisplayed();

    }



}
