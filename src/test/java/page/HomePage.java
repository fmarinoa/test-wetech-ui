package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static By btnLogin = By.xpath("//header/div[1]/a[1]");
    private static By carrusel = By.xpath("(//slideshow-component)[1]");

    public void abrirWeTech() {
        goTo("https://weworktechnologyeirl.com/");
    }

    public void esperarCarrusel() throws InterruptedException {
        WebElement element = findElementWithRetries(carrusel, 5);
        if (waitWebElementIsDisplayed(element, 5)) {
            System.out.println("Carrusel encontrado");
        }
    }

    public void clickLogin() throws InterruptedException {
        WebElement element = findElementWithRetries(btnLogin, 5);
        if (waitWebElementIsEnabled(element, 5)) {
            click(element);
            System.out.println("Clik en el Login");
        }
    }
}
