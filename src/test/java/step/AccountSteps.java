package step;

import org.openqa.selenium.NoSuchElementException;
import page.AccountPage;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;
import static page.BasePage.clickByText;
import static page.BasePage.waitForSeconds;

public class AccountSteps {
    AccountPage accountPage;

    public AccountSteps() {
        accountPage = new AccountPage();
    }

    public void validarEstarLogueado() throws InterruptedException {
        boolean found = false;
        do {
            try {
                accountPage.validateSubstringInCurrentUrl("account", 1);
                assertEquals(accountPage.getTextTittle(), "Cuenta");
                found = true;
            } catch (NoSuchElementException e) {
                try {
                    clickByText("Iniciar sesión");
                    waitForSeconds(1);
                } catch (NoSuchElementException ignored) {
                    accountPage.validateSubstringInCurrentUrl("account", 1);
                    assertEquals(accountPage.getTextTittle(), "Cuenta");
                    found = true;
                }
            }
        } while (!found);
    }
}
