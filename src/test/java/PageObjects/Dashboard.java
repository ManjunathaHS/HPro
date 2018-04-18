package PageObjects;

import Utilis.Utilis;
import jdk.nashorn.internal.ir.IndexNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.ws.wsaddressing.W3CEndpointReference;

/**
 * @author jayaprakashs on 4/9/2018
 */
public class Dashboard {

    WebDriver driver;

    public Dashboard(WebDriver driver) {
       PageFactory.initElements(driver,this);
       this.driver=driver;
       }


    @FindBy(how = How.XPATH,using = "//div[@class='logo-holder']")
    private WebElement JBLLogo;

    @FindBy(how = How.XPATH,using = "//i[@class='icon icon-settings']")
    public WebElement settings;

    @FindBy(how = How.XPATH,using = "//*[@class='device-status total-devices']/span")
    private WebElement totalDevicesCount;

    @FindBy(how = How.XPATH,using = "//*[@class='device-status error-devices']/span")
    private WebElement errorDevicesCount;

    @FindBy(how = How.XPATH,using = "//*[@class='device-status offline-devices']/span")
    private WebElement offlineDevicesCount;

    @FindBy(how = How.XPATH,using = "//*[@class='device-status online-devices']/span")
    private WebElement onlineDevicesCount;


    public void  deviceTotalCountSumofOnlineOfflinAndErrordevices(){
        Utilis utilis=new Utilis();
        utilis.elementIsDisplayed(driver,totalDevicesCount);
        utilis.elementIsDisplayed(driver,errorDevicesCount);
        utilis.elementIsDisplayed(driver,offlineDevicesCount);
        utilis.elementIsDisplayed(driver,onlineDevicesCount);
        int totalDevices=Integer.parseInt(totalDevicesCount.getText());
        int errorDevices=Integer.parseInt(errorDevicesCount.getText());
        int offlineDevices=Integer.parseInt(offlineDevicesCount.getText());
        int onlineDevices= Integer.parseInt(onlineDevicesCount.getText());
        if(totalDevices==errorDevices+offlineDevices+onlineDevices){
            Assert.assertTrue(true);
        }else
        {
            Assert.assertTrue(false);
        }
    }

    public void logoIsDisplayed(){
        Utilis utilis=new Utilis();
        utilis.elementIsDisplayed(driver,JBLLogo);
    }

}
