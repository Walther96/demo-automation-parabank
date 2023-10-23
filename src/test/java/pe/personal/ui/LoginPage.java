package pe.personal.ui;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static pe.personal.utils.TimerManager.waitTime;

public class LoginPage extends PageObject{

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/form/div[3]/input")
    private WebElement btnLogIn;

    public void typeUsername(String user){
        txtUsername.sendKeys(user);
    }
    public void typePassword(String pass){
        txtPassword.sendKeys(pass);
    }
    public void pressLoginButton(){
        btnLogIn.click();
        waitTime(2);
    }

}
