package PageObjects;

import Utilis.Utilis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


/**
 * @author manju on 4/9/2018
 */
public class Dashboard {

    WebDriver driver;
    static int deviceDefaultCount=0;

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

    @FindBy(how = How.XPATH,using = "//table[@class='devicelist-table']/tbody/tr[1]/td[2]//a/div")
    private WebElement deviceName;

    //XPath of PropertySettings icon in Dashboard
    @FindBy(how = How.CSS,using = "i.icon.icon-settings")
    private WebElement propertySettingIcon;

    public void deviceTotalCountSumofOnlineOfflinAndErrordevices ( ) {
        utilis.elementIsDisplayed ( driver , totalDevicesCount );
        utilis.elementIsDisplayed ( driver , errorDevicesCount );
        utilis.elementIsDisplayed ( driver , offlineDevicesCount );
        utilis.elementIsDisplayed ( driver , onlineDevicesCount );
        int totalDevices = Integer.parseInt ( totalDevicesCount.getText ( ) );
        int errorDevices = Integer.parseInt ( errorDevicesCount.getText ( ) );
        int offlineDevices = Integer.parseInt ( offlineDevicesCount.getText ( ) );
        int onlineDevices = Integer.parseInt ( onlineDevicesCount.getText ( ) );
        //Verify Total device count should be sum of offline,error and online devices.
        if ( totalDevices == errorDevices + offlineDevices + onlineDevices ) {
            Assert.assertTrue ( true );
        } else {
            Assert.assertTrue ( false );
        }

    }

    public void totalDeviceCount()
    {
        utilis.elementIsDisplayed(driver, totalDevicesCount);
        int totalDevices = Integer.parseInt ( totalDevicesCount.getText ( ) );
        if (deviceDefaultCount == totalDevices) {
            Assert.assertTrue(true);
            System.out.println("Devices are not yet Loaded OR Registerd for the Property");
        }
        else
        {
            Assert.assertTrue(false);
            System.out.println("Total Devices loaded for this property are:"+totalDevices);

        }
    }


    public void logoIsDisplayed ( ) {
        utilis.elementIsDisplayed ( driver , JBLLogo );
    }

    public void clickOnUmutedDevice ( )
    {
        utilis.click ( driver , deviceOneMuted );

    }


    public void verifyMessageDisplayedOnPop ( )
    {
        assertThat ( messageOnPopup.getText ( ) ).containsIgnoringCase ( "Are you sure you wish to Unmute the device" );
    }

    public void clickOnYesButton ( ) {
        utilis.click ( driver , yesButton );
    }

    public void verifyDeviceIsUnmuted ( ) throws InterruptedException {
        Thread.sleep(3000);
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

    public void clickOnDeviceName() throws InterruptedException {
        //find the online device
        utilis.click(driver, deviceName);
        Thread.sleep(3000);

    }
    //click on setting icon
    public void clickonPropertySettings() throws InterruptedException {
        utilis.waitForElement(driver, propertySettingIcon, 2000);
        utilis.click(driver, propertySettingIcon);
        //utilis.click(driver, propertySettingIcon);
       }

    public void verifyOneNotificationIsDisplayed(){
        utilis.elementIsDisplayed ( driver,oneNotification );
    }

}
