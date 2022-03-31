package co.com.automationpractice.webproject.test.controllers.addtocart;

import co.com.automationpractice.webproject.test.page.addtocart.WomenPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.WOMEN_PAGE_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Helper.randomNumber;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class WomenPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void seleccionarProductos(){
        try{
            String randomSizeOption = randomNumber();
            WomenPage womenPage = new WomenPage(webAction.getDriver());

            webAction.click(womenPage.getWomenLink(), TWENTY_SECONDS.getValue(),true);

            webAction.moveTo(womenPage.getTopsOption(), TWENTY_SECONDS.getValue(), true);
            webAction.click(womenPage.getTopsOption(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(womenPage.getInStockBtn(), TWENTY_SECONDS.getValue(), true);
            webAction.clickNotVisible(womenPage.getProductMoreBtn(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(womenPage.getPlusBtn(), TWENTY_SECONDS.getValue(), true);
            webAction.click(womenPage.getPlusBtn(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(womenPage.getSelectSizeOption(), TWENTY_SECONDS.getValue(), true);

            webAction.selectByValue(womenPage.getSelectSizeOption(),randomSizeOption, TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(womenPage.getAddToCartBtn(), TWENTY_SECONDS.getValue(), true);
            webAction.click(womenPage.getAddToCartBtn(), TWENTY_SECONDS.getValue(), true);

            webAction.click(womenPage.getProceedToCheckoutBtn(), TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(WOMEN_PAGE_ERROR, e);
        }
    }

}
