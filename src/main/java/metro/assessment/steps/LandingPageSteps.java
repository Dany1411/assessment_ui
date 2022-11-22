package metro.assessment.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metro.assessment.pageobjects.LandingPagePO;
import metro.assessment.pageobjects.NavigationBarElements;

public class LandingPageSteps {

    private LandingPagePO landingPagePO;

    @Then("^I see landing page for e-commerce site$")
    public void checkLandingPage() {
        landingPagePO.acceptCookies();
        landingPagePO.checkLandingPageElements();
    }

    @When("^I search for (.*)$")
    public void searchForText(String text) {
        landingPagePO.insertSearchText(text);
        landingPagePO.clickOnSearchIcon();
    }

    @When("^click to (.*) page$")
    public void clickOnMenu(NavigationBarElements button) {
        landingPagePO.clickOnButton(button);
    }
}



