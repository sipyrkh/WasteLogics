package webdriver;

import exception.InvalidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import logger.LoggerApp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ReadPropertyFile;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private static volatile WebDriverFactory instanceDriver;
    private static WebDriver driver;

    private WebDriverFactory(WebDriver driver) {
        WebDriverFactory.driver = driver;
    }

    public static WebDriver getBrowser() throws InvalidBrowserException {

        switch (ReadPropertyFile.getProperty("browser").toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                LoggerApp.info("Firefox webdriver was initialized");
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                LoggerApp.info("Chrome webdriver was initialized");
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                LoggerApp.info("IE webdriver was initialized");
            default:
                LoggerApp.fatal("User input incorrect name of browser");
                throw new InvalidBrowserException("Incorrect name of browser!");
        }

        return driver;
    }

    public static WebDriverFactory getInstance() {
        if (instanceDriver == null) {
            synchronized (WebDriverFactory.class) {
                if (instanceDriver == null) {
                    instanceDriver = new WebDriverFactory(driver);
                }
            }
        }
        return instanceDriver;
    }

    public static WebDriver getDriver() {
        return getInstance().driver;
    }

    public void closeBrowser() {
        try {
            driver.quit();
            LoggerApp.info("Browser driver quit");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LoggerApp.info("driver and instance of driver are nulling");
            driver = null;
            instanceDriver = null;
        }
    }

    public void openUrl(String url) {
        LoggerApp.info("Navigating to url: " + url);
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void waitImplicitly(long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

}