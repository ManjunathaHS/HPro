package Utilis;

import com.cucumber.listener.ExtentCucumberFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * @author jayaprakashs on 4/11/2018
 */
public class Utilis {


    // Defining of Basic selenium actions
    public Actions action = null;

    // Wait and assert element is displayed
    public void elementIsDisplayed ( WebDriver driver , WebElement element ) {
        waitForElementVisible ( driver , element , 60 );
        Assert.assertTrue ( element.isDisplayed ( ) );
    }

    public void verifyTitleOfPopupWindowandClickOnYesOrNo(WebDriver driver,WebElement titleElement,String popupTitle,WebElement yesOrNo){
        waitForElementVisible ( driver , titleElement , 60 );
        Assert.assertTrue(titleElement.getText().equalsIgnoreCase(popupTitle));
        click(driver,yesOrNo);
    }
    public String getAtrributeValue(WebDriver driver,WebElement element,String attributeValue){
        waitForElementVisible ( driver , element , 60 );
        return element.getAttribute(attributeValue);
    }
    // Wait and assert element is enabled
    public void elementIsEnabled ( WebDriver driver , WebElement element ) {
        waitForElementVisible ( driver , element , 60 );
        Assert.assertTrue ( element.isEnabled ( ) );
    }

    // Wait and assert element is not enabled
    public void elementIsNotEnabled ( WebDriver driver , WebElement element ) {
        waitForElementVisible ( driver , element , 30 );
        Assert.assertFalse ( element.isEnabled ( ) );
    }

    public void wait ( WebDriver driver , long timeInSeconds ) {
        driver.manage ( ).timeouts ( ).implicitlyWait ( timeInSeconds , TimeUnit.SECONDS );
    }

    // String to Integer
    public int stringToInt ( String s ) {
        int result = Integer.parseInt ( s );
        return result;
    }

    // 
    public void numberOfClicks ( int click , WebElement item ) {
        for (int i = 0; i < click; i++) {
            item.click ( );
        }


    }

    /*Method using action to move web element and perform click operation on it*/
    public void clickOnElementByAction ( WebDriver driver , WebElement element ) {
        Actions action = new Actions ( driver );
        action.moveToElement ( element ).build ( ).perform ( );
        action.click ( element ).build ( ).perform ( );
    }

    public void explictWaitForElement ( WebDriver driver , WebElement item , int timeout ) {
        WebElement element;
        WebDriverWait wait = new WebDriverWait ( driver , timeout );
        element = wait.until ( ExpectedConditions.elementToBeClickable ( item ) );
    }

    // will suspend the thread for specified amount of time
    public void hardSleep ( int timeInMillsec ) {
        try {
            Thread.sleep ( timeInMillsec );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
    }

    public void waitForElement ( WebDriver driver , WebElement element , int time ) {
        try {
            WebDriverWait wait = new WebDriverWait ( driver , time , 250 );
            wait.ignoring ( StaleElementReferenceException.class );
            wait.ignoring ( Exception.class );
            wait.until ( ExpectedConditions.visibilityOf ( element ) );
        } catch ( TimeoutException e ) {
            System.out.println ( "Elemet is not visible" );
            System.out.println ( e.getMessage ( ) );
            throw e;
        }
    }

    // wait till the element is invisible
    public void waitForElementNotPresentXpath ( WebDriver driver , String locator , int time ) {

        try {
            WebDriverWait wait = new WebDriverWait ( driver , time , 300 );
            wait.ignoring ( Exception.class );
            wait.until ( ExpectedConditions.invisibilityOfElementLocated ( By.xpath ( locator ) ) );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element is still visible" );
            throw e;
        }
    }

    // wait till the element is invisible
    public void waitForElementNotPresentClassName ( WebDriver driver , String locator , int time ) {

        try {
            WebDriverWait wait = new WebDriverWait ( driver , time , 300 );
            wait.ignoring ( Exception.class );
            wait.until ( ExpectedConditions.invisibilityOfElementLocated ( By.className ( locator ) ) );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element is still visible" );
            throw e;
        }
    }

    // wait till the element is invisible
    public void waitForElementNotPresentID ( WebDriver driver , String locator , int time ) {

        try {
            WebDriverWait wait = new WebDriverWait ( driver , time , 300 );
            wait.ignoring ( Exception.class );
            wait.until ( ExpectedConditions.invisibilityOfElementLocated ( By.id ( locator ) ) );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element is still visible" );
            throw e;
        }
    }

    // wait for element and then clear the text box
    public void clearTextBox ( WebDriver driver , WebElement element ) {
        try {
            waitForElementVisible ( driver , element , 10 );
            element.clear ( );
        } catch ( TimeoutException e ) {
            e.printStackTrace ( );
            throw e;
        }

    }

    // wait for element and then send keys
    public void sendKeys ( WebDriver driver , WebElement element , String keysToEnter ) {

        try {
            waitForElementVisible ( driver , element , 10 );
            //element.clear();
            element.sendKeys ( keysToEnter );
        } catch ( TimeoutException e ) {
            e.printStackTrace ( );
            throw e;
        }
    }


    // send key by actions
    public void sendKeysByAction ( WebDriver driver , WebElement element , String keysToEnter ) {
        try {
            waitForElementVisible ( driver , element , 10 );
            action.sendKeys ( keysToEnter ).build ( ).perform ( );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element not visible" );
            throw e;
        } catch ( StaleElementReferenceException ex ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element not present on page" );
            throw ex;
        }
    }


    // wait for element and click
    public void click ( WebDriver driver , WebElement element ) {

        try {
            waitForElementClickable ( driver , element , 50 );
            element.click ( );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element not visible to click" );
            throw e;
        }
    }

    // wait till the element is clickable
    public void waitForElementClickable ( WebDriver driver , WebElement element , int time ) {
        try {

            WebDriverWait wait = new WebDriverWait ( driver , time , 300 );
            wait.ignoring ( Exception.class );
            wait.until ( ExpectedConditions.elementToBeClickable ( element ) );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element not clickable" );
            throw e;
        }

    }

    // wait till the element is visible
    public void waitForElementVisible ( WebDriver driver , WebElement element , int time ) {
        try {
            WebDriverWait wait = new WebDriverWait ( driver , time , 250 );
            wait.ignoring ( StaleElementReferenceException.class );
            wait.ignoring ( Exception.class );
            wait.until ( ExpectedConditions.visibilityOf ( element ) );
        } catch ( TimeoutException e ) {
            ExtentCucumberFormatter.setTestRunnerOutput ( "Element not visible" );
            throw e;
        }

    }
}
