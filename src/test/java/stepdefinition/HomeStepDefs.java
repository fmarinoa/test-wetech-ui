package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import step.HomeSteps;

import java.awt.*;

import static hook.DriverManager.screenShot;
import static page.BasePage.waitForSeconds;

public class HomeStepDefs {

    HomeSteps homeSteps;

    public HomeStepDefs() {
        homeSteps = new HomeSteps();
    }

    @Given("estoy en la página principal")
    public void estoyEnLaPagínaPrincipal() throws InterruptedException {
        homeSteps.abrirPaginaPrincipal();
        screenShot();
        waitForSeconds(2);
    }

    @And("me dirijo a inciar sesión")
    public void meDirijoAInciarSesión() throws InterruptedException, AWTException {
        homeSteps.irAIniciarSesion();
        screenShot();
    }
}
