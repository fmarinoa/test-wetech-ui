package step;

import page.LoginPage;

import static org.junit.Assert.assertEquals;


public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    public void sendCorreo(String arg0) throws InterruptedException {
        loginPage.sendCorreo(arg0);
        assertEquals(arg0, loginPage.getValueCorreo());
        System.out.println("Escribí el correo: " + arg0);
    }

    public void sendPassword(String arg0) throws InterruptedException {
        loginPage.sendPassword(arg0);
        assertEquals(arg0, loginPage.getValuePassword());
        System.out.println("Escribí la contraseña: " + arg0);
    }

}
