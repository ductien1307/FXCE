package reneFX.actions;

import core.AbstractPage;
import core.config.Domain;
import data.FunctionName;
import org.openqa.selenium.WebDriver;
import reneFX.interfaces.RegisterUI;

public class RegisterPO extends AbstractPage {

    WebDriver driver;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoRegisterPage() {
        openAnyUrl(driver, Domain.HOME + FunctionName.REGISTER);
    }

    public void inputUsername(String username) {
        sendKeyToElement(driver, RegisterUI.USERNAME_TXT, username);
    }

    public void inputPassword(String password) {
        sendKeyToElement(driver, RegisterUI.PASSWORD_TXT, password);
    }

    public void inputRePassword(String rePassword) {
        sendKeyToElement(driver, RegisterUI.RE_PASSWORD_TXT, rePassword);
    }

    public void checkPolicyALL() {
        for (int i = 1; i <= 3; i++) {
            clickToElement(driver, xpathDynamic(RegisterUI.POLICY_CHK, String.valueOf(i)));
        }
    }

    public void clickRegister() {
        clickToElement(driver, RegisterUI.REGISTER_BTN);
    }

}
