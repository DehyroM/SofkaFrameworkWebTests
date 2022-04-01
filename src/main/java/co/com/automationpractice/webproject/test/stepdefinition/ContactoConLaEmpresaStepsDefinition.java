package co.com.automationpractice.webproject.test.stepdefinition;

import co.com.automationpractice.webproject.test.controllers.contactus.ContactUsController;
import co.com.automationpractice.webproject.test.controllers.contactus.SendToCostumerServiceController;
import co.com.automationpractice.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.automationpractice.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.CUSTOMER_SERVICE_CONFIRMATION;
import static co.com.automationpractice.webproject.test.helpers.Dictionary.EMAIL_ERROR_MESSAGE;

public class ContactoConLaEmpresaStepsDefinition extends Setup{

    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente ingresa al Home de Automation Practice")
    public void queElClienteIngresaAlHomeDeAutomationPractice() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.abrirTiendaOnline();

    }

    @Cuando("el cliente ingresa a la sección Contact Us y llena los campos obligatorios del formulario")
    public void elClienteIngresaALaSeccionContactUsYLlenaLosCamposObligatoriosDelFormulario() {

        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.llenarFormularioDeContacto();
    }

    @Entonces("el cliente visualizará un mensaje de confirmación de envio de la solicitud")
    public void elClienteVisualizaraUnMensajeDeConfirmacionDeEnvioDeLaSolicitud() {

        SendToCostumerServiceController sendToCostumerServiceController = new SendToCostumerServiceController();
        sendToCostumerServiceController.setWebAction(webAction);

        String confirmationMessage = sendToCostumerServiceController.obtenerMensajeDeContacto();

        Assert
                .Hard
                .thatString(confirmationMessage)
                .isEqualTo(CUSTOMER_SERVICE_CONFIRMATION);
    }

    @Cuando("el cliente ingresa a la sección Contact Us y llena campos del formulario sin agregar un email")
    public void elClienteIngresaALaSeccionContactUsYLlenaCamposDelFormularioSinAgregarUnEmail() {

        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);
        contactUsController.llenarFormularioDeContactoSinEmail();
    }

    @Entonces("el cliente visualizará un mensaje de error de email inválido")
    public void elClienteVisualizaraUnMensajeDeErrorDeEmailInvalido() {

        ContactUsController contactUsController = new ContactUsController();
        contactUsController.setWebAction(webAction);

        String confirmationMessage = contactUsController.obtenerMensajeEmailInvalido();

        Assert
                .Hard
                .thatString(confirmationMessage)
                .isEqualTo(EMAIL_ERROR_MESSAGE);
    }

    @After
    public void cerrarDriver() {

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
