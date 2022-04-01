package co.com.automationpractice.webproject.test.controllers.createanaccount;

import co.com.automationpractice.webproject.test.model.Customer;
import co.com.automationpractice.webproject.test.page.createanaccount.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.*;
import static co.com.automationpractice.webproject.test.helpers.Helper.generateCustomer;
import static co.com.automationpractice.webproject.test.helpers.Helper.randomNumber;
import static co.com.automationpractice.webproject.test.helpers.Seconds.*;

public class CreateAnAccountWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void crearUnaCuenta(){
        try{
            Customer customer = generateCustomer(EMAIL_DOMAIN);
            String randomTitleOption = randomNumber();

            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(createAnAccountPage.getEmailAddress(), customer.getEmail(),TWENTY_SECONDS.getValue(),true);
            webAction.click(createAnAccountPage.getCreateAnAccount(), TWENTY_SECONDS.getValue(), true);

            if (randomTitleOption.equals("0")){
                webAction.click(createAnAccountPage.getMr(), TWENTY_SECONDS.getValue(), true);
            }else {
                webAction.click(createAnAccountPage.getMrs(), TWENTY_SECONDS.getValue(), true);
            }

            webAction.sendText(createAnAccountPage.getFirstName(), customer.getFirstName(),TWENTY_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getLastName(), customer.getLastName(),TWENTY_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getPassword(), customer.getPassword(),TWENTY_SECONDS.getValue(),true);
            webAction.selectByPartialText(createAnAccountPage.getDay(), customer.getDayBirth(),TWENTY_SECONDS.getValue(),true);
            webAction.selectByValue(createAnAccountPage.getMonth(), customer.getMonthBirth(),TWENTY_SECONDS.getValue(),true);
            webAction.selectByPartialText(createAnAccountPage.getYear(), customer.getYearBirth(),TWENTY_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getAddress1(), customer.getAddress(),TWENTY_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getCity(), customer.getCity(),TWENTY_SECONDS.getValue(),true);
            webAction.selectByText(createAnAccountPage.getState(), customer.getState(),TWENTY_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getPostCode(), customer.getPostalCode(),TWENTY_SECONDS.getValue(),true);
            webAction.sendText(createAnAccountPage.getPhoneMobile(), customer.getMobilePhone(),TWENTY_SECONDS.getValue(),true);
            webAction.moveTo(createAnAccountPage.getAlias(), TWENTY_SECONDS.getValue(), true);
            webAction.clearText(createAnAccountPage.getAlias(), TWENTY_SECONDS.getValue(), true);
            webAction.sendText(createAnAccountPage.getAlias(), customer.getAlias(),TWENTY_SECONDS.getValue(),true);
            webAction.click(createAnAccountPage.getRegister(),TWENTY_SECONDS.getValue(),true);

        } catch (WebActionsException e) {
            Report.reportFailure(CREATE_ACCOUNT_ERROR, e);
        }
    }
}
