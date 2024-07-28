package util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PressKeys {

    public static void pressEsc() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("Presioné escape");
    }
}
