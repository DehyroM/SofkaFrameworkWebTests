# language: es
@FeatureName:carritoDeCompras
Característica: Carrito de Compras
  Como cliente en linea en la pagina Web Automation Practice
  Quiero poder agregar un producto al carrito de compras
  para poder comprarlo en el sitio web

  Antecedentes:
    Dado que el cliente ingresa al home principal de Automation Practice

  @ScenarioName:ordenarCompraDeUnArticulo
  Escenario: ordenar la compra de un articulo
    Cuando el cliente ingresa a la sección de vestidos, selecciona un articulo y lo agrega al carrito de compras
    Entonces el cliente visualizará un mensaje de confirmación de la orden de compra

  @ScenarioName:ordenarCompraDeUnArticuloSinAceptarTerminos
  Escenario: ordenar un articulo sin aceptar terminos del servicio
    Cuando el cliente ingresa a la sección WOMEN, agrega dos articulos al carrito de compras sin checkear los términos y condiciones
    Entonces el cliente visualizará un mensaje indicando que se deben aceptar los términos del servicio