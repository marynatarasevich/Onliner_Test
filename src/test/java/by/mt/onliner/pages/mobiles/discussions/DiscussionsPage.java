package by.mt.onliner.pages.mobiles.discussions;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class DiscussionsPage extends BaseOnlinerPage {
    public DiscussionsPage() {
        super();

    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//h1[@class='m-title']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }
    public String getHeadline(){
        try {
            return getDriver().findElement(By.xpath("//h1[@class='m-title']//a")).getAttribute("innerText");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
}