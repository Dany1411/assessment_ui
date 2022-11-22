package metro.assessment.steps;

import io.cucumber.java.en.Given;
import metro.assessment.utils.BrowserHandler;

public class LoadWebsite {
    private BrowserHandler browserHandler;

    @Given("^I open the e-commerce site$")
    public void openWebsite(){
        browserHandler.goToEnvironment();
    }

}
