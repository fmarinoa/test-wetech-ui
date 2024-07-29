package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private static By priceRegular = By.xpath("(//div[@class='price__regular']//span)[2]");
    private static By priceSale = By.xpath("(//div[@class='price__sale']//span)[4]");
    private static By btnPlusProduct = By.xpath("//button[@name='plus' and @type='button']");
    private static By quantity = By.xpath("//input[@type='number' and @name='quantity']");
    private static By btnShoppingCart = By.xpath("//button[.//*[contains(text(),'Agregar al carrito')]]");

    public String getPrice() throws InterruptedException {
        WebElement price_regular = findElementWithRetries(priceRegular, 5);
        String price = getText(price_regular);
        if (price.isEmpty()) {
            WebElement price_sale = findElementWithRetries(priceSale, 5);
            price = getText(price_sale);
        }
        return price;
    }

    public int getQuantity() throws InterruptedException {
        WebElement element = findElementWithRetries(quantity, 5);
        return Integer.parseInt(getInputValue(element));
    }

    public void clickBtnPlus() throws InterruptedException {
        WebElement element = findElementWithRetries(btnPlusProduct, 5);
        click(element);
    }

    public void clickShoppingCart() throws InterruptedException {
        WebElement element = findElementWithRetries(btnShoppingCart, 5);
        click(element);
    }
}
