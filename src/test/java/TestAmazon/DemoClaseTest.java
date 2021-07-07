package TestAmazon;


import PageObjects.BaseTest;
import PageObjects.HomePage;
import PageObjects.MyCartPage;
import PageObjects.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Log;

public class DemoClaseTest extends BaseTest{

    /**Test Data **/
    String URL_qa;
    String logoImage;
    String TEST_DATA ;
    String MIN_PRICE;
    String MAX_PRICE;

    @Test
    public void firstTestCase()  {
        URL_qa = props.getProperty("webapp");
        logoImage = props.getProperty("webappLogo");
        TEST_DATA = props.getProperty("searchOne");
        Log.info("Opening " + URL_qa);
        driver.get(URL_qa);

        Log.info( "Executing Test Case Login-1 ");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.validateAmazonImage(logoImage),"Validation for Logo");
        homePage.inputSearch(TEST_DATA);

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.validateSearchMessage(TEST_DATA));
        searchPage.filterRatingFourPlus();
        searchPage.filterBrand("Apple");
        searchPage.filterAmazonMxSeller();
        searchPage.retrieveResults("Apple AirPods");

    }

    @Test
    public void searchHeadphones(){
        URL_qa = props.getProperty("webapp");
        logoImage = props.getProperty("webappLogo");
        TEST_DATA = props.getProperty("searchTwo");
        MIN_PRICE = props.getProperty("minPrice");
        MAX_PRICE = props.getProperty("maxPrice");

        Log.info("Opening " + URL_qa);
        driver.get(URL_qa);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.validateAmazonImage(logoImage),"Validation for Logo");
        homePage.inputSearch(TEST_DATA);

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.validateSearchMessage(TEST_DATA));
        searchPage.filterBrand("Bose");
        searchPage.setMinPriceFilter(MIN_PRICE);
        searchPage.setMaxPriceFilter(MAX_PRICE);
        searchPage.clickSetPriceFilter();
        searchPage.clickOnElement();

        searchPage.addToCart();
        searchPage.validateWarrantyPopOver();//agregar un wait
        searchPage.goToMyCart();

        MyCartPage myCartPage = new MyCartPage(driver);
        myCartPage.validateQuantityCartItems();
    }













    @Test
    public void secondTestCase(){
        TEST_DATA = props.getProperty("searchTwo");
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert line 1 Was Started");
        softAssertion.assertTrue(true,"Validation 1");
        System.out.println("softAssert line 1 Was Executed");
        System.out.println("softAssert line 2 Was Started");
        softAssertion.assertTrue(true,"Validation 2");
        System.out.println("softAssert line 2 Was Executed");
        softAssertion.assertAll();
    }

    @Test
    public void thirdTestCase(){

        System.out.println("hardAssert Method Was Started");
        Assert.assertTrue(false,"Validation 1");
        System.out.println("hardAssert Method Was Executed");

    }





}
