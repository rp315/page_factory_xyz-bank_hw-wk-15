package com.bank.testsuite;

import com.bank.basepage.BasePage;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import com.bank.utility.Utility;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class BankTest extends TestBase {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    SoftAssert softAssert;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        softAssert = new SoftAssert();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        bankManagerLoginPage.clickOnAddCustommerButton();
        addCustomerPage.sendingTextToFirstNameField("julian");
        addCustomerPage.sendingTextToLastNameField("campbell");
        addCustomerPage.sendingTextToPostCodeField("w25 2rg");
        addCustomerPage.clickOnAddCustomerButton();
        Thread.sleep(4000);
        String expectedAlertMessage = "Customer added successfully with customer id :6";
        String actualAlertMessage = addCustomerPage.gettingTextFromAlertMessage();
        softAssert.assertEquals(expectedAlertMessage,actualAlertMessage);
        softAssert.assertAll();
        Thread.sleep(2000);
        addCustomerPage.clickOnAlertMessage();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        this.bankManagerShouldAddCustomerSuccessfully();
        bankManagerLoginPage.clickOnOpenAccountButton();
        openAccountPage.selectOnDrowpDownList("6");
        openAccountPage.selectCurrencyFromDropDownList("Pound");
        Thread.sleep(1000);
        openAccountPage.clickOnProcessButton();
        String expectedAlertMessage = "Account created successfully with account Number :1016";
        String actualAlertMessage = openAccountPage.gettingTextFromAlertMessage();
        softAssert.assertEquals(expectedAlertMessage,actualAlertMessage);
        softAssert.assertAll();
        openAccountPage.clickOnAlertMessage();
    }


    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        this.bankManagerShouldAddCustomerSuccessfully();
        homePage.clickonhomebutton();
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerFromDropDownList("6");
        customersPage.clickOnLoginButton();
        Thread.sleep(1000);
        String expectedLogOutText = "Logout";
        String actualLogOutText = customersPage.verifyTextLogOut();
        softAssert.assertEquals(expectedLogOutText,actualLogOutText);
        softAssert.assertAll();
        accountPage.clickOnLogoutButton();
        String expectedCustomerName = "Your Name :";
        String actualCustomerName = customersPage.verifyTextYourName();
        softAssert.assertEquals(expectedCustomerName,actualCustomerName);
        softAssert.assertAll();

    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        this.bankManagerShouldOpenAccountSuccessfully();
        homePage.clickonhomebutton();
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerFromDropDownList("5");
        customersPage.clickOnLoginButton();
        accountPage.clickOnDepositButton();
        accountPage.enterTheAmountOnDepositField("100");
        accountPage.clickOnDepositButtonAfterAmountSelected();
        String expectedDepositMessage = "Deposit Successful";
        String actualDepositMessage = accountPage.gettingTextFromConfirmMessage();
        softAssert.assertEquals(expectedDepositMessage,actualDepositMessage);
        softAssert.assertAll();
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        this.customerShouldDepositMoneySuccessfully();
        accountPage.clickingOnWithdrawlTab();
        Thread.sleep(1000);
        accountPage.enterWithdrawlAmount("50");
        accountPage.clickWithdrawButtonAfterAmountEntered();
        Thread.sleep(1000);
        String expectedWithdrawMessage = "Transaction successful";
        String actualWithdrawMessage   = accountPage.gettingTextFromWithdrawlConfirmation();
        softAssert.assertEquals(expectedWithdrawMessage,actualWithdrawMessage);
        softAssert.assertAll();
    }
}
