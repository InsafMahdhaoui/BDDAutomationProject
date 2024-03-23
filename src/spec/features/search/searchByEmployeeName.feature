@Search
Feature: Search
  En tant qu un utilisateur je veux avoir la possibilitee de rechercher un utilisateur avec son employee name

  Background: 
    Given je me connecte sur l'application
    When je saisi le login "Admin"
    And je saisi le password "admin123"
    And je clique sur le bouton login
    And je me redirige vers la page d'accueil et "Dashboard" s'affiche
    Then je clique sur l element Admin dans le menu

  @searchByEmployeeName
  Scenario Outline: Rechercher un utilisateur avec employeeName
    When je saisi le employeeName "<name>"
    And je clique sur le searchButton
    Then je verifi les posts des users affichees "<name>"

    Examples: 
      | name          |
      | MOHAMED AMINE |
