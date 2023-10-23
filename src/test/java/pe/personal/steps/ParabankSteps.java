package pe.personal.steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.personal.ui.*;
import pe.personal.utils.Constants;
import pe.personal.utils.FileManager;

import java.util.List;
import java.util.Map;

import static pe.personal.utils.NavigateManager.*;
import static pe.personal.utils.RandomVarManager.generateRandomValues;

public class ParabankSteps {

    private EnvironmentVariables environmentVariables;

    private static String passwordUser1, passwordUser2, tmpUserDecrypted;

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MenuPage menuPage;
    AccountPage accountPage;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParabankSteps.class);

    public static void setValuesDecrypted(){
        FileManager.getInstance().getValuesDecrypted();
        passwordUser1 = FileManager.getInstance().getProperties(Constants.PASSWORD_USER1);
        passwordUser2 = FileManager.getInstance().getProperties(Constants.PASSWORD_USER2);
    }

    @Step
    @Screenshots(afterEachStep = true)
    public void openParabankPage(){
        homePage.openUrl(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("parabank.base.url"));
        homePage.isLogoDisplayed();
        setValuesDecrypted();
    }

    @Step
    public void goToRegisterOption(){
        homePage.pressRegisterLink();
        registerPage.isTitleDisplayed();
        Assert.assertEquals("Signing up is easy!",registerPage.getPageTitle());
    }

    @Step
    @Screenshots(afterEachStep = true)
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
    @Screenshots(afterEachStep = true)
    public void enterLoginInfo(String flow){
        scrollDown("110");
        registerPage.typeUsername(generateRandomValues());
        tmpUserDecrypted = registerPage.getUsernameValue();
        FileManager.getInstance().propertiesHandlerEncoder(tmpUserDecrypted);
        registerPage.typePassword(passwordUser1);

        if(flow.equalsIgnoreCase("CORRECT"))
            registerPage.typeRepeatPassword(passwordUser1);
        if(flow.equalsIgnoreCase("INCORRECT"))
            registerPage.typeRepeatPassword(passwordUser2);

        registerPage.pressRegisterButton();
        scrollDown("110");
    }

    @Step
    public void confirmAccountCreated(){
        registerPage.isWelcomeTitleDisplayed();
        Assert.assertEquals("Welcome "+tmpUserDecrypted,registerPage.getWelcomeTitle());
        Assert.assertEquals("Your account was created successfully. You are now logged in.",registerPage.getMessageAccountCreated());
        FileManager.getInstance().setValuesEncrypted(tmpUserDecrypted);
        registerPage.pressLogOutLink();
    }

    @Step
    public void shouldDisplayErrorMessage(String message){
        Assert.assertEquals(message,registerPage.getPasswordErrorMessage());
    }

    @Step
    public void entersUsernamePassword(){
        loginPage.typeUsername(FileManager.getInstance().readValueEncrypted());
        loginPage.typePassword(passwordUser1);
        loginPage.pressLoginButton();
    }

    @Step
    public void selectsLinkFromMenu(String option){
        switch (option) {
            case "Open New Account":
                menuPage.pressOpenNewAccountLink();
                break;
            case "Accounts Overview":
                menuPage.pressAccountOverviewLink();
                break;
            case "Transfer Funds":
                menuPage.pressTransferFundsLink();
                break;
            case "Bill Pay":
                menuPage.pressBillPayLink();
                break;
            case "Find Transactions":
                menuPage.pressFindTransactionsLink();
                break;
            case "Update Contact Info":
                menuPage.pressUpdateContactInfoLink();
            default:
                menuPage.pressRequestLoanLink();
        }
    }

    @Step
    public void opensAnAccount(String accountType){
        selectItemFromCombobox("type", accountType);
        selectItemFromCombobox("fromAccountId", getValueFromCombobox("fromAccountId"));
        accountPage.pressOpenNewAccountButton();
    }

    @Step
    public void shouldDisplay(String message){
        LOGGER.info(accountPage.getAccountOpenedMessage());
        LOGGER.info(accountPage.getAccountCreateMessage());
        Assert.assertEquals(message,accountPage.getAccountOpenedMessage());
        registerPage.pressLogOutLink();
    }

}