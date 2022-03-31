package co.com.automationpractice.webproject.test.controllers.createanaccount;

import co.com.automationpractice.webproject.test.helpers.Title;
import co.com.automationpractice.webproject.test.model.Customer;
import co.com.automationpractice.webproject.test.page.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.*;
import static co.com.automationpractice.webproject.test.helpers.Helper.generateCustomer;
import static co.com.automationpractice.webproject.test.helpers.Seconds.*;

public class CreateAnAccountWebController {

    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            customer = generateCustomer(EMAIL_DOMAIN);

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(createAnAccountPage.getEmailAddress(),customer.getEmail(),TEN_SECONDS.getValue(),true);
            webAction.click(createAnAccountPage.getCreateAnAccount(), TEN_SECONDS.getValue(), true);

            if (customer.getTitle().equals(Title.MR)){
                webAction.click(createAnAccountPage.getMr(), TWENTY_SECONDS.getValue(), true);
            }else if (customer.getTitle().equals(Title.MRS)){
                webAction.click(createAnAccountPage.getMrs(), TWENTY_SECONDS.getValue(), true);
            }

            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(),TEN_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(),TEN_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(),TEN_SECONDS.getValue(),true);
            webAction.selectByPartialText(createAnAccountPage.getDay(), customer.getDayBirth(),TEN_SECONDS.getValue(),true);
            webAction.selectByValue(createAnAccountPage.getMonth(), customer.getMonthBirth(),TEN_SECONDS.getValue(),true);
            webAction.selectByPartialText(createAnAccountPage.getYear(), customer.getYearBirth(),TEN_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(),TEN_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(),TEN_SECONDS.getValue(),true);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(),TEN_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(),TEN_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(),TEN_SECONDS.getValue(),true);
            webAction.moveTo(createAnAccountPage.getAlias(), TEN_SECONDS.getValue(), true);
            webAction.clearText(createAnAccountPage.getAlias(), TEN_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getAlias(), customer.getAlias(),TEN_SECONDS.getValue(),true);
            webAction.click(createAnAccountPage.getRegister(),TEN_SECONDS.getValue(),true);

        } catch (WebActionsException e) {
            Report.reportFailure(CREATE_ACCOUNT_ERROR, e);
        }
    }

}
