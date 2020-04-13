package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase{

    @FindBy(xpath="//input[@id='search-input-location']")
    WebElement locationSearchBox;

    @FindBy(id = "search-submit")
    WebElement searchButton;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public PropertyPage searchLocation() {
        System.out.println(prop.getProperty("location"));
        locationSearchBox.sendKeys(prop.getProperty("location"));
        searchButton.click();
        return new PropertyPage();
    }

}
