package pe.personal.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(className = "logo")
    public WebElementFacade logo;

    @FindBy(linkText = "Register")
    public WebElementFacade linkRegister;

}