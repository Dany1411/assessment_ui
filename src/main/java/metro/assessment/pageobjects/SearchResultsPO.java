package metro.assessment.pageobjects;

import metro.assessment.utils.WebElementsChecker;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class SearchResultsPO extends PageObject {

    private WebElementsChecker webElC;

    @FindBy(css="div.sidebar-filter-container")
    public WebElement filterContainer;

    @FindBy(css="div.listing-page-title")
    public WebElement searchResultsPageTitle;

    @FindBy(css="div.js-head-sort-options")
    public WebElement searchResultsSortOptions;

    @FindBy(css="div.modal-content i.em-close")
    public WebElement closeModalIcon;

    @FindBy(css="a#my_cart span.jewel-danger")
    public WebElement nrOfItemsInTheCart;

    @FindBy(css="div.card-v2")
    public List<WebElement> searchResultsItems;

    private By itemActionButton = By.cssSelector("div.card-v2-atc");
    private By addToCartButton = By.cssSelector("button[type='submit']");

    public void checkSearchResultsPage(){
        List<WebElement> searchResultPageElem = Arrays.asList(filterContainer, searchResultsPageTitle, searchResultsSortOptions);

        assertThat("There are no results for this search", searchResultsItems.size(), greaterThan(0));
        webElC.checkPresenceOfWebElementsFromList(searchResultPageElem);
    }

    public void addItemsInTheUserCart(String nrOfItems){
        Actions action = new Actions(getDriver());

        for (WebElement item : searchResultsItems){
            System.out.println(item.findElement(itemActionButton).getText());
            if(item.findElement(itemActionButton).getText().equalsIgnoreCase("Adauga in Cos")){
                action.moveToElement(item.findElement(addToCartButton)).perform();
                item.findElement(addToCartButton).click();
                webElC.clickOn(closeModalIcon);
                if(nrOfItemsInTheCart.getText().equalsIgnoreCase(nrOfItems)) break;
            }
        }

    }

}
