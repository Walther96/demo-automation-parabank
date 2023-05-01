package pe.personal.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageObject{

    @FindBy(tagName = "h1")
    public WebElementFacade titlePage;

    @FindBy(id = "customer.firstName")
    public WebElementFacade txtFirstName;

    @FindBy(id = "customer.lastName")
    public WebElementFacade txtLastName;

    @FindBy(id = "customer.address.street")
    public WebElementFacade txtAddressStreet;

    @FindBy(id = "customer.address.city")
    public WebElementFacade txtAddressCity;

    @FindBy(id = "customer.address.state")
    public WebElementFacade txtAddressState;

    @FindBy(id = "customer.address.zipCode")
    public WebElementFacade txtAddressZipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElementFacade txtPhone;

    @FindBy(id = "customer.ssn")
    public WebElementFacade txtSSN;

    @FindBy(id = "customer.username")
    public WebElementFacade txtUsername;

    @FindBy(id = "customer.password")
    public WebElementFacade txtPassword;

    @FindBy(id = "repeatedPassword")
    public WebElementFacade txtRepeatPassword;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElementFacade btnRegister;

    @FindBy(className = "title")
    public WebElementFacade lblWelcomeTitle;

    @FindBy(xpath = "//*[@id='rightPanel']/p")
    public WebElementFacade lblMessageAccountCreated;

    @FindBy(id = "repeatedPassword.errors")
    public WebElementFacade lblPasswordErrorMessage;

    @FindBy(linkText = "Log Out")
    public WebElementFacade linkLogOut;

    public void typeFirstName(String firstName){
        txtFirstName.click();
        txtFirstName.type(firstName);
    }
    public void typeLastName(String lastName){
        txtLastName.click();
        txtLastName.type(lastName);
    }
    public void typeAddressStreet(String addressStreet){
        txtAddressStreet.click();
        txtAddressStreet.type(addressStreet);
    }
    public void typeAddressCity(String addressCity){
        txtAddressCity.click();
        txtAddressCity.type(addressCity);
    }
    public void typeAddressState(String addressState){
        txtAddressState.click();
        txtAddressState.type(addressState);
    }
    public void typeAddressZipCode(String addressZipCode){
        txtAddressZipCode.click();
        txtAddressZipCode.type(addressZipCode);
    }
    public void typePhone(String phone){
        txtPhone.click();
        txtPhone.type(phone);
    }
    public void typeSSN(String ssn){
        txtSSN.click();
        txtSSN.type(ssn);
    }

    public void typeUsername(String username){
        txtUsername.click();
        txtUsername.type(username);
    }
    public void typePassword(String password){
        txtPassword.click();
        txtPassword.type(password);
    }
    public void typeRepeatPassword(String password){
        txtRepeatPassword.click();
        txtRepeatPassword.type(password);
    }
    public void pressButtonRegister(){
        btnRegister.click();
    }

}