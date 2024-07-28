package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step.LoginSteps;

import static hook.DriverManager.screenShot;
import static page.BasePage.clickByText;
import static page.BasePage.validateExistText;

public class LoginStepDefs {
    LoginSteps loginSteps;

    public LoginStepDefs() {
        loginSteps = new LoginSteps();
    }

    @When("escribo el correo {string}")
    public void escriboElCorreo(String arg0) throws InterruptedException {
        loginSteps.sendCorreo(arg0);
        screenShot();
    }

    @And("escribo la contraseña {string}")
    public void escriboLaContraseña(String arg0) throws InterruptedException {
        loginSteps.sendPassword(arg0);
        screenShot();
    }

    @And("presiono el botón {string}")
    public void presionoElBotón(String arg0) throws InterruptedException {
        clickByText(arg0);
    }

    @Then("valido el mensaje {string}")
    public void validoElMensaje(String arg0) throws InterruptedException {
        validateExistText(arg0);
        screenShot();
    }
}
