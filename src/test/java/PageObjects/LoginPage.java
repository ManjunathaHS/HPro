package PageObjects;

import Utilis.Utilis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author jayaprakashs on 4/9/2018
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage ( WebDriver driver ) {
        PageFactory.initElements ( driver , this );
        this.driver = driver;
    }

    Utilis utilis = new Utilis ( );

    @FindBy( how = How.ID, using = "logonIdentifier" )
    private WebElement userNameTextBox;

    @FindBy( how = How.ID, using = "password" )
    private WebElement passwordTextBox;

    @FindBy( how = How.ID, using = "next" )
    private WebElement signButton;

    @FindBy( how = How.XPATH, using = "/html/body/div[2]/div/div[1]" )
    private WebElement textName;

    public void inputUserNameAndPassword ( String userName , String password ) {

        utilis.elementIsDisplayed ( driver , textName );
        utilis.elementIsDisplayed ( driver , userNameTextBox );
        utilis.elementIsDisplayed ( driver , passwordTextBox );
        try {
            Thread.sleep ( 4000 );
        } catch ( InterruptedException e ) {
            e.printStackTrace ( );
        }
        userNameTextBox.sendKeys ( userName );
        passwordTextBox.sendKeys ( password );
    }

    public void clickOnSign ( ) {
        utilis.click ( driver , signButton );
    }
}
