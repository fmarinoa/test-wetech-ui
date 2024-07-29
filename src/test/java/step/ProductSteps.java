package step;

import page.ProductPage;


public class ProductSteps {
    private static double unitPice;
    private static int quantity;
    ProductPage productPage;

    public ProductSteps() {
        productPage = new ProductPage();
    }

    public double getCurrentPrice() throws InterruptedException {
        String priceText = productPage.getPrice();
        String cleanPriceText = priceText.replace("S/.", "").replace(",", "").trim();
        return Double.parseDouble(cleanPriceText);
    }

    public void setUnitPrice(double currentPrice) {
        unitPice = currentPrice;
    }

        public static double getUnitPrice() {
        return unitPice;
    }

    public void setQuantity(int expectedQuantity) {
        quantity = expectedQuantity;
    }

    public static int getQuantity() {
        return quantity;
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
