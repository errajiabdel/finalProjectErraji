package org.eat.base;

import org.eat.pages.LoginPage;
import org.eat.pages.NavigationPage;
import org.eat.pages.ShoppingPage;
import org.eat.utilities.Constants;
import org.eat.utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

public class BaseTestProject {

    public WebDriver driver;
    public LoginPage logP ;
    public NavigationPage navP;
    public ShoppingPage shop;

    @BeforeClass(groups = {"regression","smoke"})
    public void setUp () throws Exception {
        driver= WebDriverFactory.getInstance().getDriver("chrome");
        driver.get(Constants.TEST_URL);
        ExcelUtility.setExcelFile(Constants.EXCEL_FILEPATH2,"projectData");

        logP=new LoginPage(driver);
        navP=new NavigationPage(driver);
        shop=new ShoppingPage(driver);
        logP.SignInWith("standard_user","secret_sauce");

    }


    @DataProvider(name="loginData")
    public Object[][] loginTestData(){
        Object[][] testData= ExcelUtility.getTestData("validData");
        return testData;
    }



    @DataProvider(name="loginDataInvalid")
    public Object[][] loginTestInvalidData(){
        Object[][] testData= ExcelUtility.getTestData("invalidData");
        return testData;
    }


}

