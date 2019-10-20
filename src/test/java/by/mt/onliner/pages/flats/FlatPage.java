package by.mt.onliner.pages.flats;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class FlatPage extends BaseOnlinerPage {
    public FlatPage() {
        super();

    }


    @Override
    protected void openPage() {

    }
    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//div[@class='apartment-cover']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }
    public String getFlatMark(){
        try {
            return getDriver().findElement(By.xpath("//span[@class='apartment-bar__value']")).getAttribute("innerText");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
}