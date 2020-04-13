import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test extends TestBase {

    public Homepage homepage;
    public PropertyPage propertyPage;
    public FifthProperty fifthProperty;
    public AgentPage agentPage;

    public Test() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homepage = new Homepage();
    }

    @org.testng.annotations.Test
    public void checkFunctionality() {
        propertyPage = homepage.searchLocation();
        propertyPage.printPropertyPriceInDescendingOrder();
        fifthProperty = propertyPage.selectFifthProperty();
        agentPage = fifthProperty.clickOnAgentName();
        String agentName = agentPage.getAgentName().split(",")[0];
        System.out.println(agentName);
        Assert.assertEquals(fifthProperty.agentNme, agentName, "Agent name is not matching");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
