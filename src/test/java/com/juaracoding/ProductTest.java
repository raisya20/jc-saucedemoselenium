package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest {
    private WebDriver driver;

    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @AfterClass
    public void finish(){
        Utils.delay(5);
        DriverSingleton.closeObjectInstance();
    }


    //Add to cart
    @Test(priority = 1)
    public void addToCart(){
        loginPage.loginUser("standard_user", "secret_sauce");
        productPage.clickAddProductButton();
        productPage.getValidAddCart();
        Assert.assertEquals(productPage.getValidAddCart(), "1");
    }

    //Remove product from cart
    @Test(priority = 2)
    public void removeProductFromCart(){
        productPage.clickRemoveProductButton();
        productPage.getValidRemoveProduct();
        Assert.assertEquals(productPage.getValidRemoveProduct(), "Add to cart");
    }

    //Add 2 Product to cart
    @Test(priority = 3)
    public void addSecondProductToCart(){
        //loginPage.loginUser("standard_user", "secret_sauce");
        productPage.clickAddProductButton();
        productPage.addSecondProduct();
        productPage.getValidAddCart();
        Assert.assertEquals(productPage.getValidAddCart(), "2");
    }


}
