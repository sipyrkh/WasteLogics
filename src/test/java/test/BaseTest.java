package test;

import exception.InvalidBrowserException;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ReadPropertyFile;
import webdriver.WebDriverFactory;

public class BaseTest {

    private WebDriverFactory driverFactory = WebDriverFactory.getInstance();

    @Step("Initializing driver and navigating to 'Main' page")
    @BeforeTest
    public void setUp() throws InvalidBrowserException {
        driverFactory = WebDriverFactory.getInstance();
        driverFactory.getBrowser();
        driverFactory.maximizeWindow();
        driverFactory.openUrl(ReadPropertyFile.getProperty("startUrl"));
        driverFactory.waitImplicitly(10);
    }

    @Step("Quiting driver")
    @AfterTest
    public void tearDown() {
        driverFactory.closeBrowser();
    }
}
