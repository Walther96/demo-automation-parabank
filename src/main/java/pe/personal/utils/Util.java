package pe.personal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static void waitTime(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LOGGER.warn(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
    public static void scrollDown(String number) {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,"+number+")");
    }
    public static void selectValueFromCombobox(String locator, String option){
        Select select = new Select(getDriver().findElement(By.id(locator)));
        select.selectByVisibleText(option);
    }

}