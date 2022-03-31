package co.com.automationpractice.webproject.test.page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendToCostumerServicePage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement sendToCostumerServiceMessage;

    public WebElement getSendToCostumerServiceMessage() {
        return sendToCostumerServiceMessage;
    }

    public SendToCostumerServicePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
