package by.mt.onliner.listeners;

import by.mt.onliner.base.WebDriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ScreenShotOnFailListener implements ITestListener {
    protected static Logger LOGGER;

    static {
        try {

            FileInputStream ins = new FileInputStream("log.config");
            LogManager.getLogManager().readConfiguration(ins);

            LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
            Handler[] handlers = LOGGER.getHandlers();
            for (Handler handler : handlers) {
                handler.setEncoding("UTF-8");
            }
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
    public void onTestStart(ITestResult iTestResult) {

    }


    public void onTestSuccess(ITestResult iTestResult) {

    }


    public void onTestFailure(ITestResult iTestResult) {
        WebDriverFactory.takeScreenShot(iTestResult.getMethod().getMethodName());
        LOGGER.log(Level.SEVERE,iTestResult.getMethod()+"-"+iTestResult.getThrowable().getMessage() != null ? iTestResult.getThrowable().getMessage() :
                iTestResult.getThrowable().getCause().getMessage());
    }


    public void onTestSkipped(ITestResult iTestResult) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
