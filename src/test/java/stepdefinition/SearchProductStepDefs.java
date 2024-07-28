package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import step.SearchProductSteps;

import static hook.DriverManager.screenShot;
import static page.BasePage.validateExistText;

public class SearchProductStepDefs {
    SearchProductSteps searchProductSteps;

    public SearchProductStepDefs() {
        searchProductSteps = new SearchProductSteps();
    }

    @When("selecciono el producto {string}")
    public void seleccionoElProducto(String arg0) throws InterruptedException {
        searchProductSteps.seleccionarProducto(arg0);
        validateExistText(arg0);
        screenShot();
    }
}
