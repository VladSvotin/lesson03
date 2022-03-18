package steps.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageObject.PageSteps.AuthorizationPageSteps.*;
import static PageObject.PageSteps.MainPageSteps.*;
import static PageObject.PageSteps.TaskPageSteps.*;
import static Utils.Configuration.getConfigurationValue;

public class Jira {

    @Test
    @Tag("Jira")
    @DisplayName("Проверяем количество заведенных задач")
    public void Test1() {
        openUrl(getConfigurationValue("JiraUrl"));
        authorization(getConfigurationValue("Login"));
        openTasksList();
        findTasksCount();
    }

    @Test
    @Tag("Jira")
    @DisplayName("Проверяем создалась ли новая задача,а так же изменение ее статуса")
    public void Test2() {
        openUrl(getConfigurationValue("JiraUrl"));
        authorization(getConfigurationValue("Login"));
        createTask();
        openNewTask();
        statNewTask();
        checkNewTask();
    }
}
