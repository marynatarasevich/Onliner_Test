package by.mt.onliner.pages.basket;


import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class BasketPage extends BaseOnlinerPage {
    public BasketPage() {
        super();

    }


    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//h1[@class='cart-header__title']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }
    public boolean checkGoodIsPresent(String title) {
        try {
            WebDriverWait wait=new WebDriverWait(getDriver(),10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='cart-product-title__link cart-product-title__link_name']//span[contains(text(),'"+title+"')]")));
            return getDriver().findElement(By.xpath("//a[@class='cart-product-title__link cart-product-title__link_name']//span[contains(text(),'"+title+"')]")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }
}