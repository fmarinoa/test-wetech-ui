package hook;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static util.UserAgentGenerator.getRandomUserAgent;

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(getChromeOptions()); // Crea la instancia del ChromeDriver
            driver.manage().deleteAllCookies(); // Borra todas las cookies
            driver.navigate().refresh(); // Refresca la página
        }
        return driver;
    }


    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--user-agent=" + getRandomUserAgent());
        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        return options;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @Before(order = 0)
    public void setUp() {
        getDriver().manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        DriverManager.scenario = scenario;
    }

    @AfterAll
    public static void tearDown() {
        quitDriver();
    }

    public static void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(evidencia, "image/png", "evidencias");
    }
}
