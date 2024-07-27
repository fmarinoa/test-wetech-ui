package step;

import org.openqa.selenium.NoSuchElementException;
import page.HomePage;
import page.LoginPage;

import java.awt.*;
import java.awt.event.KeyEvent;

import static page.BasePage.waitForSeconds;


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
                Robot robot = new Robot();
                // Simula la presión de la tecla ESC
                robot.keyPress(KeyEvent.VK_ESCAPE);
                robot.keyRelease(KeyEvent.VK_ESCAPE);
                System.out.println("Presioné escape");
                waitForSeconds(1);
            }
        } while (!found);
    }
}
