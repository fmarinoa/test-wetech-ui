package page;

import hook.DriverManager;
import org.openqa.selenium.*;

public class BasePage extends DriverManager {

    private static final WebDriver driver = getDriver();


    public void goTo(String url) {
        driver.get(url);
    }

    public static void waitForSeconds(int seconds) throws InterruptedException {
        long millis = seconds * 1000L;
        Thread.sleep(millis);
    }

    public static WebElement findElementWithRetries(By locator, int countMax) throws InterruptedException {
        int count = 0;
        while (count < countMax) {
            try {
                return driver.findElement(locator);
            } catch (NoSuchElementException ignored) {
                System.out.println("Elemento no encontrado en el intento " + (count + 1) + ", reintentando...");
                waitForSeconds(1); // Pausar por 1 segundo antes de reintentar
                count++;
            }
        }
        throw new NoSuchElementException("El elemento no fue encontrado después de " + countMax + " intentos.");
    }

    public static boolean waitWebElementIsDisplayed(WebElement element, int countMax) throws InterruptedException {
        int count = 0;
        while (count < countMax) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Elemento no disponible (stale) en el intento " + (count + 1) + ", reintentando...");
            }
            System.out.println("Elemento no encontrado en el intento " + (count + 1) + ", reintentando...");
            waitForSeconds(1); // Pausar por 1 segundo antes de reintentar
            count++;
        }
        return false;
    }

    public static boolean waitWebElementIsEnabled(WebElement element, int countMax) throws InterruptedException {
        int count = 0;
        while (count < countMax) {
            try {
                if (element.isEnabled()) {
                    return true;
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Elemento no disponible (stale) en el intento " + (count + 1) + ", reintentando...");
            }
            System.out.println("Elemento no habilitado en el intento " + (count + 1) + ", reintentando...");
            waitForSeconds(1); // Pausar por 1 segundo antes de reintentar
            count++;
        }
        return false;
    }

    public static void click(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String arg0) {
        element.sendKeys(arg0);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getInputValue(WebElement element) {
        return element.getAttribute("value");
    }

    public static void clickByText(String text) throws InterruptedException {
        boolean found = true;
        do {
            try {
                WebElement element = findElementWithRetries(By.xpath("//button[contains(text(),'" + text + "')]"), 5);
                waitWebElementIsEnabled(element, 5);
                click(element);

                // Esperar un segundo antes de verificar si el elemento sigue presente
                waitForSeconds(1);

                // Verificar si el elemento sigue presente
                if (!waitWebElementIsDisplayed(element, 1)) {
                    found = false; // Salir del bucle si el elemento ya no está presente
                }
            } catch (NoSuchElementException e) {
                System.out.println("Elemento no encontrado o ya no está presente.");
                found = false; // Salir del bucle si el elemento ya no está presente o no se encontró
            }
        } while (found);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void validateSubstringInCurrentUrl(String expectedSubstring, int countMax) throws AssertionError, InterruptedException {
        int count = 0;
        boolean found = false;

        while (count < countMax) {
            String actualText = getUrl(); // Obtener el texto actualizado en cada intento

            if (actualText.contains(expectedSubstring)) {
                found = true;
                break; // Sale del bucle si la subcadena es encontrada
            } else {
                System.out.println("El texto: " + actualText + " no contiene " + expectedSubstring + ". Reintentando...");
                count++;
                waitForSeconds(1); // Pausa antes de reintentar
            }
        }
        if (!found) {
            throw new AssertionError("Los textos no coincidieron luego de " + countMax + " intentos.");
        }
    }

    public static void validateText(String text) throws InterruptedException {
        WebElement element = findElementWithRetries(By.xpath("//*[contains(text(),'" + text + "')]"), 5);
        waitWebElementIsDisplayed(element, 5);
    }
}