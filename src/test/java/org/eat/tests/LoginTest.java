package org.eat.tests;

import org.eat.base.WebDriverFactory;
import org.eat.base.BaseTestProject;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTest extends BaseTestProject {
    @BeforeClass(alwaysRun = true)
    public void setUP(){
        if (navP.isUserLoggedIn()){
            navP.toLogout();
        }
    }

    @Test( dataProvider = "loginDataInvalid",groups = {"smoke"})
    public void singInWithInvalidData(String username, String password) {
        logP.SignInWith(username, password);
        boolean result = logP.verifyInvalidCredentialsErrorMessage();
        Assert.assertTrue(result);
    }
    @Test(dataProvider = "loginData",groups = {"smoke"})
    public void singInWithValidData (String username,String password) {
        logP.SignInWith(username,password);
        boolean result=navP.isUserLoggedIn();
        Assert.assertTrue(result);

    }




}

