package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static Properties prop;
    public static WebDriver driver;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fi = new FileInputStream("/Users/shailavishah/IdeaProjects/SeleniumFirstAssignment" +
                    "/src/main/java/com/config/config.properties");
            prop.load(fi);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        System.setProperty("webdriver.chrome.driver", "/Users/shailavishah/IdeaProjects/SeleniumFirstAssignment/" +
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().deleteAllCookies();
    }
}
