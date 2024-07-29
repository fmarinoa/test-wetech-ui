package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import step.HomeSteps;

import java.awt.*;

import static hook.DriverManager.screenShot;
import static page.BasePage.waitForSeconds;
import static util.PressKeys.pressEsc;

public class HomeStepDefs {

    HomeSteps homeSteps;

    public HomeStepDefs() {
        homeSteps = new HomeSteps();
    }

    @Given("estoy en la página principal")
    public void estoyEnLaPagínaPrincipal() throws InterruptedException, AWTException {
        homeSteps.abrirPaginaPrincipal();
        screenShot();
        waitForSeconds(2);
        pressEsc();
    }

    @And("me dirijo a inciar sesión")
    public void meDirijoAInciarSesión() throws InterruptedException, AWTException {
        homeSteps.irAIniciarSesion();
        screenShot();
    }

    @When("busco el producto {string}")
    public void buscoElProducto(String arg0) throws InterruptedException {
        homeSteps.buscarProducto(arg0);
        screenShot();
    }
}
