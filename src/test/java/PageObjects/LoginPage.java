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
public class LoginPage{

    WebDriver driver;

    public LoginPage(WebDriver driver) {
         PageFactory.initElements(driver,this);
        this.driver=driver;
    }


    @FindBy(how = How.ID,using = "logonIdentifier")
    private WebElement userNameTextBox;

    @FindBy(how = How.ID,using ="password" )
    private  WebElement passwordTextBox;

    @FindBy(how = How.ID,using = "next")
    private WebElement signButton;

    public void inputUserNameAndPassword(String userName,String password){
        Utilis utilis= new Utilis();
        utilis.elementIsDisplayed(driver,userNameTextBox);
        utilis.elementIsDisplayed(driver,passwordTextBox);
        userNameTextBox.sendKeys(userName);
        passwordTextBox.sendKeys(password);
    }

    public void clickOnSign(){
        Utilis utilis= new Utilis();
        utilis.click(driver,signButton);
        }
}
