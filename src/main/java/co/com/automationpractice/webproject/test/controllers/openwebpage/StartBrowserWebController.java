package co.com.automationpractice.webproject.test.controllers.openwebpage;

import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.*;
import static co.com.automationpractice.webproject.test.helpers.Helper.getProperty;

public class StartBrowserWebController {

    private WebAction webAction;
    private String feature;
    private Browser browser;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void abrirTiendaOnline(){

        try {
            webAction.startWebApp(browser, getProperty(APP_URL_PROPERTY), feature);

        }catch (WebActionsException e){
            Report.reportFailure(START_BROWSER_ERROR, e);

        }
    }
}
