package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addProductButton;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addSecondProduct;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement removeProductButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cartBadge;

    //add product to cart
    public void clickAddProductButton(){
        Utils.delay(1);
        addProductButton.click();
    }

    //validation for add product to cart
    public String getValidAddCart() {
        Utils.delay(1);
        return cartBadge.getText();
    }

    //remove product from cart
    public void clickRemoveProductButton(){
        Utils.delay(1);
        removeProductButton.click();
    }

    //Validation for remove product
    public String getValidRemoveProduct(){
        Utils.delay(1);
        return addProductButton.getText();
    }

    //add second product
    public void addSecondProduct(){
        Utils.delay(1);
        addSecondProduct.click();
    }
}
