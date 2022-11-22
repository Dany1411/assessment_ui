package metro.assessment.pageobjects;

import metro.assessment.utils.WebElementsChecker;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class LandingPagePO extends PageObject {

    private WebElementsChecker webElC;

    @FindBy(css="div.navbar-aux-content")
    public WebElement navigationBar;

    @FindBy(css="input#searchboxTrigger")
    public WebElement searchInput;

    @FindBy(css="button.searchbox-submit-button")
    public WebElement searchButton;

    @FindBy(css="li.main-megamenu-trigger")
    public WebElement productsMenu;

    @FindBy(xpath="//a[contains(text(),'Genius')]")
    public WebElement geniusMenu;

    @FindBy(xpath="//a[contains(text(),'Card')]")
    public WebElement emagCardMenu;

    @FindBy(xpath="//a[contains(text(),'Resigilate')]")
    public WebElement resigMenu;

    @FindBy(xpath="//a[contains(text(),'Oferta')]")
    public WebElement offerMenu;

    @FindBy(css="button.js-accept")
    public WebElement acceptAllCookies;

    @FindBy(css="button.js-dismiss-login-notice-btn")
    public WebElement closeLoginInfoBar;


    public void checkLandingPageElements(){
        List<WebElement> lpWebElements = Arrays.asList(navigationBar, searchInput, searchButton, productsMenu,
                geniusMenu, emagCardMenu, resigMenu, emagCardMenu, offerMenu);

        webElC.checkPresenceOfWebElementsFromList(lpWebElements);
    }

    public void insertSearchText(String text){
        Actions action = new Actions(getDriver());
        webElC.waitWebElementBeVisible(searchInput);
        action.moveToElement(searchInput).perform();
        webElC.insertText(searchInput,text);
    }

    public void clickOnSearchIcon(){
        webElC.clickOn(searchButton);
    }

    public void acceptCookies(){
        webElC.waitWebElementBeVisible(acceptAllCookies);
        webElC.clickOn(acceptAllCookies);
        webElC.waitWebElementBeVisible(closeLoginInfoBar);
        webElC.clickOn(closeLoginInfoBar);
    }

    public void clickOnButton(NavigationBarElements button){
        webElC.clickOn(getDriver().findElement(button.getLocator()));
    }



}
