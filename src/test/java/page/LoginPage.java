package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static By tittle = By.xpath("//h1[@id='login']");
    private static By txtCorreo = By.xpath("//input[@id='CustomerEmail']");
    private static By txtPassword = By.xpath("//input[@id='CustomerPassword']");

    public void validarEstarEnLogin(int count) throws InterruptedException {
        WebElement element = findElementWithRetries(tittle, count);
        waitWebElementIsDisplayed(element, count);
        System.out.println("Me encuentro en Login");
    }

    public void sendCorreo(String arg0) throws InterruptedException {
        WebElement element = findElementWithRetries(txtCorreo, 5);
        if (waitWebElementIsEnabled(element, 5)) {
            sendKeys(element, arg0);
        }
    }

    public String getValueCorreo() throws InterruptedException {
        WebElement element = findElementWithRetries(txtCorreo, 5);
        return getInputValue(element);
    }

    public void sendPassword(String arg0) throws InterruptedException {
        WebElement element = findElementWithRetries(txtPassword, 5);
        if (waitWebElementIsEnabled(element, 5)) {
            sendKeys(element, arg0);
        }
    }

    public String getValuePassword() throws InterruptedException {
        WebElement element = findElementWithRetries(txtPassword, 5);
        return getInputValue(element);
    }
}
