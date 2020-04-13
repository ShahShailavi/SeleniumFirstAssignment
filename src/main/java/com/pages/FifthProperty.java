package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FifthProperty extends TestBase {

    public String agentNme = null;

    @FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
    WebElement agentName;

    public FifthProperty() {
        PageFactory.initElements(driver, this);
    }

    public AgentPage clickOnAgentName() {
        agentNme = agentName.getText();
        agentName.click();
        return new AgentPage();
    }
}
