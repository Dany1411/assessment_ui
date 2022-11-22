package metro.assessment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public enum NavigationBarElements {


    LOGIN(By.cssSelector("a#my_account")),
    FAVORITE(By.cssSelector("a#my_wishlist")),
    MY_CART(By.cssSelector("a#my_cart"));

    private By locator;

    NavigationBarElements(By locator){
        this.locator = locator;
    }

    public By getLocator (){
        return locator;
    }

}
