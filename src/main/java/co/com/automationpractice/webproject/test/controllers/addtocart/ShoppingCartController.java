package co.com.automationpractice.webproject.test.controllers.addtocart;

import co.com.automationpractice.webproject.test.page.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.SHOPPING_CART_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TEN_SECONDS;

public class ShoppingCartController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void procederAgregarProducto(){
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutBtnCart(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutBtnCart(), TEN_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutSecondStep(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutSecondStep(), TEN_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getAgreeTermsCondition(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getAgreeTermsCondition(), TEN_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutThirdStep(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutThirdStep(), TEN_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getPayByBankOption(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getPayByBankOption(), TEN_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getConfirmOrderBtn(), TEN_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getConfirmOrderBtn(), TEN_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(SHOPPING_CART_ERROR, e);
        }
    }

}
