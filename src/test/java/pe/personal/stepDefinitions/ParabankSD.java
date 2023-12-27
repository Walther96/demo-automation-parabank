package pe.personal.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pe.personal.steps.ParabankSteps;

import java.net.MalformedURLException;

public class ParabankSD {

    @Steps
    ParabankSteps steps;

    @Given("the user opens PARABANK page")
    public void openParabankPage() {
        steps.openParabankPage();
    }
    @And("goes to the Register option")
    public void goToRegisterOption(){
        steps.goToRegisterOption();
    }
    @When("the user enters his personal information")
    public void enterPersonalInformation(DataTable table){
        steps.enterPersonalInformation(table);
    }
    @And("^enters his login info with (CORRECT|INCORRECT) values$")
    public void enterLoginInfo(String flow){
        steps.enterLoginInfo(flow);
    }
    @Then("confirms that his account has been created {string}")
    public void confirmAccountCreated(String message){
        steps.confirmAccountCreated(message);
    }
    @Then("should display a message {string}")
    public void shouldDisplayErrorMessage(String message){
        steps.shouldDisplayErrorMessage(message);
    }

    @When("enters the username and password")
    public void entersUsernamePassword(){
        steps.entersUsernamePassword();
    }
    @And("selects link {string}")
    public void selectsLinkFromMenu(String option){
        steps.selectsLinkFromMenu(option);
    }
    @And("opens an account {string} and selects account to transfer funds")
    public void opensAnAccount(String accountType){
        steps.opensAnAccount(accountType);
    }
    @Then("should display {string}")
    public void shouldDisplay(String var){
        steps.shouldDisplay(var);
    }

}
