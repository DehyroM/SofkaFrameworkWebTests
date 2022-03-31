package co.com.automationpractice.webproject.test.controllers.addtocart;

import co.com.automationpractice.webproject.test.page.addtocart.TermsOfServicePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.EMPTY_STRING;
import static co.com.automationpractice.webproject.test.helpers.Dictionary.TERMS_OF_SERVICE_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class TermsOfServiceController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerMensajeDeConfirmacion(){

        String mensajeDeConfirmacion = EMPTY_STRING;
        try{

            TermsOfServicePage termsOfServicePage = new TermsOfServicePage(webAction.getDriver());

            mensajeDeConfirmacion = webAction.getText(termsOfServicePage.getTermsOfServiceMessage(),TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(TERMS_OF_SERVICE_ERROR, e);
        }

        return mensajeDeConfirmacion;
    }
}
