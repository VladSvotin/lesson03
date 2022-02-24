import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//h1[text()='System Dashboard']")
    private SelenideElement header;
    @FindBy(how = How.XPATH, using = "//div[@class='ghx-issue-count']")
    private SelenideElement problemValue;
    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='ghx-issue-content']"))
    private List<WebElement> task;


    public MainPage isOpened() {
        header.exists();
        return page(MainPage.class);
    }

    public MainPage compareTasks() {

        int pvalue = Integer.parseInt(problemValue.text().split(" ")[0]);
        System.out.println("Количество задач в шапке проекта = " + pvalue);

        int xvalue = task.size();
        System.out.println("Количество заведённых задач = " + xvalue);



        Assert.assertEquals(pvalue, xvalue);
        return page(MainPage.class);
    }
}
