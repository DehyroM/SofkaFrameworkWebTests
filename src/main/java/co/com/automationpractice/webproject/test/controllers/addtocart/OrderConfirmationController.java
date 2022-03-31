package co.com.automationpractice.webproject.test.controllers.addtocart;

import co.com.automationpractice.webproject.test.page.addtocart.OrderConfirmationPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static co.com.automationpractice.webproject.test.helpers.Dictionary.ORDER_CONFIRMATION_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class OrderConfirmationController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeDeConfirmacion(){

        String mensajeDeConfirmacion = EMPTY_STRING;
        try{

            OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(webAction.getDriver());

            mensajeDeConfirmacion = webAction.getText(orderConfirmationPage.getOrderConfirmationMessage(),TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(ORDER_CONFIRMATION_ERROR, e);
        }

        return mensajeDeConfirmacion;
    }

}
