@authentification
Feature: Authentification
  En tant qu'un utilisateur je veux m'identifier sur l'application OrangeHRM

  Background: 
    Given je me connecte sur l'application

  @authentificationValide
  Scenario: Authentification avec des coordonees valides
    When je saisi le login "Admin"
    And je saisi le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et "Dashboard" s'affiche

  @authentificationNonValide
  Scenario Outline: Authentification avec des coordonees non valides
    When je saisi le login "<login>"
    And je saisi le password "<password>"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et "<message>" s'affiche

    Examples: 
      | login   | password   | message   |
      | adminnn | admin123   | Dashboard |
      | Admin   | admin12345 | Dashboard |
      | adminis | admin      | Dashboard |
      |         | admin123   | Dashboard |
      | Admin   |            | Dashboard |
      |         |            | Dashboard |
      | Admin   | admin123   | Bonjour   |
