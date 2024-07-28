package step;

import page.ProductPage;


public class ProductSteps {
    private double price;
    ProductPage productPage;

    public ProductSteps() {
        productPage = new ProductPage();
    }

    public double getCurrentPrice() throws InterruptedException {
        String priceText = productPage.getPrice();
        String cleanPriceText = priceText.replace("S/.", "").replace(",", "").trim();
        return Double.parseDouble(cleanPriceText);
    }

    public void setPrice(double currentPrice) {
        price = currentPrice;
    }

    public double getPrice() {
        return price;
    }

    public void addProducts(Integer quantity) throws InterruptedException {
        if (quantity == 1) {
            return;
        }
        while (quantity > productPage.getQuantity()) {
            productPage.clickBtnPlus();
            if ((quantity == productPage.getQuantity())) {
                return;
            }
        }
    }

    public void clickShoppingCart() throws InterruptedException {
        productPage.clickShoppingCart();
    }

}
