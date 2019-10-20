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
            assertTrue("Phone number is not displayed!", aboutTheCompanyPage.checkPhone("Телефон: +375 (17) 328-19-76."));
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"exception" , e);
            fail("excecptions");
        }
    }
    @Test(groups = {"regression"})
    public void testAboutTheCompanyClickLogo() {
        try {
            LOGGER.log(Level.INFO,"starting browser");
            WebDriverFactory.startBrowser(true);
            OnlinerMainPage onlinerMainPage = new OnlinerMainPage();
            LOGGER.log(Level.INFO,"openning page About the company");
            AboutTheCompanyPage aboutTheCompanyPage = onlinerMainPage.clickAboutTheCompany();
            LOGGER.log(Level.INFO,"clicking logo");
            onlinerMainPage=aboutTheCompanyPage.clickLogo();
            LOGGER.log(Level.INFO,"check that the main page is opened");
            assertNotNull( onlinerMainPage,"The main page is not opened!");
        }catch(Exception e){
            LOGGER.log(Level.WARNING,"execption" , e);
            fail("excecptions");
        }
    }

}