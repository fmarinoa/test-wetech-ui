package step;

import org.junit.Assert;
import page.ShoppingCartPage;

import static step.ProductSteps.getQuantity;

public class ShoppingCartSteps {
    ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps() {
        shoppingCartPage = new ShoppingCartPage();
    }

    public void validateInShoppingCart() throws InterruptedException {
        shoppingCartPage.validateTittle();
    }

    public double getExpectedPrice(double unitPrice) {
        int quantity = getQuantity();
        return unitPrice * quantity;
    }

    public void validatePriceTotal(double unitPrice) throws InterruptedException {
        double expectedPrice = getExpectedPrice(unitPrice);
        double actualPrice = shoppingCartPage.getPriceTotal();
        Assert.assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    public void validatePriceTotalEstimated(double unitPrice) throws InterruptedException {
        double expectedPrice = getExpectedPrice(unitPrice);
        double actualPrice = shoppingCartPage.getPriceTotalEstimated();
        Assert.assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}
