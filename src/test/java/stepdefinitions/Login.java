package stepdefinitions;

import PageObjects.Dashboard;
import PageObjects.LoginPage;
import Utilis.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * @author jayaprakashs on 4/10/2018
 */
public class Login {

    public BaseUtil baseUtil;
    LoginPage loginPage;
    Dashboard dashboard;


    public Login ( BaseUtil baseUtil ) {
        this.baseUtil = baseUtil;
        loginPage = new LoginPage ( baseUtil.driver );
        dashboard = new Dashboard ( baseUtil.driver );
    }


    @Given("^Properties with devices in different status online, offline, error and updates and also device simulator is up and running$")
    public void properties_with_devices_in_different_status_online_offline_error_and_updates_and_also_device_simulator_is_up_and_running ( ) throws Throwable {

    }

    @When("^Login to Site property admin dashboard$")
    public void login_to_Site_property_admin_dashboard ( List<String> credn) throws Throwable {
        baseUtil.driver.get ( "https://hcsdashboardappqan.azurewebsites.net" );
        loginPage.inputUserNameAndPassword ( credn.get ( 0 ), credn.get ( 1 ) );
        loginPage.clickOnSign ( );
    }

    @Then("^Site Property name should be displayed$")
    public void site_Property_name_should_be_displayed ( ) throws Throwable {

    }

    @Then("^JBL logo should be displayed$")
    public void jbl_logo_should_be_displayed ( ) throws Throwable {
        dashboard.logoIsDisplayed ( );

    }

    @Then("^Device total count should be sum of Online, Offline and Error devices count$")
    public void device_total_count_should_be_sum_of_Online_Offline_and_Error_devices_count ( ) throws Throwable {
        dashboard.deviceTotalCountSumofOnlineOfflinAndErrordevices ( );

    }


    // Mute the device and verify the Success notification
    @When("^Select unmuted device and click on Mute$")
    public void selectUnmutedDeviceAndClickOnMute ( ) throws Throwable {
        dashboard.clickOnUmutedDevice ();
        
    }

    @Then("^A popup should be displayed with the message Are you sure you want to mute the device$")
    public void aPopupShouldBeDisplayedWithTheMessageAreYouSureYouWantToMuteTheDevice ( ) throws Throwable {
        baseUtil.driver.switchTo ().activeElement ();
        Thread.sleep ( 2000 );
        //dashboard.verifyMessageDisplayedOnPop ();
    }


    @When("^User clicks on Yes button displayed in popup to mute the device$")
    public void userClicksOnYesButtonDisplayedInPopupToMuteTheDevice ( ) throws Throwable {
        dashboard.clickOnYesButton ();
    }

    @Then("^Device icon status should be changed from Mute to UnMute$")
    public void deviceIconStatusShouldBeChangedFromMuteToUnMute ( ) throws Throwable {
        dashboard.verifyDeviceIsUnmuted ();
    }

    // Unmute the device and verify the Success notification
    @When("^Select muted device and click on unMute$")
    public void selectMutedDeviceAndClickOnUnMute ( ) throws Throwable {
        dashboard.clickOnMutedDevice ();
    }

    @Then("^A popup should be displayed with the message Are you sure you want to unmute the device$")
    public void aPopupShouldBeDisplayedWithTheMessageAreYouSureYouWantToUnmuteTheDevice ( ) throws Throwable {
        baseUtil.driver.switchTo ().activeElement ();
        Thread.sleep ( 2000 );
        //dashboard.verifyMessageDisplayedOnPop ();
    }
    @When("^User clicks on Yes button displayed in popup to Unmute the device$")
    public void userClicksOnYesButtonDisplayedInPopupToUnmuteTheDevice ( ) throws Throwable {
        dashboard.clickOnYesButton ();
    }

    @Then("^Device icon status should be changed from Unmute to Mute$")
    public void deviceIconStatusShouldBeChangedFromUnmuteToMute ( ) throws Throwable {
        dashboard.verifyDeviceIsMuted ();
    }


    // Click on Reboot icon and verify the notification
    @When("^User selects the device which is online and click on Reboot icon$")
    public void userSelectsTheDeviceWhichIsOnlineAndClickOnRebootIcon ( ) throws Throwable {
        dashboard.clickOnDeviceToReboot ();

    }

    @Then("^A popup should be displayed with the message Do you want to reboot the device$")
    public void aPopupShouldBeDisplayedWithTheMessageDoYouWantToRebootTheDevice ( ) throws Throwable {
        baseUtil.driver.switchTo ().activeElement ();
        Thread.sleep ( 2000 );
        //dashboard.verifyMessageDisplayedOnPop ();
    }

    @When("^User clicks on Yes button displayed in popup to reboot the device$")
    public void userClicksOnYesButtonDisplayedInPopupToRebootTheDevice ( ) throws Throwable {
        dashboard.clickOnYesButton ();
    }

    @Then("^Reboot should be initiated message should be displayed for the selected devices in notification$")
    public void rebootShouldBeInitiatedMessageShouldBeDisplayedForTheSelectedDevicesInNotification ( ) throws Throwable {
        dashboard.verifyOneNotificationIsDisplayed ();
    }
}
