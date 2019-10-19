package by.mt.onliner.tests;

import by.mt.onliner.base.BaseTest;
import by.mt.onliner.base.WebDriverFactory;
import by.mt.onliner.pages.*;
import by.mt.onliner.pages.basket.BasketPage;
import by.mt.onliner.pages.mobiles.MobilePhonePage;
import by.mt.onliner.pages.mobiles.MobilePhonesPage;
import by.mt.onliner.pages.mobiles.offers.OffersPage;
import org.testng.annotations.*;

import java.util.logging.Level;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Basket_Test extends BaseTest {

    @Test(groups = {"regression"})
    public void testBasket(){
        try {
            LOGGER.log(Level.INFO, "starting browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO, "open mobile phones");
            MobilePhonesPage mobilePhonesPage = onlinerMainPage.openMobilePhones();
            LOGGER.log(Level.INFO, "get title of phone on position 4");
            String good = mobilePhonesPage.getGoodTitleOnPosition(4);
            LOGGER.log(Level.INFO, "open phone on position 4");
            MobilePhonePage mobilePhonePage = mobilePhonesPage.openPhoneOnPosition(4);
            LOGGER.log(Level.INFO, "open offers");
            OffersPage offersPage = mobilePhonePage.openOffers();
            LOGGER.log(Level.INFO, "adding to the basket of firts offer");
            offersPage.addToBasketOfFirtsOffer();
            LOGGER.log(Level.INFO, "open basket");
            BasketPage basketPage = offersPage.openBasket();
            LOGGER.log(Level.INFO, "test that the good is in the basket");
            assertTrue("Не отображается телефон в корзине!", basketPage.checkGoodIsPresent(good));
        }catch (Exception e){
            LOGGER.log(Level.WARNING,"execption" , e);
            fail("Есть exceptions");
        }

    }

}