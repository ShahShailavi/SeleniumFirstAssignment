package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentPage extends TestBase {

    @FindBy(xpath = "//h1[@class='bottom-half']")
    WebElement agentName;

    public AgentPage() {
        PageFactory.initElements(driver, this);
    }

    public String getAgentName() {
        return agentName.getText();
    }




}
