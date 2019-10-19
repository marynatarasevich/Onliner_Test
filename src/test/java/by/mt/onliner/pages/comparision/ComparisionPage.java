package by.mt.onliner.pages.comparision;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ComparisionPage extends BaseOnlinerPage {
    public ComparisionPage() {
        super();

    }


    @Override
    protected void openPage() {

    }
    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//h1[@class='b-offers-title'][text()='Сравнение товаров']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return false;
        }
    }
    public ArrayList<String> getComparedGoodsTitles(){
        try{
            List<WebElement> wes=getDriver().findElements(By.xpath("//tr[@class='product-table__row product-table__row_header product-table__row_top']//span[@class='product-summary__caption']"));
            ArrayList<String> goods=new ArrayList<String>();
            for (WebElement we:wes){
               goods.add(we.getAttribute("innerText"));
            }
            return goods;

        }catch(Exception e){
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return null;
        }
    }
}