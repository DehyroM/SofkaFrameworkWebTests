package co.com.automationpractice.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement womenLink;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"ul_layered_category_0\"]/li[1]/label")
    WebElement topsOption;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/span/span")
    WebElement inStockBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]/span")
    WebElement productMoreBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"quantity_wanted_p\"]/a[2]")
    WebElement plusBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"attributes\"]/fieldset[1]/div")
    WebElement selectSizeOption;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    WebElement addToCartBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckoutBtn;

    public WebElement getWomenLink() {
        return womenLink;
    }

    public WebElement getTopsOption() {
        return topsOption;
    }

    public WebElement getInStockBtn() {
        return inStockBtn;
    }

    public WebElement getProductMoreBtn() {
        return productMoreBtn;
    }

    public WebElement getPlusBtn() {
        return plusBtn;
    }

    public WebElement getSelectSizeOption() {
        return selectSizeOption;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getProceedToCheckoutBtn() {
        return proceedToCheckoutBtn;
    }

    public WomenPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
