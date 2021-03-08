package reneFX.actions;

import core.config.Domain;
import data.FunctionName;
import reneFX.interfaces.DashBoardUI;
import org.openqa.selenium.WebDriver;
import core.AbstractPage;

public class DashBoardPO extends AbstractPage {

    WebDriver driver;

    public DashBoardPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName() {
        return getTextElement(driver, DashBoardUI.USER_NAME);
    }

    public void gotoLoginPage() {
        openAnyUrl(driver, Domain.HOME + FunctionName.LOGIN);
    }

    public void gotoSettingPage() {
        openAnyUrl(driver, Domain.HOME + FunctionName.SETTING);
    }
}
