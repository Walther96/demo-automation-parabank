package pe.personal.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pe.personal.steps.ParabankSteps;

public class ParabankSD {

    @Steps
    ParabankSteps steps;

    @Given("the user opens PARABANK page")
    public void openParabankPage(){
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
    @And("enters his login info")
    public void enterLoginInfo(DataTable table){
        steps.enterLoginInfo(table);
    }
    @Then("confirms that his account has been created")
    public void confirmAccountCreated(){
        steps.confirmAccountCreated();
    }
    @Then("should display a message {string}")
    public void shouldDisplayErrorMessage(String message){
        steps.shouldDisplayErrorMessage(message);
    }


}
