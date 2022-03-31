package co.com.automationpractice.webproject.test.helpers;

public class Dictionary {

    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";
    public static final String EMAIL_DOMAIN = "@gmail.com";
    public static final String FILE_EVIDENCE_PROPERTY = "files.evidence";
    public static final String APP_URL_PROPERTY = "app.url";
    public static final String PROPERTIES_FILE_BASE_PATH = "src/main/resources/properties/";
    public static final String CONFIGURATION_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "configuration.properties";
    public static final String MAIL_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "mail.properties";
    public static final String PROPERTIES_ERROR = "Fallo al consultar una propiedad del archivo ";

    public static final String CREATE_ACCOUNT_ERROR = "Ocurrio un error al intentar crear una cuenta: ";
    public static final String START_BROWSER_ERROR = "Ocurrio un error al intentar abrir la pagina online: ";
    public static final String LOGIN_PAGE_ERROR = "Ocurrio un error al intentar abrir la tienda online: ";

    public static final String MESSAGE_COMMENT = "I would like to receive the product as soon as possible!";

    public static final String DRESSES_PAGE_ERROR = "Ocurrio un error durante el proceso de selección de articulos en la página DRESSES: ";
    public static final String WOMEN_PAGE_ERROR = "Ocurrio un error durante el proceso de selección de articulos en la página WOMEN: ";

    public static final String ORDER_CONFIRMATION_ERROR = "Ocurrio un error al intentar confirmar la orden de compra: ";
    public static final String TERMS_OF_SERVICE_ERROR = "Ocurrio un error al intentar confirmar los terminos del servicio: ";

    public static final String SHOPPING_CART_ERROR = "Ocurrio un error durante el proceso de agregar productos al carrito de compras: ";

    public static final String ORDER_CONFIRMATION = "ORDER CONFIRMATION";
    public static final String TERMS_OF_SERVICE_MESSAGE = "You must agree to the terms of service before continuing.";


}
