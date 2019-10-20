package by.mt.onliner.pages.mobiles;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class MobilePhonesPage extends BaseOnlinerPage {
    public MobilePhonesPage() {
        super();

    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//h1[@class='schema-header__title'][text()='Мобильные телефоны']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }

    public String getGoodTitleOnPosition(int position) {
        try {
            return getDriver().findElements(By.xpath("//div[@class='schema-product schema-product_narrow-sizes']/div[@class='schema-product__part schema-product__part_2']/div[@class='schema-product__part schema-product__part_4']/div[@class='schema-product__title']/a/span")).get(position - 1).getAttribute("innerText");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }

    public MobilePhonePage openPhoneOnPosition(int position) {
        try {
            getDriver().findElements(By.xpath("//div[@class='schema-product schema-product_narrow-sizes']/div[@class='schema-product__part schema-product__part_2']/div[@class='schema-product__part schema-product__part_4']/div[@class='schema-product__title']/a")).get(position - 1).click();
            return new MobilePhonePage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
}