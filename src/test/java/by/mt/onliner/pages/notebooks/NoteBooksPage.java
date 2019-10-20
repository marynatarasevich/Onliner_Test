package by.mt.onliner.pages.notebooks;

import by.mt.onliner.base.BasePage;
import by.mt.onliner.pages.BaseOnlinerPage;
import by.mt.onliner.utils.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

public class NoteBooksPage extends BaseOnlinerPage {
    public NoteBooksPage() {
        super();

    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//h1[@class='schema-header__title'][text()='Ноутбуки']")).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean chooseManufacturer(String manufacturer){
        try {
            LOGGER.log(Level.INFO,"scrolling to the correct position");
            WebElement element = getDriver().findElement(By.xpath("//span[text()='Производитель']"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            getDriver().findElement(By.xpath("//input[@value='"+manufacturer.toLowerCase()+"']//parent::span")).click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean chooseAnotherResolution(String resolution){
        try {
            LOGGER.log(Level.INFO,"scrolling to the correct position");
            WebElement element = getDriver().findElement(By.xpath("//span[text()='Разрешение экрана']"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(getDriver().findElement(By.xpath("//span[text()='Разрешение экрана']//parent::div//following-sibling::div//*[@class='schema-filter-control__item']")));
            select.selectByVisibleText(resolution);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean chooseColor(String color){
        try {
            LOGGER.log(Level.INFO,"scrolling to the correct position");
            WebElement element = getDriver().findElement(By.xpath("//span[text()='Цвет корпуса']"));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            getDriver().findElement(By.xpath("//span[text()='Цвет корпуса']//parent::div//following-sibling::div//*[@class='schema-filter-control__item']")).click();
            getDriver().findElement(By.xpath("//span[text()='Цвет корпуса']//parent::div//parent::div//div[@class='schema-filter-popover schema-filter-popover_visible']//span[@class='schema-filter__checkbox-text'][text()='"+color+"']//preceding-sibling::span//span[@class='i-checkbox__faux']")).click();
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"exception" , e);
            return false;
        }
    }
    public boolean checkFound(String title){
        try {
            WebDriverWait wait=new WebDriverWait(getDriver(),10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='schema-product__part schema-product__part_2']//span[contains(text(),'"+title+"')]")));
            return getDriver().findElement(By.xpath("//div[@class='schema-product__part schema-product__part_2']//span[contains(text(),'"+title+"')]")).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkDescriptionOfFoundContains(String title,String contains){
        try {
            return getDriver().findElement(By.xpath("//div[@class='schema-product__part schema-product__part_2']//span[contains(text(),'"+title+"')]//parent::a//parent::div//following-sibling::div//span[contains(text(),'"+contains+"')]")).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}