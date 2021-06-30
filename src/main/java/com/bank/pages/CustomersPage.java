package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.WeakHashMap;

public class CustomersPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomersPage.class.getName());

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectCustomerNameFromList;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickOnLoginButton;


//   @FindBy(xpath = "//select[@id='userSelect']//option[@value='6']")
//    WebElement verifyTheText;

    @FindBy (xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    @FindBy (xpath = "//label[contains(text(),'Your Name :')]")
    WebElement verifyYourname;

    public void selectCustomerFromDropDownList(String value){
        selectByValueFromDropDown(selectCustomerNameFromList,value);
        log.info("select customer"+value + "from Drop down list"+ selectCustomerNameFromList.toString());
    }

    public void clickOnLoginButton(){
        clickOnElement(clickOnLoginButton);
        log.info("Click On Login Button"+ clickOnLoginButton.toString());

    }

//    public void customerDropDownList(String value){
//        selectByValueFromDropDown(selectCustomerFromDropDownList,value);
//        log.info("select customer"+value + "from Drop down list"+ selectCustomerFromDropDownList.toString());
//    }
public String verifyTextLogOut(){
    log.info("verifyTextYourLogOut" + logoutButton.toString());
    return getTextFromElement(logoutButton);
}

    public void clickOnLogOutButton() {
        log.info("Click OnLogOutButton" + logoutButton.toString());
        clickOnElement(logoutButton);
    }

    public String verifyTextYourName(){
        return getTextFromElement(verifyYourname);
    }





}
