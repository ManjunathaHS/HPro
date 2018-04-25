package stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import Utilis.BaseUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


//@author jayaprakashs on 4/10/2018


public class BrowserHooks extends BaseUtil{

    private BaseUtil baseUtil;


    public BrowserHooks ( BaseUtil baseUtil ) {
        this.baseUtil = baseUtil;
    }

    private static boolean startBrowser = false;
    public static Properties props = new Properties ( );


    @Before
    public void openSite ( ) throws MalformedURLException, IOException {
        if ( !startBrowser ) {
            System.setProperty ( "webdriver.chrome.driver" , "src/test/resources/drivers/chromedriver.exe" );
            FileInputStream propsfile = new FileInputStream ( "src/test/resources/TestData.properties" );
            props.load ( propsfile );
            ChromeOptions options = new ChromeOptions ( );
            options.addArguments ( "--disable-extensions" );
            baseUtil.driver = new ChromeDriver ( options );
            baseUtil.driver.manage ( ).window ( ).maximize ( );
            baseUtil.driver.manage ( ).deleteAllCookies ( );
            startBrowser = true;
        }
    }

    @After
    public void embedScreenshotAndCloseBrowser ( Scenario scenario ) {
        if ( scenario.isFailed ( ) ) {
            try {
                scenario.write ( "Current Page URL is " + driver.getCurrentUrl ( ) );
                byte[] screenshot = ( ( TakesScreenshot ) driver ).getScreenshotAs ( OutputType.BYTES );
                scenario.embed ( screenshot , "image/png" );
            } catch ( WebDriverException somePlatformsDontSupportScreenshots ) {
                System.err.println ( somePlatformsDontSupportScreenshots.getMessage ( ) );
            }
        }
        baseUtil.driver.quit ( );
    }
}

