package PageObject.PageSteps;

import io.qameta.allure.Step;

import static PageObject.PageElements.AuthorizationPageElem.*;
import static Utils.Configuration.getConfigurationValue;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;


public class AuthorizationPageSteps {

    @Step("Открываем страницу по ссылке {url}")
    public static void openUrl(String url) {
        open(url);
    }


    @Step("Авторизуемся в системе {login}")
    public static void authorization(String login) {
        $x(loginLane).sendKeys(getConfigurationValue("Login"));
        $x(passwordLane).sendKeys(getConfigurationValue("Password"));
        $x(buttonLogIn).click();
    }
}
