package PageObjects;

import Utilis.Utilis;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilis.BaseUtil;

import java.util.SortedSet;

import static java.lang.Thread.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PropertySettingsPage {
    WebDriver driver;
    Dashboard dashboard;

    public PropertySettingsPage ( WebDriver driver ) {
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    Utilis utilis = new Utilis ( );
    public BaseUtil baseUtil;

    // Variables
    String updatedVoiceAddressURL;
    String actualVoiceAddressURL;

    //Voice agent path
    @FindBy( how = How.ID, using = "voiceAgent" )
    private WebElement voiceAgent;

    @FindBy( how = How.CSS, using = ".button.button-highlight.applychanges" )
    private WebElement applyChangeButton;

    @FindBy( how = How.CSS, using = ".icon.icon-home" )
    private WebElement homeIcon;

    @FindBy( how = How.ID, using = "confirmationModel" )
    private WebElement confirmationPop;

    String NewURL = "s";

    String popupTitle = "You are trying to update highly sensitive parameters across all devices which will be applied to all rooms including guest occupied rooms (if any). Do you want to proceed?";

    @FindBy( how = How.ID, using = "yes" )
    private WebElement yesButton;

    @FindBy( how = How.XPATH, using = "//*[@id='confirmationModel']/p" )
    private WebElement popupText;


    public void updateVoiceAgentAddress ( ) throws InterruptedException {
        Utilis utilis = new Utilis ( );
        utilis.elementIsDisplayed ( driver , voiceAgent );
        utilis.click ( driver , voiceAgent );
        actualVoiceAddressURL = utilis.getAtrributeValue ( driver , voiceAgent , "value" );
        System.out.println ( "Actual voice address USL is:" + actualVoiceAddressURL );
        voiceAgent.clear ( );
        Thread.sleep ( 3000 );
        updatedVoiceAddressURL = actualVoiceAddressURL.concat ( NewURL );
        voiceAgent.sendKeys ( updatedVoiceAddressURL );
    }

    //Click on Applybutton
    public void clickApplyButton ( ) throws InterruptedException {
        Thread.sleep ( 3000 );
        utilis.click ( driver , applyChangeButton );
    }

    //verify the pop-up message on PropertyManagement
    public void propertyManagementPopUp ( ) {
        driver.switchTo ( ).activeElement ( );
        utilis.verifyTitleOfPopupWindowandClickOnYesOrNo ( driver , popupText , popupTitle , yesButton );
    }

    // Verify voice agent URL is updated
    public void verifyVoiceAgentURLIsUpdated(){
        String temp = utilis.getAtrributeValue ( driver , voiceAgent , "value" );
        System.out.println ("updated URL:"+temp );
        Assert.assertEquals ( temp,updatedVoiceAddressURL );
    }

}
