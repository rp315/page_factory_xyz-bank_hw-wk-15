package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(AccountPage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement textOnLogoutButton;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement clickOnDepositButton;

   // @FindBy(xpath = "//input[@type='number']")
    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement enterTheAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnDepositAfterAmountSelected;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement gettingTextAmountSuccessful;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdrawTab;

//    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
//    WebElement clickOnWithdrawlButton;

    @FindBy (xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement gettingTextWithrawlSuccessful;

    public void clickOnLogoutButton(){
        clickOnElement(textOnLogoutButton);
        log.info("click on Logout button"+ textOnLogoutButton.toString());
    }

    public void clickOnDepositButton(){
        clickOnElement(clickOnDepositButton);
        log.info("Clicking on Deposit Button"+ clickOnDepositButton.toString());
    }

    public void enterTheAmountOnDepositField(String value){
        sendTextToElement(enterTheAmount,value);
        log.info("enter the amount"+ value+ "to deposit field"+ enterTheAmount.toString());
    }

    public void clickOnDepositButtonAfterAmountSelected(){
        clickOnElement(clickOnDepositAfterAmountSelected);
        log.info("Click On Deposit amount Button after Amount Selected "+ clickOnDepositAfterAmountSelected.toString());
    }

    public String gettingTextFromConfirmMessage(){
        log.info("Getting Text deposited successfully"+ gettingTextAmountSuccessful.toString());
        return getTextFromElement(gettingTextAmountSuccessful);

    }

    public void clickingOnWithdrawlTab(){
        clickOnElement(withdrawTab);
        log.info("clicking on Withdrawl button"+ withdrawTab.toString());
    }

    public void enterWithdrawlAmount(String value){
        sendTextToElement(enterTheAmount,value);
        log.info("enter the amount"+ value+ "on the Withdrawl field"+ enterTheAmount.toString());
    }

    public void clickWithdrawButtonAfterAmountEntered(){
        log.info("Clicking on Withdraw Button After Amount Entered"+ withdrawButton.toString());
        clickOnElement(withdrawButton);
    }

    public String gettingTextFromWithdrawlConfirmation(){
        log.info("getting text from Withdrawl Successful message"+ gettingTextWithrawlSuccessful.toString());
        return getTextFromElement(gettingTextWithrawlSuccessful);
    }

}
