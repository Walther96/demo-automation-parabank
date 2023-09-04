package pe.personal.steps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.personal.ui.*;

import java.util.List;
import java.util.Map;

import static pe.personal.utils.Util.*;

public class ParabankSteps {

    private EnvironmentVariables environmentVariables;

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MenuPage menuPage;
    AccountPage accountPage;

    String varUsername = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(ParabankSteps.class);

    @Step
    public void openParabankPage(){
        homePage.openUrl(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("parabank.base.url"));
        homePage.logo.isDisplayed();
        waitTime(3);
    }

    @Step
    public void goToRegisterOption(){
        homePage.linkRegister.click();
        registerPage.titlePage.isDisplayed();
        Assert.assertEquals("Signing up is easy!",registerPage.titlePage.getText().trim());
    }

    @Step
    public void enterPersonalInformation(DataTable table){
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        registerPage.typeFirstName(list.get(0).get("First name"));
        registerPage.typeLastName(list.get(0).get("Last name"));
        registerPage.typeAddressStreet(list.get(0).get("Address"));
        registerPage.typeAddressCity(list.get(0).get("City"));
        registerPage.typeAddressState(list.get(0).get("State"));
        registerPage.typeAddressZipCode(list.get(0).get("Zip code"));
        registerPage.typePhone(list.get(0).get("Phone"));
        registerPage.typeSSN(list.get(0).get("SSN"));
    }
    @Step
    public void enterLoginInfo(DataTable table){
        scrollDown("100");
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        Faker faker = Faker.instance();
        registerPage.typeUsername(faker.artist().name());
        varUsername = registerPage.txtUsername.getValue();
        registerPage.typePassword(list.get(0).get("Password"));
        registerPage.typeRepeatPassword(list.get(0).get("Repeat password"));
        registerPage.pressButtonRegister();
        scrollDown("100");
        waitTime(3);
    }

    @Step
    public void confirmAccountCreated(){
        registerPage.lblWelcomeTitle.isDisplayed();
        Assert.assertEquals("Welcome "+varUsername,registerPage.lblWelcomeTitle.getText().trim());
        Assert.assertEquals("Your account was created successfully. You are now logged in.",registerPage.lblMessageAccountCreated.getText().trim());
        registerPage.linkLogOut.click();
        waitTime(3);
    }

    @Step
    public void shouldDisplayErrorMessage(String message){
        Assert.assertEquals(message,registerPage.lblPasswordErrorMessage.getText());
    }

    @Step
    public void entersUsernamePassword(String user, String pass){
        loginPage.txtUsername.click();
        loginPage.txtUsername.type(user);
        loginPage.txtPassword.type(pass);
        loginPage.btnLogIn.click();
        waitTime(2);
    }

    @Step
    public void selectsLinkFromMenu(String option){
        switch (option) {
            case "Open New Account":
                menuPage.linkOpenNewAccount.click();
                break;
            case "Accounts Overview":
                menuPage.linkAccountsOverview.click();
                break;
            case "Transfer Funds":
                menuPage.linkTransferFunds.click();
                break;
            case "Bill Pay":
                menuPage.linkBillPay.click();
                break;
            case "Find Transactions":
                menuPage.linkFindTransactions.click();
                break;
            case "Update Contact Info":
                menuPage.linkUpdateContactInfo.click();
            default:
                menuPage.linkRequestLoan.click();
        }
        waitTime(2);
    }

    @Step
    public void opensAnAccount(String accountType, String amount){
        selectValueFromCombobox("type", accountType);
        selectValueFromCombobox("fromAccountId", amount);
        accountPage.btnOpenNewAccount.isDisplayed();
        accountPage.btnOpenNewAccount.click();
        waitTime(2);
    }

    @Step
    public void shouldDisplay(String message){
        LOGGER.info(accountPage.lblAccountOpened.getText());
        Assert.assertEquals(message,accountPage.lblAccountOpened.getText());
        registerPage.linkLogOut.click();
        waitTime(2);
    }

}