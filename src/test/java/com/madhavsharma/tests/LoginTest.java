package com.madhavsharma.tests;


import com.madhavsharma.pages.LoginPage;
import com.madhavsharma.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    @Test(dataProvider = "loginData")
    public void login_with_valid_username_and_password(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(username, password);
        Assert.assertTrue(productsPage.isProductPageLoaded(),"Product page not loaded correctly");
      //  takeScreenshot("screenshots/login_"+username+".png");
      //  driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

      //  Header header = new Header(driver);
      //  System.out.println( header.isCartEmpty());

      //  System.out.println(header.getCartItemCount());

//        loginPage.logout();
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider(){
        return new Object[][] {
                {"standard_user","secret_sauce"},
                //{"locked_out_user","secret_sauce"},
//                {"problem_user","secret_sauce"},
//                {"performance_glitch_user","secret_sauce"},
//                {"error_user","secret_sauce"},
//                {"visual_user","secret_sauce"}
        };
    }
}
