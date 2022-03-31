package co.com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement dresses;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"ul_layered_category_0\"]/li[3]")
    WebElement categorySummer;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/span/span")
    WebElement stockBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]/span")
    WebElement addPrintedDress;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement proceedToCheckoutBtnDress;

    public WebElement getDresses() {
        return dresses;
    }

    public WebElement getCategorySummer() {
        return categorySummer;
    }

    public WebElement getStockBtn() {
        return stockBtn;
    }

    public WebElement getAddPrintedDress() {
        return addPrintedDress;
    }

    public WebElement getProceedToCheckoutBtnDress() {
        return proceedToCheckoutBtnDress;
    }

    public DressesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
