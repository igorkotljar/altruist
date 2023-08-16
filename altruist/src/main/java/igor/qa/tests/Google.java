package igor.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Google {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Parameters("baseUrl")
    @Test
    public void testGoogleSearch(String baseUrl) {
        // Navigate to Google
        driver.get(baseUrl);

    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}
