package igor.qa.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.Assert;

public class Google {
    private WebDriver driver;

    @Parameters("baseUrl")
    @BeforeMethod
    public void setUp(String baseUrl) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get(baseUrl + "/finance");
    }

    @Test
    public void testGoogleStocksList() {
        String expectedTitle = "Google Finance - Stock Market Prices, Real-time Quotes & Business News";
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA");

        WebElement stocksTable = driver
                .findElement(By.cssSelector("section[aria-labelledby='smart-watchlist-title']"));
        List<WebElement> actualStockSymbolsWebElement = stocksTable.findElements(By.className("COaKTb"));

        ArrayList<WebElement> actualStockSymbols = new ArrayList<>(actualStockSymbolsWebElement);

        List<String> actualStockSymbolTexts = new ArrayList<>();
        for (WebElement symbolElement : actualStockSymbols) {
            actualStockSymbolTexts.add(symbolElement.getText());
        }

        // printing all stocks that are in 3 but not in expected list
        for (String actualSymbol : actualStockSymbolTexts) {
            if (!expectedStockSymbols.contains(actualSymbol)) {
                System.out.println("Task 5)" + actualSymbol);
            }
        }
        // printing all stocks that are in expected but not in actual
        for (String expectedSymbol : expectedStockSymbols) {
            if (!actualStockSymbolTexts.contains(expectedSymbol)) {
                System.out.println("Task 6) " + expectedSymbol);
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
