package pe.personal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class NavigateManager {

    public static void scrollDown(String number) {
        ((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,"+number+")");
    }
    public static void selectItemFromCombobox(String locator, String option){
        Select select = new Select(getDriver().findElement(By.id(locator)));
        select.selectByVisibleText(option);
    }

    public static String getValueFromCombobox(String locator){
        Select select = new Select(getDriver().findElement(By.id(locator)));

        return select.getFirstSelectedOption().getText();
    }

}