package yopMail.testCases;

import core.AbstractTest;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import yopMail.actions.YopMailPO;

import java.lang.reflect.Method;

public class YopMail extends AbstractTest {

    public YopMailPO yopMailPO;

    @BeforeClass()
    public void beforeClass() {
        yopMailPO = new YopMailPO(driver);
    }


    @Test(dataProvider = "dataYopMail")
    public void checkEmail(String id, String link, String title) {
        try {
            yopMailPO.login(id);
            yopMailPO.checkInbox(link, title);
        } catch (Throwable e) {
            Reporter.getCurrentTestResult().setThrowable(e);
        }
    }

    @DataProvider(name = "dataYopMail")
    public Object[][] dataYopMail(Method method) {
        Object[][] result = null;
        if (method.getName().equals("checkEmail")) {
            result = new Object[][]{
                    {"automationjs.42dds8l0jf", "Xác thực email trênVietnamWorks", "verify?code"}
            };
        }
        return result;
    }
}
