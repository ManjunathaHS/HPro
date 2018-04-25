package stepdefinitions;

import PageObjects.Dashboard;
import PageObjects.LoginPage;
import Utilis.BaseUtil;
import Utilis.Utilis;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jsoup.Connection;

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
        baseUtil.driver.get ( "https://hcsdashboardappqan.azurewebsites.net" );
    }

    @When("^Login to Site property admin dashboard$")
    public void login_to_Site_property_admin_dashboard ( ) throws Throwable {
        loginPage.inputUserNameAndPassword ( "manjunatha.s@harman.com" , "SB0Yd8o_S3G" );
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
}
