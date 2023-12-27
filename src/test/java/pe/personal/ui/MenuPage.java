package pe.personal.ui;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pe.personal.utils.TimerManager;

public class MenuPage extends PageObject {

    @FindBy(linkText = "Open New Account")
    private WebElement linkOpenNewAccount;

    @FindBy(linkText = "Accounts Overview")
    private WebElement linkAccountsOverview;

    @FindBy(linkText = "Transfer Funds")
    private WebElement linkTransferFunds;

    @FindBy(linkText = "Bill Pay")
    private WebElement linkBillPay;

    @FindBy(linkText = "Find Transactions")
    private WebElement linkFindTransactions;

    @FindBy(linkText = "Update Contact Info")
    private WebElement linkUpdateContactInfo;

    @FindBy(linkText = "Request Loan")
    private WebElement linkRequestLoan;

    public void pressOpenNewAccountLink(){
        linkOpenNewAccount.isDisplayed();
        linkOpenNewAccount.click();
        TimerManager.waitTime(2);
    }
    public void pressAccountOverviewLink(){
        linkAccountsOverview.isDisplayed();
        linkAccountsOverview.click();
    }
    public void pressTransferFundsLink(){
        linkTransferFunds.isDisplayed();
        linkTransferFunds.click();
    }
    public void pressBillPayLink(){
        linkBillPay.isDisplayed();
        linkBillPay.click();
    }
    public void pressFindTransactionsLink(){
        linkFindTransactions.isDisplayed();
        linkFindTransactions.click();
    }
    public void pressUpdateContactInfoLink(){
        linkUpdateContactInfo.isDisplayed();
        linkUpdateContactInfo.click();
    }
    public void pressRequestLoanLink(){
        linkRequestLoan.isDisplayed();
        linkRequestLoan.click();
    }

}