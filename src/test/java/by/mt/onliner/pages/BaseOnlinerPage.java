package by.mt.onliner.pages;

import by.mt.onliner.base.BasePage;
import by.mt.onliner.pages.basket.BasketPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class BaseOnlinerPage extends BasePage {
    public BaseOnlinerPage() {
        super(true);

    }


    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//*[@class='onliner_logo']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }
    public BasketPage openBasket(){
        try{
            getDriver().findElement(By.xpath("//a[@class='auth-bar__item auth-bar__item--cart']")).click();
            return new BasketPage();
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
    public OnlinerMainPage clickLogo(){
        try{
            getDriver().findElement(By.xpath("//*[@class='onliner_logo']//parent::a")).click();
            return new OnlinerMainPage();
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
}