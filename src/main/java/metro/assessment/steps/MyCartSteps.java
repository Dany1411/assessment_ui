package metro.assessment.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metro.assessment.pageobjects.MyCartPO;
import metro.assessment.pageobjects.NavigationBarElements;

public class MyCartSteps {

    private MyCartPO myCart;

    @Then("^I see my selected items$")
    public void clickOnMenu() {
        myCart.checkMyCart();
    }

    @Then("^I remove (.*) items from the list$")
    public void removeItems(int nrOfItems) throws InterruptedException {
        myCart.removeSpecificNumbersOfItems(nrOfItems);
    }

    @Then("^I see (.*) items in my cart$")
    public void checkNrOfItems(int nrOfItems) {
        myCart.checkMyCartItems(nrOfItems);
    }






}
