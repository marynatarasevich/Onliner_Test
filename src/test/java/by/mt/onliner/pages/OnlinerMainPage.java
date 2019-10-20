package by.mt.onliner.pages;

import by.mt.onliner.pages.aboutcompany.AboutTheCompanyPage;
import by.mt.onliner.pages.comparision.ComparisionPage;
import by.mt.onliner.pages.flats.FlatsPage;
import by.mt.onliner.pages.mobiles.MobilePhonesPage;
import by.mt.onliner.pages.notebooks.NoteBooksPage;
import by.mt.onliner.utils.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class OnlinerMainPage extends BaseOnlinerPage {
    public OnlinerMainPage() {
        super();

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

    public AboutTheCompanyPage clickAboutTheCompany() {
        try {
            getDriver().findElement(By.xpath("//a[contains(text(),'О компании')][@class='footer-style__link footer-style__link_primary']")).click();
            return new AboutTheCompanyPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }

    public boolean search(String theThingToSearch) {
        try {
            getDriver().findElement(By.xpath("//input[@class='fast-search__input']")).sendKeys(theThingToSearch);
            getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='modal-iframe']")));
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }

    public boolean checkTheGood(String goodTitle) {
        try {
            getDriver().findElement(By.xpath("//div[@class='product__title']//a[contains(text(),'" + goodTitle + "')]//parent::div//parent::div[@class='product__details']//following-sibling::label[@class='product__compare']//input//following-sibling::span")).click();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }

    public ComparisionPage compare2Goods() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='compare-button__sub compare-button__sub_main']")));
            TimeUtils.waitForSeconds(1);
            getDriver().findElement(By.xpath("//a[@class='compare-button__sub compare-button__sub_main']")).click();
            return new ComparisionPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }

    public boolean mooveToFlats() {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(getDriver().findElement(By.xpath("//span[@class='b-main-navigation__text'][text()='Дома и квартиры']"))).build().perform();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }

    public FlatsPage select3Rooms() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@class='b-main-navigation__dropdown-advert-sign'][text()='3-комнатные']"))));

            getDriver().findElement(By.xpath("//span[@class='b-main-navigation__dropdown-advert-sign'][text()='3-комнатные']")).click();
            return new FlatsPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
    public NoteBooksPage openNotebooks(){
        try {
            getDriver().findElement(By.xpath("//span[@class='project-navigation__sign'][text()='Ноутбуки']")).click();
            return new NoteBooksPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }

    public MobilePhonesPage openMobilePhones(){
        try {
            getDriver().findElement(By.xpath("//span[@class='project-navigation__sign'][text()='Мобильные телефоны']")).click();
            return new MobilePhonesPage();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return null;
        }
    }
}