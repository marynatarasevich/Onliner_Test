package by.mt.onliner.pages.mobiles;

import by.mt.onliner.pages.BaseOnlinerPage;
import by.mt.onliner.pages.mobiles.discussions.DiscussionsPage;
import by.mt.onliner.pages.mobiles.offers.OffersPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class MobilePhonePage extends BaseOnlinerPage {
    public MobilePhonePage() {
        super();

    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//h1[@class='catalog-masthead__title']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }


    public OffersPage openOffers() {
        try {
            getDriver().findElement(By.xpath("//a[@class='button button_orange button_big offers-description__button']")).click();
            return new OffersPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
    public DiscussionsPage openDiscussions(){
        try {
            getDriver().findElement(By.xpath("//span[text()='Обсуждение на форуме']//parent::a")).click();
            return new DiscussionsPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
}