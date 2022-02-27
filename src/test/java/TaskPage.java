import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class TaskPage extends Main {

    @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
    private SelenideElement buttonCreateTask;

    @FindBy(how = How.XPATH, using = "//input[@id='summary']")
    private SelenideElement NameTask;

    @FindBy(how = How.XPATH, using = "//*[@id='description']")
    private SelenideElement taskInfo;

    @FindBy(how = How.XPATH, using = "//input[@id='create-issue-submit']")
    private SelenideElement buttonSubmit;

    @FindBy(how = How.XPATH, using = "//*[@id='aui-flag-container']/div/div/a")
    private SelenideElement taskLink;

    public TaskPage clicButtonIn() {
        buttonCreateTask.click();
        return page(TaskPage.class);
    }

    public TaskPage clicNameTask() {
        NameTask.click();
        NameTask.sendKeys(nameTask);
        System.out.println("Именование задачи");
        return page(TaskPage.class);
    }

    public TaskPage clicInfo() {
        $(By.xpath("//*[@id='aui-uid-1']")).click();
        taskInfo.sendKeys(infoTask);
        System.out.println("Описание задачи");
        return page(TaskPage.class);
    }

    public TaskPage clicSubmit() {
        buttonSubmit.click();
        System.out.println("Задача создана");
        return page(TaskPage.class);
    }

    public TaskPage clicTaskLink() {
        taskLink.click();
        return page(TaskPage.class);
    }

    public TaskPage WorkTask() {
        $(By.xpath("//a[@id='action_id_21']")).click();
        System.out.println("В статусе \"В работе\"");
        $(By.xpath("//a[@id='opsbar-transitions_more']")).click();
        $(By.xpath("//a[@id='action_id_31']")).click();
        System.out.println("В статусе \"ГОТОВО\"");
        assertTrue($x("//a[@id='action_id_31']").shouldBe(visible, Duration.ofSeconds(30)).exists());
        String taskStatus = $x("//*[@id='status-val']/span").text();
        String status = "ГОТОВО";
        Assert.assertEquals(taskStatus, status);
        System.out.println("Работает корректно");
        return page(TaskPage.class);
    }


}