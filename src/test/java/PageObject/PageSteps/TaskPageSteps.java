package PageObject.PageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static PageObject.PageElements.MainPageElem.*;
import static PageObject.PageElements.TaskPageElem.*;
import static Utils.Configuration.getConfigurationValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskPageSteps {

    @Step("Создание задачи")
    public static void createTask() {
        $x(buttonCreateTask).click();
        $x(nameTask).sendKeys(getConfigurationValue("nameTask"));
        $x(taskInfo).sendKeys(getConfigurationValue("taskInfoText"));
        $x(buttonSubmit).click();
    }

    @Step("Переход на страницу новой задачи")
    public static void openNewTask() {
        $x(newTask).click();
    }

    @Step("Перевод задачи в работу и отмечаем выполненной")
    public static void statNewTask() {
        $x(taskStatusButton).click();
        $x(taskStatusList).click();
        $x(taskStatusDone).click();
    }

    @Step("Проверка статуса задачи")
    public static void checkNewTask() {
        assertTrue($x(taskStatusDone).shouldBe(visible, Duration.ofSeconds(60)).exists());
        $x(taskCheckStatus).shouldBe(Condition.text("ГОТОВО"));
    }
}