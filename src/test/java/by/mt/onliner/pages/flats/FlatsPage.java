package by.mt.onliner.pages.flats;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class FlatsPage extends BaseOnlinerPage {
    public FlatsPage() {
        super();

    }


    @Override
    protected void openPage() {

    }
    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//span[@class='project-navigation__sign'][text()='Продажа']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return false;
        }
    }
    public FlatPage selectFirstFlat(){
        try {
            getDriver().findElement(By.xpath("//a[@class='classified__handle']")).click();
        return new FlatPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return null;
        }
    }
}