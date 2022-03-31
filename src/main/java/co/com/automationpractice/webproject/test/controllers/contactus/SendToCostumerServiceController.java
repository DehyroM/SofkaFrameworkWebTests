package co.com.automationpractice.webproject.test.controllers.contactus;

import co.com.automationpractice.webproject.test.page.contactus.SendToCostumerServicePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.*;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class SendToCostumerServiceController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeDeContacto(){

        String mensajeDeConfirmacionDeContacto = EMPTY_STRING;
        try{

            SendToCostumerServicePage sendToCostumerServicePage= new SendToCostumerServicePage(webAction.getDriver());

            mensajeDeConfirmacionDeContacto = webAction
                    .getText(sendToCostumerServicePage
                            .getSendToCostumerServiceMessage(),TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(CONTACT_CONFIRMATION_ERROR, e);
        }

        return mensajeDeConfirmacionDeContacto;
    }

}
