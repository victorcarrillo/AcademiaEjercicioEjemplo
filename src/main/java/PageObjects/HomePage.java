package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Log;

public class HomePage extends BasePage {


    /*** Locators **/
    By bySearchField = By.cssSelector("input#twotabsearchtextbox");
    By byAmazonLogo ;
    String logoCountry = "//a[@aria-label='";
    String logoCountry2= "']";

    //Constructor para inicializar driver e interactuar en clase Test
    public HomePage(WebDriver driver){
        super(driver);
    }


    public void inputSearch(String testData){

        WebElement searchField = getElementOfPresenceOfElementLocated(bySearchField,5);
        Log.info("Searching for : " + testData);
        searchField.sendKeys(testData);
        searchField.sendKeys(Keys.ENTER);
    }

    public void validateAmazonLogo(String label){
        byAmazonLogo = By.xpath(logoCountry+label+logoCountry2);
        Assert.assertTrue(driver.findElement(byAmazonLogo).isDisplayed());

    }

    public boolean validateAmazonImage(String label){
        Log.info("Validating Amazon Logo is present with : "+label);
        try{
            byAmazonLogo = By.xpath(logoCountry+label+logoCountry2);
            WebElement logo = driver.findElement(byAmazonLogo);
            Log.info("Correct Amazon Logo was found ");
            return true;

        } catch (Exception e){
            Log.fatal("Logo with :" +label + " was not found");
            return false;
        }


    }






}
