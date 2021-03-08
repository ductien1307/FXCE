package yopMail.actions;

import core.AbstractPage;
import core.ConstXPath;
import org.openqa.selenium.WebDriver;
import yopMail.interfaces.HomeYopMailUI;


public class YopMailPO extends AbstractPage {

    WebDriver driver;

    public YopMailPO(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String id) throws InterruptedException {
        openAnyUrl(driver, "http://www.yopmail.com/en/");
        Thread.sleep(5000);
        sendKeyToElement(driver, HomeYopMailUI.ID_TXT, id);
        waitForElementClickable(driver, HomeYopMailUI.SUBMIT_BTN);
        clickToElement(driver, HomeYopMailUI.SUBMIT_BTN);
    }

    public void gotoYopMailPage(){
        openAnyUrl(driver, "http://www.yopmail.com/en/");
    }

    public void inputEmail(String email){
        sendKeyToElement(driver, HomeYopMailUI.ID_TXT, email);
    }

    public void clickCheckInbox(){
        clickToElement(driver, HomeYopMailUI.SUBMIT_BTN);
    }

    public Boolean checkInbox(String title, String link) {
        Boolean flag = true;
        try {
            switchToFrame(driver, "ifinbox");
            waitForElementClickable(driver, xpathDynamic(ConstXPath.XPATH_BY_TEXT, title));
            clickByText(driver, title);
            defaultContent(driver);
            Thread.sleep(5000);
            switchToFrame(driver, "ifmail");
            waitForElementClickable(driver, xpathDynamic(ConstXPath.XPATH_BY_TEXT, link));
            clickByText(driver, link);
            Thread.sleep(5000);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
