package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class PropertyPage extends TestBase {

    @FindBy(xpath = "//ul[@data-role='listview']//li//a[@class='listing-results-price text-price']")
    List<WebElement> propertyList;
    List<Long> prices;

    public PropertyPage() {
        PageFactory.initElements(driver, this);
    }

    public void printPropertyPriceInDescendingOrder() {

        prices = new ArrayList<Long>();

        for (WebElement list: propertyList) {
            System.out.println(list.getText());
            if (list.getText().matches("^[A-Za-z]*"))
                continue;
            String listValue = list.getText().split(" ")[0].replace("£","").replace(",","");
            prices.add(Long.parseLong(listValue));
        }
        Collections.sort(prices, Collections.<Long>reverseOrder());
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println("Printing Property price in Descending order:------>>");
        for (Long price:prices) {
            String currencyPrice = currencyFormatter.format(price).toString();
            System.out.println(currencyPrice.substring(0, currencyPrice.indexOf(".")));
        }
    }

    public FifthProperty selectFifthProperty() {
        propertyList.get(4).click();
        return new FifthProperty();
    }
}
