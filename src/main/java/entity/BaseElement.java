package entity;

import logger.LoggerApp;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ReadPropertyFile;
import webdriver.WebDriverFactory;

public abstract class BaseElement {

    private String name;
    private By locator;
    private WebDriver driver;
    private static final int TIMEOUT_WAIT = Integer.parseInt(ReadPropertyFile.getProperty("timeout"));
    private Actions actions = new Actions(WebDriverFactory.getDriver());

    protected BaseElement(final By locator, final String name) {
        this.locator = locator;
        this.name = name;
        this.driver = WebDriverFactory.getDriver();
    }

    public WebElement getElement() {
        return driver.findElement(locator);
    }

    public String getName() {
        return name;
    }

    public void click() {
        waitForIsElementPresent();
        LoggerApp.info(name + " are clicking");
        getElement().click();
    }

    public void moveToElement() {
        waitForIsElementPresent();
        LoggerApp.info("Cursor move to " + name);
        actions.moveToElement(getElement()).build().perform();
    }

    public void actionClick() {
        waitForIsElementPresent();
        LoggerApp.info(name + " are clicking");
        actions.moveToElement(getElement()).click().perform();
    }

    public void sendKeys(String key) {
        waitForIsElementPresent();
        LoggerApp.info("Send keys in the field " + key);
        getElement().sendKeys(key);
    }

    public String getText() {
        return getElement().getText();
    }

    public Dimension getSize() {
        return getElement().getSize();
    }

    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    public String getAttribute(String attribute) {
        return getElement().getAttribute(attribute);
    }

    public boolean isVisible() {
        boolean flag = false;
        try {
            if (getElement().isDisplayed()) {
                flag = true;
                LoggerApp.info(name + " is visible");
            }
        } catch (NoSuchElementException e) {
            LoggerApp.info(name + " isn't visible");
        }
        return flag;
    }

    private void waitForIsElementPresent() {
        LoggerApp.info(name + " is presenting on page");
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(getElement()));
    }
}



