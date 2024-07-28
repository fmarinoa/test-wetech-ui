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
}
