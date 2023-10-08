import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Configuration.*;

public class Configuration {

    @BeforeMethod(groups = {"Regression1", "Regression2"})
    public void ConfigTests() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browserCapabilities = options;
        browserSize = null;
        assertionMode = SOFT;
        timeout = 4000;
        screenshots=true;
        savePageSource=false;
        holdBrowserOpen=false;

    }



    @AfterMethod(groups = {"Regression1", "Regression2"})
    public void afterMethod() {
        Selenide.closeWebDriver();
    }
}
