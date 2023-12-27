package pe.personal.ui;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pe.personal.constants.KeysConstants;
import pe.personal.utils.TimerManager;

public class RegisterPage extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement titlePage;

    @FindBy(id = "customer.firstName")
    private WebElement txtFirstName;

    @FindBy(id = "customer.lastName")
    private WebElement txtLastName;

    @FindBy(id = "customer.address.street")
    private WebElement txtAddressStreet;

    @FindBy(id = "customer.address.city")
    private WebElement txtAddressCity;

    @FindBy(id = "customer.address.state")
    private WebElement txtAddressState;

    @FindBy(id = "customer.address.zipCode")
    private WebElement txtAddressZipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement txtPhone;

    @FindBy(id = "customer.ssn")
    private WebElement txtSSN;

    @FindBy(id = "customer.username")
    private WebElement txtUsername;

    @FindBy(id = "customer.password")
    private WebElement txtPassword;

    @FindBy(id = "repeatedPassword")
    private WebElement txtRepeatPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement btnRegister;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/h1")
    private WebElement lblWelcomeTitle;

    @FindBy(xpath = "//*[@id='rightPanel']/p")
    private WebElement lblMessageAccountCreated;

    @FindBy(id = "repeatedPassword.errors")
    private WebElement lblPasswordErrorMessage;

    @FindBy(linkText = "Log Out")
    private WebElement linkLogOut;

    public void isTitleDisplayed(){
        titlePage.isDisplayed();
    }
    public String getPageTitle(){
        return titlePage.getText().trim();
    }
    public void pressLogOutLink(){
        linkLogOut.click();
        TimerManager.waitTime(1);
    }
    public String getUsernameValue(){
        return txtUsername.getAttribute(KeysConstants.VALUE_VALUE);
    }
    public void isWelcomeTitleDisplayed(){
        TimerManager.waitTime(1);
        lblWelcomeTitle.isDisplayed();
    }
    public String getWelcomeTitle(){
        return lblWelcomeTitle.getText().trim();
    }
    public String getMessageAccountCreated(){
        return lblMessageAccountCreated.getText().trim();
    }
    public String getPasswordErrorMessage(){
        return lblPasswordErrorMessage.getText().trim();
    }
    public void typeFirstName(String firstName){
        txtFirstName.click();
        txtFirstName.sendKeys(firstName);
    }
    public void typeLastName(String lastName){
        txtLastName.click();
        txtLastName.sendKeys(lastName);
    }
    public void typeAddressStreet(String addressStreet){
        txtAddressStreet.click();
        txtAddressStreet.sendKeys(addressStreet);
    }
    public void typeAddressCity(String addressCity){
        txtAddressCity.click();
        txtAddressCity.sendKeys(addressCity);
    }
    public void typeAddressState(String addressState){
        txtAddressState.click();
        txtAddressState.sendKeys(addressState);
    }
    public void typeAddressZipCode(String addressZipCode){
        txtAddressZipCode.click();
        txtAddressZipCode.sendKeys(addressZipCode);
    }
    public void typePhone(String phone){
        txtPhone.click();
        txtPhone.sendKeys(phone);
    }
    public void typeSSN(String ssn){
        txtSSN.click();
        txtSSN.sendKeys(ssn);
        TimerManager.waitTime(1);
    }
    public void typeUsername(String username){
        txtUsername.click();
        txtUsername.sendKeys(username);
    }
    public void typePassword(String password){
        txtPassword.click();
        txtPassword.sendKeys(password);
    }
    public void typeRepeatPassword(String password){
        txtRepeatPassword.click();
        txtRepeatPassword.sendKeys(password);
    }
    public void pressRegisterButton(){
        TimerManager.waitTime(1);
        btnRegister.click();
    }

}