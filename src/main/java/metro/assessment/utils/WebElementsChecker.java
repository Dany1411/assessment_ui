package metro.assessment.utils;

import net.serenitybdd.core.pages.PageObject;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class WebElementsChecker extends PageObject {

    public static final Logger LOGGER = Logger.getLogger(WebElementsChecker.class.getName());

    public void waitWebElementBeVisible(WebElement element){
        LOGGER.info("Waiting web element be visible: " + element.toString());

        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void checkPresenceOfWebElementsFromList(List<WebElement> itemList){
        itemList.forEach(subItem ->{
            LOGGER.info("Check " + subItem.toString() + " web element");
            waitWebElementBeVisible(subItem);}
        );
    }

    public void insertText(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

}
