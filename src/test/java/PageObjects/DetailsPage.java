package PageObjects;

import Utilis.Utilis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author manju on 06/04/2018
 */

public class DetailsPage {

         WebDriver driver;

        public DetailsPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
            String devicePlacement = "side";

        }
        Utilis utilis = new Utilis();

        @FindBy(how = How.XPATH, using = "//div[@class='room-detail-header row']//a[@class='maptoaother-room link-bold float-right']")
        private WebElement mapToAnotherRoom;

        @FindBy(how = How.XPATH, using = "//*[@id='deviceDetails']/div/div/ul/li[1]/span/i[@title='Edit']")
        private WebElement generalEditIcon;

        @FindBy(how = How.ID, using = "placementInfo")
        public WebElement placementInfo;

        @FindBy(how = How.XPATH, using = "//div[@class='room-detail-content row']//a[1]")
        public WebElement generalSaveButton;

        String infoName = "left";

        public WebElement getPlacementInfo()
        {
            return placementInfo;
        }

        public void verifyMoveToAnotherRoomText()
         {
             utilis.elementIsDisplayed(driver, mapToAnotherRoom);

         }

         public void inputPlaceInfo()
         {
             Utilis utilis = new Utilis ( );
             utilis.elementIsDisplayed(driver,placementInfo);
             String actualName=placementInfo.getAttribute("value");
             System.out.println("Actual Placement Name is:"+ actualName);
             placementInfo.clear();
             String tempString=actualName.concat(infoName);
             utilis.sendKeys(driver,placementInfo,tempString);
             //             String updatedAcutalName = placementInfo.getText();
//             if (updatedAcutalName==tempString)
//             {
//                 Assert.assertTrue(true);
//             }
//                 else
//             {
//              Assert.assertTrue(false);
//             }
         }

         public void savePlacementInfo()
         {
             utilis.click(driver, generalSaveButton);
         }


        private void clickonMoveToanotherRoom()
        {
           utilis.click(driver, mapToAnotherRoom);

        }

        public void clickGeneralEdit()
        {
            utilis.click(driver, generalEditIcon);
        }


}
