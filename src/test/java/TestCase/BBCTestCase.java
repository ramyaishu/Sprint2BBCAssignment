package TestCase;

import Common.BaseClass;
import PageClass.BBCHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BBCTestCase extends BaseClass
{
    //public WebDriver driver;
    BBCHomePage homePage;

    @BeforeClass
    public void init()
    {
        homePage = PageFactory.initElements(driver,BBCHomePage.class);
    }
    @Test
    public void checkTitle()
    {
        System.out.println(homePage.getTitle());
    }
    @Test()
    public void BBcPageVerify() throws InterruptedException, IOException
    {
        System.out.println("Print All the Links");
        homePage.printAllLink();
        Thread.sleep(1000);
        System.out.println("Print Links and Topics Under News");
        homePage.newslinks();
        homePage.printNewsLinks();
    }

}
