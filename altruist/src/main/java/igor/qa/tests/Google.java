package igor.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.Assert;

public class Google {
    private WebDriver driver;

    @Parameters("baseUrl")
    @BeforeMethod
    public void setUp(String baseUrl) {
        driver = new ChromeDriver();
        driver.get(baseUrl + "/finance");
    }

    @Test
    public void testLandingUrl() {
        String expectedTitle = "Google Finance - Stock Market Prices, Real-time Quotes & Business News";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test(enabled = false)
    public void testRetrieveStocks() {

    }

    @AfterMethod
    public void tearDown() {

        // driver.quit();
    }

}
