@search
Feature: Search
  En tant qu un utilisateur je veux avoir la possibilitee de chercher un utilisateur avec un username

  Background: 
    Given je me connecte sur l'application
    When je saisi le login "Admin"
    And je saisi le password "admin123"
    And je clique sur le bouton login
    Then je me redirige vers la page d'accueil et "Dashboard" s'affiche

  @searchByUserName
  Scenario Outline: Rechercher un utilisateur avec username
    When je clique sur l element Admin dans le menu
    And je saisi le userName "<username>"
    And je clique sur le boutton Search
    Then je verifi le tableau affichee "<username>"

    Examples: 
      | username |
      | admin    |
