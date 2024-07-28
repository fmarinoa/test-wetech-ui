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

    @Then("valido el precio del producto debe ser {string}")
    public void validoElPrecioDelProductoDebeSer(String expectedPrice) throws InterruptedException {
        double currentPrice = searchProductSteps.getCurrentPrice();
        Assert.assertEquals(Double.parseDouble(expectedPrice), currentPrice, 0.01f);
        System.out.println("Los precios coinciden");
        screenShot();
    }

}
