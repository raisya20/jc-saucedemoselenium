package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productText;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;


    public void loginUser(String username, String password){
        this.username.clear(); // Menambahkan langkah untuk menghapus username sebelumnya
        this.username.sendKeys(username);
        this.password.clear(); // Menambahkan langkah untuk menghapus password sebelumnya
        Utils.delay(1);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getProductText() {
        return productText.getText();
    }

    public String getErrorMessage(){
        Utils.delay(2);
        return errorMessage.getText();
    }

}
