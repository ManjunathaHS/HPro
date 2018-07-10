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

    public PropertySettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    Utilis utilis = new Utilis();
    public BaseUtil baseUtil;


    //Voice agent path
    @FindBy(how = How.ID, using = "voiceAgent")
    private WebElement voiceAgent;

    @FindBy(how = How.XPATH, using = "//div[@class='small-12 medium-12 large-12 columns']//div[@class='small-6 medium-6 large-6 columns']//div[@class='small-6 medium-6 large-6 is-validation columns end']")
    private WebElement applyChangeButton;

    @FindBy(how = How.XPATH, using = "//div[@id='root']//i[@class='icon icon-home']")
    private WebElement homeIcon;

    @FindBy(how = How.ID, using = "confirmationModel")
    private WebElement confirmationPop;

    String NewURL = "s";


    public void updateVoiceAgentAddress() throws InterruptedException {
        Utilis utilis = new Utilis();
        utilis.elementIsDisplayed(driver, voiceAgent);
        utilis.click(driver, voiceAgent);
       // String actualVoiceAddressURL = voiceAgent.getAttribute("value");
        String actualVoiceAddressURL = utilis.getAtrributeValue(driver,voiceAgent,"value");
        System.out.println("Actual voice address USL is:" + actualVoiceAddressURL);
        System.out.println("Actual Value is:");
        voiceAgent.clear();
        Thread.sleep(3000);
        String updatedVoiceAddressURL = actualVoiceAddressURL.concat(NewURL);
        voiceAgent.sendKeys(updatedVoiceAddressURL);
    }

    //Click on Applybutton
    public void clickApplyButton() throws InterruptedException {
        Thread.sleep(3000);
        utilis.click(driver, applyChangeButton);
        //applyChangeButton.click();
    }

    //verify the pop-up message on PropertyManagement
    public void propertyManagementPopUp() {
        baseUtil.driver.switchTo().activeElement();
        assertThat(confirmationPop.getText()).containsIgnoringCase("You are trying to update highly sensitive parameters across all devices which will be applied to all rooms including guest occupied rooms (if any). Do you want to proceed?");

    }
    }
