@search
Feature: Search
  En tant qu un utilisateur je veux avoir la possibilitee de chercher les utilisateur avec userRole

  Background: 
    Given je me connecte sur l'application
    When je saisi le login "Admin"
    And je saisi le password "admin123"
    And je clique sur le bouton login
    And je me redirige vers la page d'accueil et "Dashboard" s'affiche
    Then je clique sur l element Admin dans le menu

  @searchByUserRole
  Scenario Outline: Rechercher un utilisateur avec userRole
    When je clique sur la liste deroulante des userRole
    And je select le UserRole "<role>"
    And je clique sur le boutton rechercher
    Then je verifi les roles des users affichees "<role>"

    Examples: 
      | role  |
      | Admin |
      ##| ESS   |
