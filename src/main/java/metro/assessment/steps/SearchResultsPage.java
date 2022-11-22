package metro.assessment.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metro.assessment.pageobjects.SearchResultsPO;

public class SearchResultsPage {

    private SearchResultsPO searchResultsPO;

    @Then("^I see results page$")
    public void checkResultsPage() {
        searchResultsPO.checkSearchResultsPage();
    }

    @When("^I add first (.*) items on the cart$")
    public void checkResultsPage(String nrOfItems) {
        searchResultsPO.addItemsInTheUserCart(nrOfItems);
        System.out.println("Test");
    }

}
