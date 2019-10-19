package by.mt.onliner.base;

import by.mt.onliner.utils.TimeUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public abstract class BasePage {
    protected static Logger LOGGER;

    static {
        try {

            FileInputStream ins = new FileInputStream("log.config");
            LogManager.getLogManager().readConfiguration(ins);

            LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
            Handler[] handlers=LOGGER.getHandlers();
            for (Handler handler:handlers){
                handler.setEncoding("UTF-8");
            }
        } catch (Exception ignore) {
            ignore.printStackTrace();
        } }
        private static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 20;


    protected abstract void openPage();

    protected void openPage(String url) {
    }

    public abstract boolean isPageOpened();

    public BasePage(boolean openPageByUrl) {
        if (openPageByUrl) {
            openPage();
        }
        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    public BasePage(String url) {

        openPage(url);

        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    public BasePage() {

        openPage();

        PageFactory.initElements(getDriver(), this);
        waitForOpen();
    }

    private void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS) {
            TimeUtils.waitForSeconds(1);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }

    protected WebDriver getDriver() {
        return WebDriverFactory.getDriver();
    }

    protected WebDriver getDriver(int awt) {
        return WebDriverFactory.getDriver(awt);
    }


}
