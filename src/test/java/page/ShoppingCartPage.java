package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {
    private static By priceTotal = By.xpath("//span[@class='price price--end']");
    private static By priceTotalEstimated = By.xpath("//p[@class='totals__total-value']");
    private static By tittle = By.xpath("//h2[contains(text(),'Tu carrito')]");

    public double getPriceTotal() throws InterruptedException {
        WebElement element = findElementWithRetries(priceTotal, 5);
        String priceText = getText(element);
        String cleanPriceText = priceText.replace("S/.", "").replace(",", "").trim();
        return Double.parseDouble(cleanPriceText);
    }

    public double getPriceTotalEstimated() throws InterruptedException {
        WebElement element = findElementWithRetries(priceTotalEstimated, 5);
        String priceText = getText(element);
        String cleanPriceText = priceText.replace("S/.", "").replace(",", "").replace("PEN", "").trim();
        return Double.parseDouble(cleanPriceText);
    }

    public void validateTittle() throws InterruptedException {
        WebElement element = findElementWithRetries(tittle, 5);
        if (!waitWebElementIsEnabled(element, 5)){
            throw new AssertionError("Tu Carrito no apareció luego de 5 segundos");
        }
    }

}
