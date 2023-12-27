package pe.personal.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class NavigateManager {

    private NavigateManager(){}
    public static void scrollDown(int number) {
        ((JavascriptExecutor)net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver()).executeScript("window.scrollBy(0,"+number+")");
    }
    public static void selectItemFromCombobox(String locator, String option){
        Select select = new Select(net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver().findElement(By.id(locator)));
        select.selectByVisibleText(option);
    }

    public static String getValueFromCombobox(String locator){
        Select select = new Select(net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver().findElement(By.id(locator)));
        return select.getFirstSelectedOption().getText();
    }

}