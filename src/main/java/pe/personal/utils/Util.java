package pe.personal.utils;

import org.openqa.selenium.JavascriptExecutor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Util {
    public static void waitTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollDown(String number) {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,"+number+")");
    }

}