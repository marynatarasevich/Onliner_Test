package by.mt.onliner.pages.mobiles.offers;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class OffersPage extends BaseOnlinerPage {
    public OffersPage() {
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
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return false;
        }
    }

    public boolean addToBasketOfFirtsOffer() {
        try {
            getDriver().findElement(By.xpath("//a[@class='button button_orange button_middle offers-list__button offers-list__button_basket']")).click();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return false;
        }
    }
}