# language: es
@FeatureName:contactoConLaEmpresa
Característica: Contacto con la Empresa
  Yo como interesado en los productos que ofrece la pagina web Automation Practice
  Quiero poder contactarme con la empresa de forma virtual
  Para recibir información útil sobre sus productos y servicios

  @ScenarioName:contactoConSitioWeb
  Escenario: contacto con el Sitio Web
    Dado que el cliente ingresa al Home de Automation Practice
    Cuando el cliente ingresa a la sección Contact Us y llena el formulario
    Entonces el cliente visualizará un mensaje de confirmación de envio de la solicitud