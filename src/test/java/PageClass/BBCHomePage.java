package PageClass;

import Common.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BBCHomePage
{
    public  WebDriver driver;
    Utility utility;

    @FindBy(tagName = "a")
    List<WebElement> allLinks;
    @FindBy(xpath = "//a[text()='News']/parent::h2/following-sibling::div//a[@class='media__link']")
    List<WebElement> newsLinks;
    @FindBy(xpath = "//a[text()='News']/parent::h2/following-sibling::div//p[@class='media__summary']")
    List<WebElement> topics;


    public BBCHomePage(WebDriver driver)
    {

        this.driver = driver;
        utility=new Utility();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public void printAllLink()
    {
        for (WebElement e:allLinks)
        {
            System.out.println(e.getText());
        }

    }
    public void newslinks() throws IOException {
        System.out.println("News Headings");
        utility.ScreenShot();
        for (WebElement e:newsLinks)
        {
            System.out.println(e.getText());

        }
        System.out.println("News Topics");
        for (WebElement p:topics)
        {
            System.out.println(p.getText());

        }
    }
    public void printNewsLinks() throws IOException {
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        System.out.println("News Headings");
        utility.ScreenShot();
        for (WebElement e:newsLinks)
        {
            System.out.println(e.getText());
            list1.add(e.getText());
        }
        System.out.println("News Topics");
        for (WebElement p:topics)
        {
            System.out.println(p.getText());
            list2.add(p.getText());
        }
        utility.writeExcel(list1,list2);
    }
}
