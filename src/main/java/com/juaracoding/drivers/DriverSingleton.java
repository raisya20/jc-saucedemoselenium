package com.juaracoding.drivers;

import com.juaracoding.drivers.strategies.DriverStrategy;
import com.juaracoding.drivers.strategies.DriverStrategyImplemented;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;

    public DriverSingleton(String driver) {
        instantiate(driver);
    }

    public static WebDriver instantiate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyImplemented.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingleton getInstance(String driver) { //sesuaikan dengan driver yg digunakan ex. chrome
        if (instance == null) {
            instance = new DriverSingleton(driver); //ubah driver yang digunakan apa
        }
        return instance;
    }
    public static  WebDriver getDriver() {
        return driver;
    }

    public static void closeObjectInstance() {
        instance = null;
        driver.quit();
    }
}
