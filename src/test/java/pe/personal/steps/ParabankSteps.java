package pe.personal.steps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.personal.constants.KeysConstants;
import pe.personal.constants.ModuleConstants;
import pe.personal.ui.*;
import pe.personal.utils.*;

import java.util.List;
import java.util.Map;

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
        passwordUser1 = FileManager.getInstance().getProperties(KeysConstants.PASSWORD_USER1);
        passwordUser2 = FileManager.getInstance().getProperties(KeysConstants.PASSWORD_USER2);
    }

    @Step
    @Screenshots(afterEachStep = true)
    public void openParabankPage() {
        LOGGER.info("url: "+KeysConstants.URL_PARABANK);
        homePage.openUrl(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(KeysConstants.URL_PARABANK));
        homePage.isLogoDisplayed();
        setValuesDecrypted();
    }
    @Step
    public void goToRegisterOption(){
        homePage.pressRegisterLink();
        registerPage.isTitleDisplayed();
        Assert.assertEquals(ModuleConstants.LABEL_SIGN_UP, registerPage.getPageTitle());
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
        NavigateManager.scrollDown(ModuleConstants.NUMBER_110);
        registerPage.typeUsername(RandomVarManager.generateRandomValues());
        tmpUserDecrypted = registerPage.getUsernameValue();
        FileManager.getInstance().propertiesHandlerEncoder(tmpUserDecrypted);
        registerPage.typePassword(passwordUser1);

        if(flow.equalsIgnoreCase(ModuleConstants.LABEL_CORRECT))
            registerPage.typeRepeatPassword(passwordUser1);
        if(flow.equalsIgnoreCase(ModuleConstants.LABEL_INCORRECT))
            registerPage.typeRepeatPassword(passwordUser2);

        registerPage.pressRegisterButton();
        NavigateManager.scrollDown(ModuleConstants.NUMBER_110);
    }

    @Step
    public void confirmAccountCreated(String message){
        registerPage.isWelcomeTitleDisplayed();
        Assert.assertEquals(ModuleConstants.LABEL_WELCOME+tmpUserDecrypted,registerPage.getWelcomeTitle());
        Assert.assertEquals(message, registerPage.getMessageAccountCreated());
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
            case ModuleConstants.MENU_OPEN_NEW_ACCOUNT:
                menuPage.pressOpenNewAccountLink();
                break;
            case ModuleConstants.MENU_ACCOUNTS_OVERVIEW:
                menuPage.pressAccountOverviewLink();
                break;
            case ModuleConstants.MENU_TRANSFER_FUNDS:
                menuPage.pressTransferFundsLink();
                break;
            case ModuleConstants.MENU_BILL_PAY:
                menuPage.pressBillPayLink();
                break;
            case ModuleConstants.MENU_FIND_TRANSACTIONS:
                menuPage.pressFindTransactionsLink();
                break;
            case ModuleConstants.MENU_UPDATE_CONTACT_INFO:
                menuPage.pressUpdateContactInfoLink();
            default:
                menuPage.pressRequestLoanLink();
        }
    }

    @Step
    public void opensAnAccount(String accountType){
        NavigateManager.selectItemFromCombobox(KeysConstants.VALUE_TYPE, accountType);
        NavigateManager.selectItemFromCombobox(KeysConstants.VALUE_ACCOUNT_ID, NavigateManager.getValueFromCombobox(KeysConstants.VALUE_ACCOUNT_ID));
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