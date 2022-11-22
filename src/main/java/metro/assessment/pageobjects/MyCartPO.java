package metro.assessment.pageobjects;

import metro.assessment.utils.WebElementsChecker;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class MyCartPO extends PageObject {

    private WebElementsChecker webElC;

    @FindBy(css="h1.cart, h1.page-title")
    public WebElement myCartPageName;

    @FindBy(css="h2.cart-vendor-title, h2.vendors-item-title")
    public WebElement myCartPageTitle;

    @FindBy(css="div.emg-col3 div.order-summary-widget, div.order-summary-widget")
    public WebElement orderWidget;

    @FindBy(css="div.cart-vendor-container, div.vendors-item ")
    public WebElement itemsContainer;

    @FindBy(css="div.cart-vendor-container div.cart-widget, div.vendors-item div.cart-widget")
    public List<WebElement> items;

    private By removeItemButton = By.cssSelector("a.btn-remove-product, button.btn-remove-product");


    public void checkMyCart(){
        List<WebElement> searchResultPageElem = Arrays.asList(myCartPageName, myCartPageTitle, orderWidget);

        webElC.waitWebElementBeVisible(itemsContainer);
        System.out.println(items.size());
        assertEquals("There are more than 2 item", 2, items.size());
        webElC.checkPresenceOfWebElementsFromList(searchResultPageElem);
    }

    public void removeSpecificNumbersOfItems(int nrOfItems) throws InterruptedException {
        int totalNrOfItems = items.size();
        int nrOfItemsToDelete=nrOfItems;

        assertFalse("There is no items in the cart", items.size() == 0);
        assertFalse("Wrong number of items to delete", totalNrOfItems == 0);

        if(nrOfItemsToDelete<=items.size()){
            for (WebElement item : items){
                if (nrOfItemsToDelete>0){
                    item.findElement(removeItemButton).click();
                    sleep(2000);
                    --nrOfItemsToDelete;
                }
            }
        }

        assertEquals("Was deleted a wrong number of items", totalNrOfItems-nrOfItems, items.size());

    }

    public void checkMyCartItems(int nrOfItems){
        assertEquals("There is a wrong number of items", nrOfItems, items.size());
    }


}
