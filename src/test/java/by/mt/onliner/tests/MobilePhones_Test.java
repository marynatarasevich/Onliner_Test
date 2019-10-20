package by.mt.onliner.tests;

import by.mt.onliner.base.BaseTest;
import by.mt.onliner.base.WebDriverFactory;
import by.mt.onliner.listeners.ScreenShotOnFailListener;
import by.mt.onliner.pages.*;
import by.mt.onliner.pages.mobiles.MobilePhonePage;
import by.mt.onliner.pages.mobiles.MobilePhonesPage;
import by.mt.onliner.pages.mobiles.discussions.DiscussionsPage;
import org.testng.annotations.*;

import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;


public class MobilePhones_Test extends BaseTest{
    @Test(groups = {"regression"})
    public void testDiscussions(){
        try {
            LOGGER.log(Level.INFO, "start browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO, "open phones");
            MobilePhonesPage mobilePhonesPage = onlinerMainPage.openMobilePhones();
            LOGGER.log(Level.INFO, "get phone on position 4");
            String good = mobilePhonesPage.getGoodTitleOnPosition(4);
            LOGGER.log(Level.INFO, "open phone on position 4");
            MobilePhonePage mobilePhonePage = mobilePhonesPage.openPhoneOnPosition(4);
            LOGGER.log(Level.INFO, "open discussions");
            DiscussionsPage discussionsPage = mobilePhonePage.openDiscussions();
            LOGGER.log(Level.INFO, "check that at discussions title of phone is present");
            assertTrue("Title of phone is not displayed in discussions!", good.equalsIgnoreCase(discussionsPage.getHeadline()));
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"exception" , e);
            fail("excecptions");
        }
    }

}