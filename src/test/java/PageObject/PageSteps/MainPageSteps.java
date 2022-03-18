package PageObject.PageSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static PageObject.PageElements.MainPageElem.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;


public class MainPageSteps {

    @Step("Переход на страницу задач")
    public static void openTasksList() {
        $x(projectsLink).click();
        $x(testsLink).click();
        $x(testsSection).click();
    }

    @Step("Проверяем кол-во отображаемых задач с общим кол-вом задач")
    public static void findTasksCount() {
        int tasksValue = Integer.parseInt(($x(tasksCount).text().split(" "))[0]);
        int contentValue = $$(By.xpath(content)).size();

        Assertions.assertEquals(tasksValue, contentValue);
    }

}
