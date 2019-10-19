package by.mt.onliner.base;

import by.mt.onliner.listeners.ScreenShotOnFailListener;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Listeners({ScreenShotOnFailListener.class})
public class BaseTest {
     protected static Logger LOGGER;
    @BeforeClass(groups = {"regression"})
    @Parameters({"browser"})
    public static void beforeClass(String browser) {
        System.out.println("In beforeClass of " + Thread.currentThread().getStackTrace()[1].getClassName());
        try{
            FileInputStream ins = new FileInputStream("log.config");
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger( Thread.currentThread().getStackTrace()[1].getClassName());
            Handler[] handlers=LOGGER.getHandlers();
            for (Handler handler:handlers){
                handler.setEncoding("UTF-8");
            }
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
        WebDriverFactory.setBrowser(browser);

    }
    @AfterMethod(groups = {"regression"})
    public static void afterTest() {
        System.out.println("In afterTest of " + Thread.currentThread().getStackTrace()[1].getClassName());
        WebDriverFactory.finishBrowser();

    }

    @AfterClass(groups = {"regression"})
    public static void afterClass() {
        System.out.println("In afterclass of " + Thread.currentThread().getStackTrace()[1].getClassName());


    }
}