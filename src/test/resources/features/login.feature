Feature: Login

  @LoginSuccess
  Scenario Outline: Login successful
    Given estoy en la página principal
    And me dirijo a inciar sesión
    When escribo el correo "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón "Iniciar sesión"
    Then valido haber iniciado sesión correctamente

    Examples:
      | user | pass |
      | user | pass |