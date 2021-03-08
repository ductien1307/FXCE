package gmail.testCases;

import core.AbstractTest;
import gmail.actions.GMailPO;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Gmail extends AbstractTest {

    public GMailPO gMailPO;

    @BeforeClass()
    public void beforeClass() {
        gMailPO = new GMailPO(driver);
    }


    @Test(dataProvider = "data")
    public void checkInbox(String id, String password, String title, String link) {
        try {
            gMailPO.login(id, password);
            gMailPO.checkInbox(title, link);
        } catch (Throwable e) {
            Reporter.getCurrentTestResult().setThrowable(e);
        }
    }

    @DataProvider(name = "data")
    public Object[][] data(Method method) {
        Object[][] result = null;
        if (method.getName().equals("checkInbox")) {
            result = new Object[][]{
                    {"", "", "[Live Webinar] Progressive Web Apps Testing", ">> Join Now (Limited Seats) <<"}
            };
        }
        return result;
    }
}
