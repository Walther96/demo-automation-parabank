package pe.personal.steps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import pe.personal.ui.*;

import java.util.List;
import java.util.Map;

import static pe.personal.utils.Util.scrollDown;
import static pe.personal.utils.Util.waitTime;

public class ParabankSteps {

    private EnvironmentVariables environmentVariables;

    HomePage homePage;
    RegisterPage registerPage;

    String varUsername = "";

    @Step
    public void openParabankPage(){
        homePage.openUrl(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("parabank.base.url"));
        homePage.logo.isDisplayed();
        Serenity.takeScreenshot();
        waitTime(3);
    }

    @Step
    public void goToRegisterOption(){
        homePage.linkRegister.click();
        registerPage.titlePage.isDisplayed();
        Assert.assertEquals("Signing up is easy!",registerPage.titlePage.getText().trim());
    }

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
        Serenity.takeScreenshot();
    }
    public void enterLoginInfo(DataTable table){
        scrollDown("100");
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        Faker faker = Faker.instance();
        registerPage.typeUsername(faker.artist().name());
        varUsername = registerPage.txtUsername.getValue();
        registerPage.typePassword(list.get(0).get("Password"));
        registerPage.typeRepeatPassword(list.get(0).get("Repeat password"));
        Serenity.takeScreenshot();
        registerPage.pressButtonRegister();
        scrollDown("100");
        waitTime(3);
    }
    public void confirmAccountCreated(){
        registerPage.lblWelcomeTitle.isDisplayed();
        Assert.assertEquals("Welcome "+varUsername,registerPage.lblWelcomeTitle.getText().trim());
        Assert.assertEquals("Your account was created successfully. You are now logged in.",registerPage.lblMessageAccountCreated.getText().trim());
        Serenity.takeScreenshot();
        registerPage.linkLogOut.click();
        waitTime(3);
    }
    public void shouldDisplayErrorMessage(String message){
        Serenity.takeScreenshot();
        Assert.assertEquals(message,registerPage.lblPasswordErrorMessage.getText());
    }

}