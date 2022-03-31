# language: es
@FeatureName:contactoConLaEmpresa
Característica: Contacto con la Empresa
  Yo como interesado en los productos que ofrece la pagina web Automation Practice
  Quiero poder contactarme con la empresa de forma virtual
  Para recibir información útil sobre sus productos y servicios

  Antecedentes:
    Dado que el cliente ingresa al Home de Automation Practice

  @ScenarioName:llenadoFormularioDeContacto
  Escenario: llenado de formulario obligatorio para Contacto
    Cuando el cliente ingresa a la sección Contact Us y llena los campos obligatorios del formulario
    Entonces el cliente visualizará un mensaje de confirmación de envio de la solicitud