package com.bank.basepage;

import com.bank.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jay
 */
public class BasePage {

    public static WebDriver driver;
    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    String projectPath = System.getProperty("user.dir");
    private static final Logger log = LogManager.getLogger(BasePage.class.getName());


    //this constructor is for making pagefactory model
    public BasePage() {
        PageFactory.initElements(driver,this);
        PropertyConfigurator.configure(projectPath+"/src/test/java/resources/propertiesfile/log4j.properties");

    }

    public void selectBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
            log.info("Launching Chrome Browser");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
            log.info("Launching firefox Browser");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
            log.info("Launching IE Browser");
            driver = new InternetExplorerDriver();
        } else {
            log.info("wrong Browser name");
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait")), TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if (driver != null){
            driver.quit();
        }
    }

}
