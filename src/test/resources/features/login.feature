Feature: Login

  @LoginSuccess
  Scenario: Login successful
    Given estoy en la página principal
    And me dirijo a inciar sesión
    When escribo el correo "example@example.com"
    And escribo la contraseña "password"
    And presiono el botón "Iniciar sesión"
    Then valido haber iniciado sesión correctamente
