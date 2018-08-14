package stepdefinitions;

import PageObjects.Dashboard;
import PageObjects.DetailsPage;
import PageObjects.LoginPage;
import PageObjects.PropertySettingsPage;
import Utilis.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class DeviceDetails
{

    public BaseUtil baseUtil;
    LoginPage loginPage;
    Dashboard dashboard;
    DetailsPage detailsPage;
    PropertySettingsPage settingPage;

    static Logger log=Logger.getLogger ( DeviceDetails.class );

    public DeviceDetails(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        loginPage = new LoginPage(baseUtil.driver);
        dashboard = new Dashboard(baseUtil.driver);
        detailsPage = new DetailsPage(baseUtil.driver);
        settingPage = new PropertySettingsPage(baseUtil.driver);

    }

    //Editing Placement Info details.
    @When("^User selects the device which is online and click on Device Name$")
    public void userSelectsTheDeviceWhichIsOnlineAndClickOnDeviceName() throws Throwable {
        dashboard.clickOnDeviceName();
        log.info ( "Device clicked" );
    }
    @Then("^Verify MapToAnotherRoom is displayed$")
    public void verifyMapToAnotherRoomIsDisplayed() throws Throwable {
    detailsPage.verifyMoveToAnotherRoomText();
    }
    @And("^Click on Edit Icon in General section$")
    public void clickOnEditIconInGeneralSection() throws Throwable {
    detailsPage.clickGeneralEdit();

    }
    @Then("^Update Placement Info details$")
    public void updatePlacementInfoDetails() throws Throwable {
    detailsPage.inputPlaceInfo();
        log.info ( "updated placement details" );
    }
    @Then("^Click on Save button$")
    public void clickOnSaveButton() throws Throwable {
    detailsPage.savePlacementInfo();
    }
}
