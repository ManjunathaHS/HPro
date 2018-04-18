package Utilis;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author jayaprakashs on 4/10/2018
 */
public class BaseUtil {

    private WebDriver driver;
    private static boolean startBrowser = false;


    public WebDriver getDriver ( ) {
        return driver;
    }

    @Before
    public void init ( ) throws Exception {
        if ( !startBrowser ) {
            ChromeOptions options = new ChromeOptions ( );
            Properties props = new Properties ( );
            System.setProperty ( "webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" );
            FileInputStream propsfile = new FileInputStream ( "src/test/resources/TestData.properties" );
            props.load ( propsfile );
            options.addArguments ( "--disable-extensions" );
            driver = new ChromeDriver ( options );
            driver.manage ( ).window ( ).maximize ( );
            driver.manage ( ).deleteAllCookies ( );
            startBrowser = true;

        }
    }


    @After
    public void embedScreenshotAndCloseBrowser ( Scenario scenario ) {
        if ( scenario.isFailed ( ) ) {
            try {
                scenario.write ( "Current Page URL is " + driver.getCurrentUrl ( ) );
                byte[] screenshot = ( ( TakesScreenshot ) driver ).getScreenshotAs ( OutputType.BYTES );
                scenario.embed ( screenshot, "image/png" );
            } catch ( WebDriverException somePlatformsDontSupportScreenshots ) {
                System.err.println ( somePlatformsDontSupportScreenshots.getMessage ( ) );
            }
        }
        driver.quit ( );
    }

}
