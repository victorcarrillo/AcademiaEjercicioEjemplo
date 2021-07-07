package PageObjects;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.*;
import sun.tools.java.Environment;
import utilities.CommonUtilities;
import utilities.Log;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

     public WebDriver driver ;
     String projectPath= System.getProperty("user.dir");
     public Properties props ;
     String osEnv = System.getProperty("os.name");

    @BeforeMethod
    public void setUp(){
        Log.startLog("Test Suite is starting");
        Log.info("Setting up test execution");

        if(osEnv.contains("Mac")){

            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            props=CommonUtilities.loadProperties(projectPath+ "/src/main/resources/testData.properties");

            ChromeOptions op = new ChromeOptions();

            if(props.getProperty("webapp.incognito").equals("true")) {
                op.addArguments("--incognito");
            }
            if(props.getProperty("webapp.headlessExecution").equals("true")){
                op.addArguments("--headless");
            }


            driver = new ChromeDriver(op);
            Log.info("Opening Browser");

        } else if(osEnv.contains("Windows")){

            System.setProperty("webdriver.chrome.driver",projectPath + "\\drivers\\chromedriver.exe");
            props = CommonUtilities.loadProperties(projectPath+ "\\src\\main\\resources\\testData.properties");
            driver = new ChromeDriver();
            Log.info("Opening Browser");

        } else {

            Log.fatal("No valid OS Name");
            throw new IllegalArgumentException("OS name not found");
        }



    }

    @AfterMethod
    public void cleanUp(){
        Log.endLog("Ending Execution");
        driver.close();
        driver.quit();
    }


    }



