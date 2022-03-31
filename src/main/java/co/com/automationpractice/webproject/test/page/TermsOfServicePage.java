package co.com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsOfServicePage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"order\"]/div[2]/div/div/div/div/p")
    WebElement termsOption;

    public WebElement getTermsOfServiceMessage() {
        return termsOption;
    }

    public TermsOfServicePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
