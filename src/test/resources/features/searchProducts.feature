Feature: Validate price of product

  Background:
    Given estoy en la página principal

  @ValidatePriceOfProduct
  Scenario Outline: Validate price of product
    When busco el producto "<producto>"
    Then valido el mensaje "Resultados de búsqueda"
    When selecciono el producto "<producto>"
    Then valido el precio del producto debe ser "<precio>"

    Examples:
      | producto                                      | precio  |
      | IPHONE 15 128GB - AZUL (CHIP)                 | 3799.00 |
      | IPHONE 15 PRO 256GB - NATURAL TITANIUM (ESIM) | 5099.00 |
