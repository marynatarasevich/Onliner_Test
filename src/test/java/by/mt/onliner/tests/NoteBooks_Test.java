package by.mt.onliner.tests;

import by.mt.onliner.base.BaseTest;
import by.mt.onliner.base.WebDriverFactory;
import by.mt.onliner.listeners.ScreenShotOnFailListener;
import by.mt.onliner.pages.notebooks.NoteBooksPage;
import by.mt.onliner.pages.OnlinerMainPage;
import by.mt.onliner.utils.TimeUtils;
import org.testng.annotations.*;

import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

public class NoteBooks_Test extends BaseTest {

    @Test(groups = {"regression"})
    public void testSearchNotebooks(){
        try {
            LOGGER.log(Level.INFO, "start browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO, "open notebooks");
            NoteBooksPage noteBooksPage = onlinerMainPage.openNotebooks();
            LOGGER.log(Level.INFO, "choose manufacturer Apple");
            noteBooksPage.chooseManufacturer("Apple");
            LOGGER.log(Level.INFO, "choose screen resolution 1920 x 1080");
            noteBooksPage.chooseAnotherResolution("1920 x 1080");
            LOGGER.log(Level.INFO, "choose color pink");
            noteBooksPage.chooseColor("розовый");
            TimeUtils.waitForSeconds(1);
            LOGGER.log(Level.INFO, "check that notebook found Apple MacBook (2017 год)");
            assertTrue("Не найден нужный ноубук!", noteBooksPage.checkFound("Apple MacBook (2017 год)"));
            LOGGER.log(Level.INFO, "проверяем что в описании есть цвет крышки розовый");
            assertTrue("check that descrition contains color pink!", noteBooksPage.checkDescriptionOfFoundContains("Apple MacBook (2017 год)", "цвет крышки розовый"));
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"execption" , e);
            fail("Есть excecptions");
        }
    }

}