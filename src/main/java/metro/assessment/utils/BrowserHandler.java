package metro.assessment.utils;

import io.cucumber.java.After;
import net.serenitybdd.core.pages.PageObject;

import java.util.logging.Logger;

public class BrowserHandler extends PageObject {

    private static final Logger LOGGER = Logger.getLogger(BrowserHandler.class.getName());
    private String loggerSpliInfo = "\n############################################################";


    @After
    public void tearDown(){
        getDriver().quit();
    }

    public void goToEnvironment() {
        String runningUrl = this.getRunningURL();
        String runInfo = loggerSpliInfo +
                "\nLaunching the url: " + runningUrl +
//                "\nScreen Size: " + ScreenSize.getScreenDimension() +
                "\nDriver: " + EnvironmentConstants.WEB_DRIVER.toUpperCase() +
                loggerSpliInfo;

        LOGGER.info(runInfo);
        getDriver().get(runningUrl);
        this.maximizeScreen();
    }

    public String getRunningURL() {
        return TestDataHandler.getJsonData("onlineMag").asText();
    }

    public void maximizeScreen() {
        LOGGER.info("Set Browser Window Dimension to FULL SCREEN" );
        getDriver().manage().window().maximize();
    }

}
