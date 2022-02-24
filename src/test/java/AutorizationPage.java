import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AutorizationPage extends Main {

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement loginLane;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement passwordLane;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form-submit']")
    private SelenideElement buttonLogIn;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form-cancel']")
    private SelenideElement buttonCantIn;

    public AutorizationPage clicButtonLogIn() {
        loginLane.click();
        loginLane.sendKeys(login);
        return page(AutorizationPage.class);
    }
    public AutorizationPage clicButtonPassword() {
        passwordLane.click();
        passwordLane.sendKeys(password);
        return page(AutorizationPage.class);
    }

    public AutorizationPage clicButtonIn() {
        buttonLogIn.click();
        return page(AutorizationPage.class);
    }
}
