package stepdefinitions;

import PageObjects.Dashboard;
import PageObjects.DetailsPage;
import PageObjects.LoginPage;
import PageObjects.PropertySettingsPage;
import Utilis.BaseUtil;
import Utilis.Utilis;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class DeviceSettings {
    Utilis utilis = new Utilis ( );
    public BaseUtil baseUtil;
    LoginPage            loginPage;
    Dashboard            dashboard;
    DetailsPage          detailsPage;
    PropertySettingsPage settingPage;

    public DeviceSettings ( BaseUtil baseUtil ) {
        this.baseUtil = baseUtil;
        Utilis utilis = new Utilis ( );
        loginPage = new LoginPage ( baseUtil.driver );
        dashboard = new Dashboard ( baseUtil.driver );
        detailsPage = new DetailsPage ( baseUtil.driver );
        settingPage = new PropertySettingsPage ( baseUtil.driver );
    }

    //Edit VoiceAgent URL at Property level
    @When( "^Click on PropertySetting icon on Dashboard screen$" )
    public void clickOnPropertySettingIconOnDashboardScreen ( ) throws Throwable {
        dashboard.clickonPropertySettings ( );
    }

    @And( "^Select VoiceAgent address and update VoiceAddress$" )
    public void selectVoiceAgentAddressAndUpdateVoiceAddress ( ) throws Throwable {
        settingPage.updateVoiceAgentAddress ( );
    }

    @Then( "^Click on ApplyChange button$" )
    public void clickOnApplyChangeButton ( ) throws Throwable {
        settingPage.clickApplyButton ( );
    }

    @And( "^Verify Confirmation message pop-up and click on yes button$" )
    public void verifyConfirmationMessagePopUpAndClickOnYes ( ) throws Throwable {
        settingPage.propertyManagementPopUp ( );
    }

    @When( "^User clicks on Yes button displayed in popup to update VoiceAgent address$" )
    public void userClicksOnYesButtonDisplayedInPopupToUpdateVoiceAgentAddress ( ) throws Throwable {
        dashboard.clickOnYesButton ( );
    }

    @And( "^Verify Voiceagent URL is updated$" )
    public void verifyVoiceagentURLIsUpdated ( ) throws Throwable {
        settingPage.verifyVoiceAgentURLIsUpdated ();
    }
}
