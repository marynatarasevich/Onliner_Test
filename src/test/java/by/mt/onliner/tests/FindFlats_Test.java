package by.mt.onliner.tests;

import by.mt.onliner.base.BaseTest;
import by.mt.onliner.base.WebDriverFactory;
import by.mt.onliner.pages.flats.FlatPage;
import by.mt.onliner.pages.flats.FlatsPage;
import by.mt.onliner.pages.OnlinerMainPage;
import org.testng.annotations.*;

import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;


public class FindFlats_Test extends BaseTest{
    @Test(groups = {"regression"})
    public void testFindFlats() {
        try {
            LOGGER.log(Level.INFO, "start browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO, "move to flats");
            onlinerMainPage.mooveToFlats();
            LOGGER.log(Level.INFO, "choopse 3 room flats");
            FlatsPage flatsPage = onlinerMainPage.select3Rooms();
            LOGGER.log(Level.INFO, "choose first flat");
            FlatPage flatPage = flatsPage.selectFirstFlat();
            LOGGER.log(Level.INFO, "check the title of  3 room flat");
            assertTrue("Открыта неправильная квартира!", flatPage.getFlatMark().equals("3-комнатная квартира"));

        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"execption" , e);
            fail("Есть excecptions");
        }
    }


}