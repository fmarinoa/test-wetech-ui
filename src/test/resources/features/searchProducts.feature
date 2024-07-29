Feature: Validate price of product

  Background:
    Given estoy en la página principal

  @ValidatePriceOfProduct
  Scenario Outline: Validate price of product
    When busco el producto '<producto>'
    Then valido el mensaje "Resultados de búsqueda"
    When selecciono el producto '<producto>'
    Then valido el precio del producto debe ser "<precio>"

    Examples:
      | producto                                               | precio  |
      | IPHONE 15 128GB - AZUL (CHIP)                          | 3799.00 |
      | IPHONE 15 128GB - ROSA (CHIP)                          | 3799.00 |
      | IPHONE 15 PRO 256GB - NATURAL TITANIUM (ESIM)          | 5099.00 |
      | IPHONE 15 PRO MAX 256GB - NATURAL TITANIUM (ESIM)      | 5499.00 |
      | MACBOOK AIR 13" CHIP M2 8GB RAM + 256GB SSD - MIDNIGHT | 4699.00 |