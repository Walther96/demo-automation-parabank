package pe.personal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

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
    public static void selectValueFromCombobox(String locator, String var){
        Select select = new Select(getDriver().findElement(By.id(locator)));
        select.selectByVisibleText(var);
    }

}