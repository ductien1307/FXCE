package reneFX.testCases;

import data.GeneFX;
import org.testng.annotations.*;
import reneFX.actions.DashBoardPO;
import reneFX.actions.LoginPO;
import core.AbstractTest;

import java.lang.reflect.Method;

public class Login extends AbstractTest {

    public LoginPO loginPO;
    public DashBoardPO dashBoardPO;

    @BeforeClass()
    public void beforeClass() {
        loginPO = new LoginPO(driver);
        dashBoardPO = new DashBoardPO(driver);
    }

    @Test(dataProvider = "data")
    public void validAccount(String username, String password) {
        dashBoardPO.gotoLoginPage();
        loginPO.inputUserName(username);
        loginPO.inputPassWord(password);
        loginPO.clickLogin();
        verifyEquals(dashBoardPO.getUserName(), username);
    }

    @Parameters({"username", "password"})
    @Test
    public void existAccount(@Optional String username, @Optional String password) throws InterruptedException {
        dashBoardPO.gotoLoginPage();
        loginPO.inputUserName(username);
        loginPO.inputPassWord(password);
        loginPO.clickLogin();
        log.info(getCurrentUrl(driver));
        log.info(dashBoardPO.getUserName());
        verifyEquals(dashBoardPO.getUserName(), username);
    }

    @DataProvider(name = "data")
    public Object[][] data(Method method) {
        Object[][] result = null;
        if (method.getName().equals("validAccount")) {
            result = new Object[][]{
                    {GeneFX.USERNAME, GeneFX.PASSWORD},
            };
        }
        return result;
    }
}
