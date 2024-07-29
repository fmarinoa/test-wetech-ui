package stepdefinition;

import io.cucumber.java.en.Then;
import step.ShoppingCartSteps;

import static hook.DriverManager.screenShot;
import static step.ProductSteps.getUnitPrice;

public class ShoppingCartStepDefs {

    ShoppingCartSteps shoppingCartSteps;

    public ShoppingCartStepDefs() {
        shoppingCartSteps = new ShoppingCartSteps();
    }
    @Then("valido que el precio de los productos correspondan en el carrito")
    public void validoQueElPrecioDeLosProductosCorrespondanEnElCarrito() throws InterruptedException {
        shoppingCartSteps.validateInShoppingCart();
        double unitPrice = getUnitPrice();
        shoppingCartSteps.validatePriceTotal(unitPrice);
        shoppingCartSteps.validatePriceTotalEstimated(unitPrice);
        screenShot();
    }
}
