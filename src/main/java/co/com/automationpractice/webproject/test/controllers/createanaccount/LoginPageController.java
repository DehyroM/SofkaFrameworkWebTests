package co.com.automationpractice.webproject.test.controllers.createanaccount;

import co.com.automationpractice.webproject.test.page.LandingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.LOGIN_PAGE_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Seconds.FIVE_SECONDS;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TEN_SECONDS;

public class LoginPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaLoginPage(){
        try{
            LandingPage landingPage = new LandingPage(webAction.getDriver());

            webAction.click(landingPage.getSignIn(),TEN_SECONDS.getValue(),true);

        } catch (WebActionsException e) {
            Report.reportFailure(LOGIN_PAGE_ERROR, e);
        }
    }
}
