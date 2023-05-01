package pe.personal.ui;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageObject {

    @FindBy(linkText = "Open New Account")
    public WebElementFacade linkOpenNewAccount;

    @FindBy(linkText = "Accounts Overview")
    public WebElementFacade linkAccountsOverview;

    @FindBy(linkText = "Transfer Funds")
    public WebElementFacade linkTransferFunds;

    @FindBy(linkText = "Bill Pay")
    public WebElementFacade linkBillPay;

    @FindBy(linkText = "Find Transactions")
    public WebElementFacade linkFindTransactions;

    @FindBy(linkText = "Update Contact Info")
    public WebElementFacade linkUpdateContactInfo;

    @FindBy(linkText = "Request Loan")
    public WebElementFacade linkRequestLoan;

}