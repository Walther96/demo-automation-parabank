package pe.personal.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{

    @FindBy(name = "username")
    public WebElementFacade txtUsername;

    @FindBy(name = "password")
    public WebElementFacade txtPassword;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    public WebElementFacade btnLogIn;

}
