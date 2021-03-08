package gmail.actions;

import core.AbstractPage;
import gmail.interfaces.GmailHomeUI;
import gmail.interfaces.SignInGoogleUI;
import gmail.interfaces.SignInGoogleUI2;
import org.openqa.selenium.WebDriver;


public class GMailPO extends AbstractPage {

    WebDriver driver;

    public GMailPO(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String id, String password) throws InterruptedException {
        openAnyUrl(driver, "http://mail.google.com/");
        sendKeyToElement(driver, SignInGoogleUI.INDENTIFIER_ID, id);
        clickToElement(driver, SignInGoogleUI.INDENTIFIER_NEXT);
        Thread.sleep(5000);
        sendKeyToElement(driver, SignInGoogleUI2.PASSWORD, password);
        Thread.sleep(1000);
        clickByJS(driver, SignInGoogleUI2.PASSWORD_NEXT);
        Thread.sleep(5000);
    }

    public void checkInbox(String title, String link) throws InterruptedException {
        clickToElement(driver, xpathDynamic(GmailHomeUI.EMAIL_TITLE, title));
        Thread.sleep(5000);
        clickByText(driver, link);
        Thread.sleep(5000);
    }
}
