package by.mt.onliner.pages.aboutcompany;

import by.mt.onliner.pages.BaseOnlinerPage;
import org.openqa.selenium.By;

import java.util.logging.Level;

public class AboutTheCompanyPage extends BaseOnlinerPage {
    public AboutTheCompanyPage() {
        super();

    }


    @Override
    protected void openPage() {

    }
    @Override
    public boolean isPageOpened() {
        try {
            return getDriver().findElement(By.xpath("//div[@class='news-header__title']//h1[text()='О сайте']")).isDisplayed();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return false;
        }
    }
    public boolean checkPhone(String phone){
        try{
            return getDriver().findElement(By.xpath("//div[@class='news-text']//p[text()='"+phone+"']")).isDisplayed();
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            return false;
        }
    }
}