# language: es
@FeatureName:carritoDeCompras
Característica: Carrito de Compras
  Como cliente en linea en la pagina Web Automation Practice
  Quiero poder agregar un producto al carrito de compras
  para poder comprarlo en el sitio web

  @ScenarioName:comprarUnArticulo
  Escenario: ordenar la compra de un articulo
    Dado que el cliente ingresa al home principal de Automation Practice
    Cuando el cliente ingresa a la sección de vestidos, selecciona un articulo y lo agrega al carrito de compras
    Entonces el cliente visualizará un mensaje de confirmación de la orden de compra