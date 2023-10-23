package pe.personal.ui;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static pe.personal.utils.TimerManager.waitTime;

public class AccountPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/div/input")
    private WebElement btnOpenNewAccount;

    @FindBy(tagName = "h1")
    private WebElement lblAccountOpened;

    @FindBy(id = "newAccountId")
    private WebElement lblAccountCreated;

    public void pressOpenNewAccountButton(){
        btnOpenNewAccount.isDisplayed();
        btnOpenNewAccount.click();
        waitTime(2);
    }
    public String getAccountOpenedMessage(){
        return lblAccountOpened.getText().trim();
    }
    public String getAccountCreateMessage(){
        return lblAccountCreated.getText().trim();
    }

}
