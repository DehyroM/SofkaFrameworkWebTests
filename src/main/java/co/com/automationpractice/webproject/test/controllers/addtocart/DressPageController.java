package co.com.automationpractice.webproject.test.controllers.addtocart;

import co.com.automationpractice.webproject.test.page.DressesPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.DRESSES_PAGE_ERROR;
import static co.com.automationpractice.webproject.test.helpers.Seconds.TEN_SECONDS;

public class DressPageController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void seleccionarUnProducto(){
        try{
            DressesPage dressesPage = new DressesPage(webAction.getDriver());

            webAction.click(dressesPage.getDresses(), TEN_SECONDS.getValue(),true);
            webAction.moveTo(dressesPage.getCategorySummer(), TEN_SECONDS.getValue(), true);
            webAction.click(dressesPage.getCategorySummer(), TEN_SECONDS.getValue(), true);
            webAction.moveTo(dressesPage.getStockBtn(), TEN_SECONDS.getValue(), true);
            webAction.clickNotVisible(dressesPage.getAddPrintedDress(), TEN_SECONDS.getValue(), true);
            webAction.click(dressesPage.getProceedToCheckoutBtnDress(), TEN_SECONDS.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure(DRESSES_PAGE_ERROR, e);
        }
    }

}
