package by.mt.onliner.tests;

import by.mt.onliner.base.BaseTest;
import by.mt.onliner.base.WebDriverFactory;
import by.mt.onliner.pages.comparision.ComparisionPage;
import by.mt.onliner.pages.OnlinerMainPage;
import by.mt.onliner.utils.ComparisionHelper;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

public class CompareGoods_Test extends BaseTest{

    @Test(groups = {"regression"})
    public void testCompareGoods() {
        try {
            LOGGER.log(Level.INFO, "start browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO, "find phone Samsung Galaxy");
            onlinerMainPage.search("Samsung Galaxy");
            LOGGER.log(Level.INFO, "choose Samsung Galaxy A50");
            onlinerMainPage.checkTheGood("Samsung Galaxy A50");
            LOGGER.log(Level.INFO, "choose Samsung Galaxy S10");
            onlinerMainPage.checkTheGood("Samsung Galaxy S10");
            LOGGER.log(Level.INFO, "compare 2 phones");
            ComparisionPage comparisionPage = onlinerMainPage.compare2Goods();
            ArrayList<String> expectedGoods = new ArrayList<String>();
            expectedGoods.add("Samsung Galaxy A50");
            expectedGoods.add("Samsung Galaxy S10");
            LOGGER.log(Level.INFO, "check comnparisioon");
            assertTrue("Compared goods are not correct!", ComparisionHelper.compare(expectedGoods, comparisionPage.getComparedGoodsTitles()));
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"exception" , e);
            fail("excecptions");
        }
    }

   }