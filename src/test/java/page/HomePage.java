package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private static By btnLogin = By.xpath("//header/div[1]/a[1]");
    private static By carrusel = By.xpath("(//slideshow-component)[1]");
    private static By btnBusqueda = By.xpath("//summary[@role='button' and @aria-label='Búsqueda']");
    private static By btnBusqueda2 = By.xpath("//button[@aria-label='Búsqueda']");
    private static By txtBusqueda = By.xpath("//input[@id='Search-In-Modal']");

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
            System.out.println("Click en el Login");
        }
    }

    public void clickBusqueda() throws InterruptedException {
        WebElement element = findElementWithRetries(btnBusqueda, 5);
        if (waitWebElementIsEnabled(element, 5)) {
            click(element);
            System.out.println("Click en la lupa de busqueda");
        }
    }

    public void clickBusqueda2() throws InterruptedException {
        WebElement element = findElementWithRetries(btnBusqueda2, 5);
        if (waitWebElementIsEnabled(element, 5)) {
            click(element);
            System.out.println("Click en la lupa de busqueda");
        }
    }

    public void escribirProducto(String arg0) throws InterruptedException {
        WebElement element = findElementWithRetries(txtBusqueda, 5);
        sendKeys(element, arg0);
        System.out.println("Escribí " + arg0);
    }


}
