package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {
    private static By tittle = By.xpath("//h1[@class='customer__title']");

    public String getTextTittle() throws InterruptedException {
        WebElement element = findElementWithRetries(tittle, 5);
        return getText(element);
    }
}
