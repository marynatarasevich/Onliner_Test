package by.mt.onliner.base;

import com.google.common.io.Files;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.yandex.qatools.allure.annotations.Attachment;


import java.io.File;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class WebDriverFactory {
    private static final long IMPLICIT_WAIT_TIMEOUT = 5;
    private static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<WebDriver>();


    private static String browser;

    public static void setBrowser(String browserName) {
        browser = browserName;
    }


    public static WebDriver getDriver() {
        if (driverContainer.get() != null) {
            driverContainer.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            return driverContainer.get();
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }
    public static WebDriver getDriver(int iwt) {
        if (driverContainer.get() != null) {
            driverContainer.get().manage().timeouts().implicitlyWait(iwt, TimeUnit.SECONDS);
            return driverContainer.get();
        } else {
            throw new IllegalStateException("Driver has not been initialized. " +
                    "Please call WebDriverFactory.startBrowser() before use this method");
        }
    }


    public static void startBrowser(boolean isLocal) {
     //   ResourceBundle resources = ResourceBundle.getBundle("PIF_savefile");
        if (driverContainer.get() == null) {
            if (!isLocal) {
            } else {
               if (browser.equalsIgnoreCase("CHROME")) {
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("download.default_directory", "C:\\WORK\\TestDownloads\\");
                    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);
                    ///options.addArguments("--auto-open-devtools-for-tabs");
                    DesiredCapabilities caps = DesiredCapabilities.chrome();
                    LoggingPreferences logPrefs = new LoggingPreferences();
                    logPrefs.enable(LogType.BROWSER, Level.ALL);
                    caps.setCapability(ChromeOptions.CAPABILITY, options);
                    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                    driverContainer.set(new ChromeDriver(caps));



                }else {
                    throw new IllegalStateException("Unsupported browser type");
                 }

            }

            System.out.println("started browser :"+ browser);
            getDriver().manage().window().maximize();
            getDriver().get("https://www.onliner.by");

        } else {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }

    }


    /**
     * Finishes browser
     */
    public static void finishBrowser() {
        driverContainer.get().quit();
        driverContainer.set(null);

    }

    /**
     * Method for screenshot taking. It is empty now, because you could save your screenshot as you want.
     * This method calls in tests listeners on test fail
     */
    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public static byte[] takeScreenShot(String methodName) {
        WebDriver driver = driverContainer.get();
        try {

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(scrFile, new File(methodName + ".png"));
            System.out.println("ScreenShot method called");
            String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
            String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
            System.out.println("Net data: " +methodName);
            System.out.println(netData);
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            System.out.println("Console data: " +methodName);
            for (LogEntry entry : logEntries) {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
                //do something useful with the data
            }
        } catch (Exception e) {
            System.out.println("Scr shot taking exception: " + e.getMessage());
            e.printStackTrace();
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }




}
