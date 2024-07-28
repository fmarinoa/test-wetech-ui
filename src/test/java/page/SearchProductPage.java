package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static util.Scroller.scrollByDown;

public class SearchProductPage extends BasePage {

    private static By priceRegular = By.xpath("(//div[@class='price__regular']//span)[2]");
    private static By priceSale = By.xpath("(//div[@class='price__sale']//span)[4]");


    public WebElement returnElmentProduct(String arg0) throws InterruptedException {
        String xPath = "//h3[@class='card__heading h5']//a[contains(text(),'" + arg0 + "')]";
        return findElementWithRetries(By.xpath(xPath), 5);
    }

    public void findProduct(String arg0) throws InterruptedException {
        WebElement product = returnElmentProduct(arg0);
        int attempt = 0;
        while (!isElementVisibleAndEnabled(product) && attempt <= 5) {
            scrollByDown(300);
            waitForSeconds(1);
            attempt++;
        }
    }

    public void clickProduct(String arg0) throws InterruptedException {
        WebElement product = returnElmentProduct(arg0);
        boolean found = true;
        do {
            try {
                waitWebElementIsEnabled(product, 5);
                click(product);

                // Esperar un segundo antes de verificar si el elemento sigue presente
                waitForSeconds(1);

                // Verificar si el elemento sigue presente
                if (!waitWebElementIsDisplayed(product, 1)) {
                    found = false; // Salir del bucle si el elemento ya no está presente
                }
            } catch (NoSuchElementException e) {
                System.out.println("Elemento no encontrado o ya no está presente.");
                found = false; // Salir del bucle si el elemento ya no está presente o no se encontró
            }
        } while (found);
    }

    public String getPrice() throws InterruptedException {
        WebElement priceRegular = findElementWithRetries(SearchProductPage.priceRegular, 5);
        String price = getText(priceRegular);
        if (price.isEmpty()) {
            WebElement priceSale = findElementWithRetries(SearchProductPage.priceSale, 5);
            price = getText(priceSale);
        }
        return price;
    }
}
