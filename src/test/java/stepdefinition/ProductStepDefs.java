package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import step.ProductSteps;
import step.SearchProductSteps;

import static hook.DriverManager.screenShot;

public class ProductStepDefs {
    ProductSteps productSteps;

    public ProductStepDefs() {
        productSteps = new ProductSteps();
    }

    @Then("valido el precio del producto debe ser {string}")
    public void validoElPrecioDelProductoDebeSer(String expectedPrice) throws InterruptedException {
        double currentPrice = productSteps.getCurrentPrice();
        Assert.assertEquals(Double.parseDouble(expectedPrice), currentPrice, 0.01f);
        System.out.println("Los precios coinciden");
        screenShot();
    }

    @And("capturo el precio de una unidad")
    public void capturoElPrecioDeUnaUnidad() throws InterruptedException {
        double price = productSteps.getCurrentPrice();
        productSteps.setPrice(price);
    }

    @And("agrego {string} unidades al carrito")
    public void agregoUnidadesAlCarrito(String arg0) throws InterruptedException {
        int quantity = Integer.parseInt(arg0); // Convierte la cadena a un entero
        productSteps.addProducts(quantity);
        productSteps.clickShoppingCart();
        screenShot();
    }

    @Then("valido que el precio de los productos correspondan el carrito")
    public void validoQueElPrecioDeLosProductosCorrespondanElCarrito() {

    }
}
