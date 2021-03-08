package reneFX.actions;

import reneFX.interfaces.LoginUI;
import org.openqa.selenium.WebDriver;
import core.AbstractPage;
import core.config.Domain;

public class LoginPO extends AbstractPage {

    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUserName(String userName) {
        sendKeyToElement(driver, LoginUI.USERNAME_TXT, userName);
    }

    public void inputPassWord(String userPass) {
        sendKeyToElement(driver, LoginUI.PASSWORD_TXT, userPass);
    }

    public void clickLogin() {
        clickToElement(driver, LoginUI.LOGIN_BTN);
    }

}
