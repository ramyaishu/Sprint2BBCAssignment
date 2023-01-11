package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseClass
{
    public static WebDriver driver ;
    ConfigFile configFile;

    @BeforeSuite
    public void initBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        configFile=new ConfigFile();
        driver.get(configFile.url());

    }

    @BeforeTest
    public void printBeforeTest() {
        System.out.println("Test Started");
    }


    @AfterTest
    public void printAfterTest() {
        System.out.println("Test Exited");
    }

    @AfterTest
    @AfterSuite
    public void quitBrowser() {
        driver.quit();
    }


}
