package util;

import org.openqa.selenium.JavascriptExecutor;

import static hook.DriverManager.getDriver;

public class Scroller {

    public static void scrollByDown(int distance) {
        // Construir el script JavaScript con el valor de desplazamiento
        String script = "window.scrollBy({ top: " + distance + ", left: 0, behavior: 'smooth' });";

        // Ejecutar el script JavaScript
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(script);
    }
}
