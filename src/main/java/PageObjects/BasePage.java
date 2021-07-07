package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class BasePage {

    WebDriver driver ;
    WebElement element;
    WebElement ele;
    List<WebElement> listWebElement;

    public BasePage(WebDriver driver){
        this.driver =driver ;
    }


    public WebDriverWait wait(int secs){
        return new WebDriverWait(driver,secs);
    }

    public WebElement getElementOfPresenceOfElementLocated(By by, int secs){

        try{
            element = wait(secs)
                    .ignoring(TimeoutException.class,NoSuchElementException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        }catch (NoSuchElementException e){
            Log.fatal(" Element is not found during execution " +e);

        }
        return null;
    }

    public List<WebElement> getListElements(By by,int secs){
        try{
            listWebElement = wait(secs)
                            .ignoring(TimeoutException.class,NoSuchElementException.class)
                            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            return listWebElement;
        } catch(NoSuchElementException e){
            Log.fatal(" Elements are not found during execution " +e);
        }
        return null;
    }


}
