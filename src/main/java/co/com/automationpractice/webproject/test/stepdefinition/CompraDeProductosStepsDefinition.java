package co.com.automationpractice.webproject.test.stepdefinition;

import co.com.automationpractice.webproject.test.controllers.addtocart.*;
import co.com.automationpractice.webproject.test.controllers.createanaccount.CreateAnAccountWebController;
import co.com.automationpractice.webproject.test.controllers.createanaccount.LoginPageController;
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

import static co.com.automationpractice.webproject.test.helpers.Dictionary.ORDER_CONFIRMATION;
import static co.com.automationpractice.webproject.test.helpers.Dictionary.TERMS_OF_SERVICE_MESSAGE;

public class CompraDeProductosStepsDefinition extends Setup{

    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el cliente ingresa al home principal de Automation Practice")
    public void queElClienteIngresaAlHomePrincipalDeAutomationPractice() {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.abrirTiendaOnline();

        LoginPageController loginPageController = new LoginPageController();
        loginPageController.setWebAction(webAction);
        loginPageController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();

    }
    @Cuando("el cliente ingresa a la secci??n de vestidos, selecciona un articulo y lo agrega al carrito de compras")
    public void elClienteIngresaALaSeccionDeVestidosSeleccionaUnArticuloYLoAgregaAlCarritoDeCompras() {

        DressPageController dressPageController= new DressPageController();
        dressPageController.setWebAction(webAction);
        dressPageController.seleccionarUnProducto();

        ShoppingCartController shoppingCartController = new ShoppingCartController();
        shoppingCartController.setWebAction(webAction);
        shoppingCartController.agregarProducto();

    }
    @Entonces("el cliente visualizar?? un mensaje de confirmaci??n de la orden de compra")
    public void elClienteVisualizaraUnMensajeDeConfirmacionDeLaOrdenDeCompra() {

        OrderConfirmationController orderConfirmationController = new OrderConfirmationController();
        orderConfirmationController.setWebAction(webAction);

        String confirmationMessage = orderConfirmationController.obtenerMensajeDeConfirmacion();

        Assert
                .Hard
                .thatString(confirmationMessage)
                .isEqualTo(ORDER_CONFIRMATION);

    }

    @Cuando("el cliente ingresa a la secci??n WOMEN, agrega dos articulos al carrito de compras sin checkear los t??rminos y condiciones")
    public void elClienteIngresaALaSeccionWomenAgregaDosArticulosAlCarritoDeComprasSinCheckearLosTerminosYCondiciones() {

        WomenPageController womenPageController= new WomenPageController();
        womenPageController.setWebAction(webAction);
        womenPageController.seleccionarProductos();

        ShoppingCartController shoppingCartController = new ShoppingCartController();
        shoppingCartController.setWebAction(webAction);
        shoppingCartController.agregarProductosSinCheckearTerminos();

    }
    @Entonces("el cliente visualizar?? un mensaje indicando que se deben aceptar los t??rminos del servicio")
    public void elClienteVisualizaraUnMensajeIndicandoQueSeDebenAceptarLosTerminosDelServicio() {

        TermsOfServiceController termsOfServiceController = new TermsOfServiceController();
        termsOfServiceController.setWebAction(webAction);

        String confirmationMessage = termsOfServiceController.obtenerMensajeDeConfirmacion();

        Assert
                .Hard
                .thatString(confirmationMessage)
                .isEqualTo(TERMS_OF_SERVICE_MESSAGE);

    }

    @After
    public void cerrarDriver(){

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
