package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(BankManagerLoginPage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    public void clickOnAddCustommerButton(){
        clickOnElement(addCustomerButton);
        log.info("Clicking On Add Customer Button "+ addCustomerButton.toString());
    }

    public void clickOnOpenAccountButton(){
        clickOnElement(openAccountButton);
        log.info("Clicking on Open Account Tab "+ openAccountButton.toString());
    }

}
