package hook;

import java.util.Random;

public class UserAgentGenerator {

    private static final String[] BROWSERS = {"Chrome", "Firefox", "Safari", "Edge"};
    private static final String[] OS_SYSTEMS = {
            "Windows NT 10.0",
            "Macintosh; Intel Mac OS X 10_15_7",
            "Linux; Android 11",
            "iPhone; CPU iPhone OS 14_6 like Mac OS X"
    };

    public static String getRandomUserAgent() {
        Random random = new Random();
        String browser = BROWSERS[random.nextInt(BROWSERS.length)];
        String osSystem = OS_SYSTEMS[random.nextInt(OS_SYSTEMS.length)];
        int version = random.nextInt(100) + 1; // Versión aleatoria entre 1 y 100

        // Construir el User-Agent con más detalles
        String newUserAgent = String.format(
                "%s/%d.0 (%s; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) %s/%d.0 Chrome/91.0.4472.124 Safari/537.36",
                browser, version, osSystem, browser, version
        );
        System.out.println("Nuevo user-agent: " + newUserAgent);
        return newUserAgent;
    }

}
