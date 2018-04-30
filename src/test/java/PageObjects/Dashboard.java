package PageObjects;

import Utilis.Utilis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.*;


/**
 * @author jayaprakashs on 4/9/2018
 */
public class Dashboard {

    WebDriver driver;

    public Dashboard ( WebDriver driver ) {
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    Utilis utilis = new Utilis ( );


    @FindBy(how = How.XPATH, using = "//div[@class='logo-holder']")
    private WebElement JBLLogo;

    @FindBy(how = How.XPATH, using = "//i[@class='icon icon-settings']")
    public WebElement settings;

    @FindBy(how = How.XPATH, using = "//*[@class='device-status total-devices']/span")
    private WebElement totalDevicesCount;

    @FindBy(how = How.XPATH, using = "//*[@class='device-status error-devices']/span")
    private WebElement errorDevicesCount;

    @FindBy(how = How.XPATH, using = "//*[@class='device-status offline-devices']/span")
    private WebElement offlineDevicesCount;

    @FindBy(how = How.XPATH, using = "//*[@class='device-status online-devices']/span")
    private WebElement onlineDevicesCount;

    @FindBy(how = How.TAG_NAME, using = "//p")
    private WebElement messageOnPopup;

    @FindBy(how = How.ID, using = "yes")
    private WebElement yesButton;

    @FindBy(how = How.ID, using = "no")
    private WebElement noButton;

    @FindBy(how = How.XPATH, using = "//table[@class='devicelist-table']/tbody/tr[1]/td/span/span/a/span[@class='icon icon-mic-off']")
    private WebElement deviceOneMuted;

    @FindBy(how = How.XPATH, using = "//table[@class='devicelist-table']/tbody/tr[1]/td/span/span/a/span[@class='icon icon-mic']")
    private WebElement deviceOneUnMuted;

    @FindBy(how = How.XPATH,using = "//table[@class='devicelist-table']/tbody/tr[1]/td/span/span/a/span[@id='reboot']")
    private WebElement deviceOneReboot;

    @FindBy(how = How.CLASS_NAME,using = "icon icon-notifications-none")
    private WebElement notifications;

    @FindBy(how = How.XPATH,using = "//small[@class='notification-count' and text()='1']")
    private WebElement oneNotification;


    public void deviceTotalCountSumofOnlineOfflinAndErrordevices ( ) {
        utilis.elementIsDisplayed ( driver , totalDevicesCount );
        utilis.elementIsDisplayed ( driver , errorDevicesCount );
        utilis.elementIsDisplayed ( driver , offlineDevicesCount );
        utilis.elementIsDisplayed ( driver , onlineDevicesCount );
        int totalDevices = Integer.parseInt ( totalDevicesCount.getText ( ) );
        int errorDevices = Integer.parseInt ( errorDevicesCount.getText ( ) );
        int offlineDevices = Integer.parseInt ( offlineDevicesCount.getText ( ) );
        int onlineDevices = Integer.parseInt ( onlineDevicesCount.getText ( ) );
        if ( totalDevices == errorDevices + offlineDevices + onlineDevices ) {
            Assert.assertTrue ( true );
        } else {
            Assert.assertTrue ( false );
        }
    }

    public void logoIsDisplayed ( ) {
        utilis.elementIsDisplayed ( driver , JBLLogo );
    }

    public void clickOnUmutedDevice ( ) {
        utilis.click ( driver , deviceOneMuted );

    }


    public void verifyMessageDisplayedOnPop ( ) {
        assertThat ( messageOnPopup.getText ( ) ).containsIgnoringCase ( "Are you sure you wish to Unmute the device" );
    }

    public void clickOnYesButton ( ) {
        utilis.click ( driver , yesButton );
    }

    public void verifyDeviceIsUnmuted ( ) {
        utilis.elementIsDisplayed ( driver , deviceOneUnMuted );
    }

    public void clickOnMutedDevice ( ) {
        utilis.click ( driver , deviceOneUnMuted );
        driver.switchTo ( ).activeElement ( );
    }

    public void verifyDeviceIsMuted ( ) {
        utilis.elementIsDisplayed ( driver , deviceOneMuted );
    }

    public void clickOnDeviceToReboot(){
        utilis.click ( driver , deviceOneReboot );

    }

    public void verifyOneNotificationIsDisplayed(){
        utilis.elementIsDisplayed ( driver,oneNotification );
    }

}
