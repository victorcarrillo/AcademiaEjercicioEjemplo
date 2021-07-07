package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage{



    public SearchPage(WebDriver driver){
        super(driver);

    }

    /*** Locators ***/

    By byRatingFourPlusStars=By.xpath("//*[@id='p_72/7073863011']/span/a/section");
    By bySellerAmazonMx = By.xpath("//li[@id='p_6/AVDBXBAVVSXLQ'] //div[1]");
    By byMinPriceFilter = By.cssSelector("input#low-price");
    By byMaxPriceFilter = By.cssSelector("input#high-price");
    By byButtonSetPriceFilter = By.cssSelector("input.a-button-input");
    By byFilterBrand;
    String brandStr = "//*[@id='p_89/";
    String brandStr2 = "']/span/a/div/label/i";
    By bySearchResultElements =By.cssSelector("div.a-section.a-spacing-none>div>h2");
    //String bySearchResultElements = "div.a-section.a-spacing-none>div>h2";

    By bySearchMessage ;
    String searchMsgstr= "//div/span[contains(text(),'";
    String searchMsgstr2 = "')]";

    By  byElementSearch = By.xpath("//div[1]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img");
    By byAddToCart=By.cssSelector("input#add-to-cart-button");
    By byCoveragePopOverPresent = By.cssSelector("span#attachSiNoCoverage");
    By byMyCartIcon = By.cssSelector("div#nav-cart-count-container");

    public void filterRatingFourPlus(){
        Log.info("Filter by 4 stars of more");
        WebElement rating = driver.findElement(byRatingFourPlusStars);
        rating.click();
    }

    public void filterBrand(String brand){
        Log.info("Filter by brand "+ brand);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        byFilterBrand = By.xpath(brandStr+brand+brandStr2);

        driver.findElement(byFilterBrand).click();
    }

    public void filterAmazonMxSeller(){
        Log.info("Filter by Seller ");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(bySellerAmazonMx).click();
    }

    public void validateWarrantyPopOver(){
        Log.info("Validate if Warranty Pop Over is present");
        ele = driver.findElement(byCoveragePopOverPresent);
        if(ele.isDisplayed()){
            Log.info("Warranty is present");
            ele.click();
        }else {
            Log.info("Warranty PopOver not present ");
        }
    }

    public void goToMyCart(){
        Log.info("Navigate to My Cart");
        ele = driver.findElement(byMyCartIcon);
        ele.click();
    }


    public boolean validateSearchMessage(String searchParm){

        try{
            Log.info("Search message shows :" +searchParm);
            bySearchMessage = By.xpath(searchMsgstr+searchParm+searchMsgstr2);
            WebElement logo = driver.findElement(bySearchMessage);
            return true;
        } catch (Exception e){
            Log.info("Search message is not showing the right parameter with : "+searchParm);
            return false;
        }
    }

    public void setMinPriceFilter(String minPrice){
        Log.info("Setting Min Price Filter" );
        ele = driver.findElement(byMinPriceFilter);
        ele.sendKeys(minPrice);

    }

    public void setMaxPriceFilter(String maxPrice){
        Log.info("Setting Max Price Filter" );
        ele= driver.findElement(byMaxPriceFilter);
        ele.sendKeys(maxPrice);
    }

    public void clickSetPriceFilter(){
        Log.info("Click on setting Price Filter");
        ele=driver.findElement(byButtonSetPriceFilter);
        ele.click();
    }

    public void clickOnElement(){
        Log.info("Click on Element ");
        ele=driver.findElement(byElementSearch);
        ele.click();
    }

    public void addToCart(){
        Log.info("Click on Add to Cart");
        ele = driver.findElement(byAddToCart);
        ele.click();
    }

    public void retrieveResults(String nameProduct){

        List<WebElement> elements_name = getListElements(bySearchResultElements,5);
        int sizeList = elements_name.size();
        Log.info("Gathering all results for search ");

        for (int i=0; i<sizeList ; i++){

            String product =elements_name.get(i).getText();
            Log.info("Name of the product : " + product);

            if(product.contains("Apple AirPods")){
                Log.info("Product "+ product + " is a valid Product");
                System.out.println("------------------------------");
            } else {
                Log.warn("Product "+ product +" does not correspond to search !!");
                Log.info("------------------------------");

            }


        }
    }


}
