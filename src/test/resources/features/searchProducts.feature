Feature: Validate price of product

  @ValidatePriceOfProduct
  Scenario Outline: Validate price of product
    Given estoy en la página principal
    When busco el producto "<producto>"
    Then valido el mensaje "Resultados de búsqueda"
    When selecciono el producto "<producto>"
    Then valido el precio del producto debe ser "<precio>"

    Examples:
      | producto                      | precio  |
      | IPHONE 15 128GB - AZUL (CHIP) | 3799.00 |