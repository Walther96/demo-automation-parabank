package pe.personal.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/div/input")
    public WebElementFacade btnOpenNewAccount;

    @FindBy(tagName = "h1")
    public WebElementFacade lblAccountOpened;

}
