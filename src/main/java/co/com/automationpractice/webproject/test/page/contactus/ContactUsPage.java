package co.com.automationpractice.webproject.test.page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    WebElement contactUsLink;

    @CacheLookup
    @FindBy(id = "email")
    WebElement contactEmail;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement orderReference;

    @CacheLookup
    @FindBy(id = "message")
    WebElement contactMessage;

    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement sendBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li")
    WebElement invalidEmailMessage;

    public WebElement getContactUsLink() {
        return contactUsLink;
    }

    public WebElement getContactEmail() {
        return contactEmail;
    }

    public WebElement getOrderReference() {
        return orderReference;
    }

    public WebElement getContactMessage() {
        return contactMessage;
    }

    public WebElement getSubjectHeading() {
        return subjectHeading;
    }

    public WebElement getSendBtn() {
        return sendBtn;
    }

    public WebElement getInvalidEmailMessage() {
        return invalidEmailMessage;
    }

    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
