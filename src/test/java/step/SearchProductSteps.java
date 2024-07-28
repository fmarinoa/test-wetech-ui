package step;


import page.SearchProductPage;

public class SearchProductSteps {
    SearchProductPage searchProductPage;

    public SearchProductSteps() {
        searchProductPage = new SearchProductPage();
    }

    public void seleccionarProducto(String arg0) throws InterruptedException {
        searchProductPage.findProduct(arg0);
        searchProductPage.clickProduct(arg0);
    }

    public double getCurrentPrice() throws InterruptedException {
        String priceText = searchProductPage.getPrice();
        String cleanPriceText = priceText.replace("S/.", "").replace(",", "").trim();
        return Double.parseDouble(cleanPriceText);
    }
}
