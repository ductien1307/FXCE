package reneFX.testCases;

import core.AbstractTest;
import core.config.Domains;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reneFX.actions.DashBoardPO;
import reneFX.actions.RegisterPO;
import data.GeneFX;
import yopMail.actions.YopMailPO;

import java.lang.reflect.Method;

public class Register extends AbstractTest {

    public RegisterPO registerPO;
    public DashBoardPO dashBoardPO;
    public YopMailPO yopMailPO;

    @BeforeClass()
    public void beforeClass() {
        registerPO = new RegisterPO(driver);
        dashBoardPO = new DashBoardPO(driver);
        yopMailPO = new YopMailPO(driver);
        GeneFX.USERNAME = "auto." + Domains.ENVIRONMENT + "." + getEmailRandom();
        GeneFX.PASSWORD = "Auto@123";
    }

    @Test(dataProvider = "data")
    public void validInfo(String username, String password, String rePassword) throws InterruptedException {
        registerPO.gotoRegisterPage();
        registerPO.inputUsername(username);
        registerPO.inputPassword(password);
        registerPO.inputRePassword(rePassword);
        registerPO.checkPolicyALL();
        registerPO.clickRegister();
        sleep(2);
        yopMailPO.gotoYopMailPage();
        yopMailPO.inputEmail(username);
        yopMailPO.clickCheckInbox();
        boolean checkInbox = yopMailPO.checkInbox("Xác thực đăng ký tài khoản", "Xác thực tài khoản");
        verifyTrue(checkInbox);
        closeTab(driver);
    }

    @DataProvider(name = "data")
    public Object[][] data(Method method) {
        Object[][] result = null;

        if (method.getName().equals("validInfo")) {
            result = new Object[][]{
                    {GeneFX.USERNAME, GeneFX.PASSWORD, GeneFX.PASSWORD},
            };
        }
        return result;
    }
}
