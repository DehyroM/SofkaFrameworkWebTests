package co.com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    WebElement proceedToCheckoutBtnCart;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    WebElement proceedToCheckoutSecondStep;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/div/p[2]/label")
    WebElement agreeTermsCondition;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    WebElement proceedToCheckoutThirdStep;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payByBankOption;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    WebElement payByCheckOption;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    WebElement confirmOrderBtn;

    public WebElement getProceedToCheckoutBtnCart() {
        return proceedToCheckoutBtnCart;
    }

    public WebElement getProceedToCheckoutSecondStep() {
        return proceedToCheckoutSecondStep;
    }

    public WebElement getAgreeTermsCondition() {
        return agreeTermsCondition;
    }

    public WebElement getProceedToCheckoutThirdStep() {
        return proceedToCheckoutThirdStep;
    }

    public WebElement getPayByBankOption() {
        return payByBankOption;
    }

    public WebElement getPayByCheckOption() {
        return payByCheckOption;
    }

    public WebElement getConfirmOrderBtn() {
        return confirmOrderBtn;
    }

    public ShoppingCartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
