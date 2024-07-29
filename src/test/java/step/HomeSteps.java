package step;

import org.openqa.selenium.NoSuchElementException;
import page.HomePage;
import page.LoginPage;

import java.awt.*;

import static page.BasePage.waitForSeconds;
import static util.PressKeys.pressEsc;


public class HomeSteps {

    HomePage homePage;
    LoginPage loginPage;

    public HomeSteps() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    public void abrirPaginaPrincipal() throws InterruptedException {
        homePage.abrirWeTech();
        homePage.esperarCarrusel();
    }

    public void irAIniciarSesion() throws InterruptedException, AWTException {
        boolean found = false;
        do {
            try {
                homePage.clickLogin();
                loginPage.validarEstarEnLogin(1);
                found = true;
            } catch (NoSuchElementException e) {
                pressEsc();
                waitForSeconds(1);
            }
        } while (!found);
    }

    public void buscarProducto(String arg0) throws InterruptedException {
        homePage.clickBusqueda();
        homePage.escribirProducto(arg0);
        homePage.clickBusqueda2();
    }
}
