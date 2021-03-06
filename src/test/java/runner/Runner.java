package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.relevantcodes.extentreports.DisplayOrder;


@RunWith( Cucumber.class )
@CucumberOptions(
        features = { "classpath:Features" },
        glue = { "classpath:stepdefinitions" },
        tags = "@smoke",
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter"},
        monochrome = true )


public class Runner {
    @BeforeClass
    public static void setup ( ) {
        ExtentCucumberFormatter.initiateExtentCucumberFormatter ( );
        DisplayOrder NEWEST_FIRST    = null;
        Boolean      replaceExisting = false;
        DateFormat   dateFormat      = new SimpleDateFormat ( "yyyyMMdd_HHmm" );
        Date         date            = new Date ( );
        String       reportFilePath  = "output/Reports/" + "EVPA" + dateFormat.format ( date ) + ".html";
        // String reportFilePath = "output/Reports/" + "Report"+".html";
        ExtentCucumberFormatter.initiateExtentCucumberFormatter ( new File ( reportFilePath ) , replaceExisting ,
                NEWEST_FIRST );
        ExtentCucumberFormatter.loadConfig ( new File ( "src/test/resources/extent-config.xml" ) );

    }
}