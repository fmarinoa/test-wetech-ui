@Login
Feature: Login

  @LoginSuccessful
  Scenario Outline: Login successful
    Given estoy en la página principal
    And me dirijo a inciar sesión
    When escribo el correo "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón "Iniciar sesión"
    Then valido haber iniciado sesión correctamente

    Examples:
      | user             | pass    |
      | test@example.com | Test123 |

  @LoginUnsuccessful
  Scenario Outline: Login unsuccessful
    Given estoy en la página principal
    And me dirijo a inciar sesión
    When escribo el correo "<user>"
    And escribo la contraseña "<pass>"
    And presiono el botón "Iniciar sesión"
    Then valido el mensaje "Correo electrónico o contraseña incorrectos."

    Examples:
      | user | pass |
      | test | test |