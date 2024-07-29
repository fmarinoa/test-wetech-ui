Feature: Add to shopping cart

  Background:
    Given estoy en la página principal

  @AddShoppingCart
  Scenario Outline: Add to shopping cart and validate price
    When busco el producto '<producto>'
    Then valido el mensaje "Resultados de búsqueda"
    When selecciono el producto '<producto>'
    And capturo el precio de una unidad
    And agrego "<unidades>" unidades al carrito
    Then valido que el precio de los productos correspondan en el carrito

    Examples:
      | producto                      | unidades |
      | IPHONE 15 128GB - AZUL (CHIP) | 2        |