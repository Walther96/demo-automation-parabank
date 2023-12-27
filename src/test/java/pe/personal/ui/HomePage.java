package pe.personal.ui;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pe.personal.utils.TimerManager;

public class HomePage extends PageObject {

    @FindBy(className = "logo")
    private WebElement logo;

    @FindBy(linkText = "Register")
    private WebElement linkRegister;

    public void isLogoDisplayed(){
        logo.isDisplayed();
        TimerManager.waitTime(2);
    }
    public void pressRegisterLink(){
        linkRegister.click();
    }

}