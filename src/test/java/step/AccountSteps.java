package step;

import page.AccountPage;

import static org.junit.Assert.assertEquals;

public class AccountSteps {
    AccountPage accountPage;

    public AccountSteps() {
        accountPage = new AccountPage();
    }
    public void validarEstarLogueado() throws InterruptedException {
        accountPage.validateSubstringInCurrentUrl("account", 5);
        assertEquals(accountPage.getTextTittle(),"Cuenta");
    }
}
