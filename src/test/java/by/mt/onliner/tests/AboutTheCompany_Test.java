package by.mt.onliner.tests;

import by.mt.onliner.base.BaseTest;
import by.mt.onliner.base.WebDriverFactory;
import by.mt.onliner.pages.aboutcompany.AboutTheCompanyPage;
import by.mt.onliner.pages.OnlinerMainPage;
import org.testng.annotations.*;


import java.util.logging.Level;


import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;


public class AboutTheCompany_Test extends BaseTest{


    @Test(groups = {"regression"})
    public void testAboutTheCompany() {
        try {
            LOGGER.log(Level.INFO,"starting browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO,"openning page About the company");
            AboutTheCompanyPage aboutTheCompanyPage = onlinerMainPage.clickAboutTheCompany();
            LOGGER.log(Level.INFO,"checking the phone");
            assertTrue("Не отображается номер телефона!", aboutTheCompanyPage.checkPhone("Телефон: +375 (17) 328-19-76."));
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"exception" , e);
            fail("Есть excecptions");
        }
    }
    @Test(groups = {"regression"})
    public void testAboutTheCompanyClickLogo() {
        try {
            LOGGER.log(Level.INFO,"стартуем браузер");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO,"открываем страницу О компании");
            AboutTheCompanyPage aboutTheCompanyPage = onlinerMainPage.clickAboutTheCompany();
            LOGGER.log(Level.INFO,"жмем на лого");
            onlinerMainPage=aboutTheCompanyPage.clickLogo();
            LOGGER.log(Level.INFO,"проверяем что открылась главная страница");
            assertNotNull( onlinerMainPage,"Не открылась главная страница!");
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
            fail("Есть excecptions");
        }
    }

}