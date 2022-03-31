package co.com.automationpractice.webproject.test.controllers.addtocart;

import co.com.automationpractice.webproject.test.page.ShoppingCartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.MESSAGE_COMMENT;
import static co.com.automationpractice.webproject.test.helpers.Dictionary.SHOPPING_CART_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Helper.randomNumber;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class ShoppingCartController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void procederAgregarProducto(){
        try{
            int number = randomNumber();
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutBtnCart(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutBtnCart(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getAddCommentMessage(), TWENTY_SECONDS.getValue(), true);
            webAction.sendText(shoppingCartPage.getAddCommentMessage(),MESSAGE_COMMENT,TWENTY_SECONDS.getValue(),true);

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutSecondStep(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutSecondStep(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getAgreeTermsCondition(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getAgreeTermsCondition(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutThirdStep(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutThirdStep(), TWENTY_SECONDS.getValue(), true);

            if (number == 0){
                webAction.moveTo(shoppingCartPage.getPayByBankOption(), TWENTY_SECONDS.getValue(), true);
                webAction.click(shoppingCartPage.getPayByBankOption(), TWENTY_SECONDS.getValue(), true);
            }else {
                webAction.moveTo(shoppingCartPage.getPayByCheckOption(), TWENTY_SECONDS.getValue(), true);
                webAction.click(shoppingCartPage.getPayByCheckOption(), TWENTY_SECONDS.getValue(), true);
            }

            webAction.moveTo(shoppingCartPage.getConfirmOrderBtn(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getConfirmOrderBtn(), TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(SHOPPING_CART_ERROR, e);
        }
    }

    public void agregarProductosSinCheckearTerminos(){
        try{
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(webAction.getDriver());

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutBtnCart(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutBtnCart(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getAddCommentMessage(), TWENTY_SECONDS.getValue(), true);
            webAction.sendText(shoppingCartPage.getAddCommentMessage(),MESSAGE_COMMENT,TWENTY_SECONDS.getValue(),true);

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutSecondStep(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutSecondStep(), TWENTY_SECONDS.getValue(), true);

            webAction.moveTo(shoppingCartPage.getProceedToCheckoutThirdStep(), TWENTY_SECONDS.getValue(), true);
            webAction.click(shoppingCartPage.getProceedToCheckoutThirdStep(), TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(SHOPPING_CART_ERROR, e);
        }
    }



}
