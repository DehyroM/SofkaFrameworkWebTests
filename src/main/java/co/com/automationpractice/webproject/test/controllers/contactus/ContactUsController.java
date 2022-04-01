package co.com.automationpractice.webproject.test.controllers.contactus;

import co.com.automationpractice.webproject.test.model.Customer;
import co.com.automationpractice.webproject.test.page.contactus.ContactUsPage;
import co.com.automationpractice.webproject.test.page.contactus.SendToCostumerServicePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.*;
import static co.com.automationpractice.webproject.test.helpers.Helper.*;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TWENTY_SECONDS;

public class ContactUsController {

    private WebAction webAction;
    private Customer customer;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void llenarFormularioDeContacto(){
        try{
            customer = generateCustomerForContactUs(EMAIL_DOMAIN);
            String randomSubjectOption = randomNumber();

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.click(contactUsPage.getContactUsLink(), TWENTY_SECONDS.getValue(),true);

            webAction.moveTo(contactUsPage.getContactEmail(), TWENTY_SECONDS.getValue(), true);
            webAction.sendText(contactUsPage.getContactEmail(),customer.getEmail(),TWENTY_SECONDS.getValue(),true);

            commonActions(randomSubjectOption, contactUsPage);

        } catch (WebActionsException e) {
            Report.reportFailure(FILL_CONTACT_US_ERROR, e);
        }
    }

    public void llenarFormularioDeContactoSinEmail(){
        try{
            customer = generateCustomerForContactUs(EMAIL_DOMAIN);
            String randomSubjectOption = randomNumber();

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            webAction.click(contactUsPage.getContactUsLink(), TWENTY_SECONDS.getValue(),true);

            commonActions(randomSubjectOption, contactUsPage);

        } catch (WebActionsException e) {
            Report.reportFailure(FILL_CONTACT_US_ERROR, e);
        }
    }

    private void commonActions (String randomSubjectOption, ContactUsPage contactUsPage) throws WebActionsException {

        webAction.moveTo(contactUsPage.getOrderReference(), TWENTY_SECONDS.getValue(), true);
        webAction.sendText(contactUsPage.getOrderReference(),customer.getOrder(),TWENTY_SECONDS.getValue(),true);

        webAction.moveTo(contactUsPage.getContactMessage(), TWENTY_SECONDS.getValue(), true);
        webAction.sendText(contactUsPage.getContactMessage(),customer.getMessage(),TWENTY_SECONDS.getValue(),true);

        webAction.moveTo(contactUsPage.getSubjectHeading(), TWENTY_SECONDS.getValue(), true);

        if (randomSubjectOption.equals("3")){
            webAction.selectByPartialText(contactUsPage.getSubjectHeading(),CUSTOMER_SERVICE,TWENTY_SECONDS.getValue(), true);
        }else{
            webAction.selectByValue(contactUsPage.getSubjectHeading(),randomSubjectOption, TWENTY_SECONDS.getValue(), true);
        }

        webAction.moveTo(contactUsPage.getSendBtn(), TWENTY_SECONDS.getValue(), true);
        webAction.click(contactUsPage.getSendBtn(), TWENTY_SECONDS.getValue(),true);
    }

    public String obtenerMensajeEmailInvalido(){

        String mensajeDeEmailInvalido = EMPTY_STRING;
        try{

            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            mensajeDeEmailInvalido = webAction
                    .getText(contactUsPage
                            .getInvalidEmailMessage(),TWENTY_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(EMAIL_ERROR, e);
        }

        return mensajeDeEmailInvalido;
    }
}
