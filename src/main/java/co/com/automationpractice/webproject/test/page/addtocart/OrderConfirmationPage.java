package co.com.automationpractice.webproject.test.page.addtocart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    WebElement orderConfirmationMessage;

    public WebElement getOrderConfirmationMessage() {
        return orderConfirmationMessage;
    }

    public OrderConfirmationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
