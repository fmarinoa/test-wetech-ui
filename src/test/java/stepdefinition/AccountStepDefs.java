package stepdefinition;

import io.cucumber.java.en.Then;
import step.AccountSteps;

import static hook.DriverManager.screenShot;

public class AccountStepDefs {
    AccountSteps accountSteps;

    public AccountStepDefs() {
        accountSteps = new AccountSteps();
    }

    @Then("valido haber iniciado sesión correctamente")
    public void validoHaberIniciadoSesiónCorrectamente() throws InterruptedException {
        accountSteps.validarEstarLogueado();
        screenShot();
    }
}
