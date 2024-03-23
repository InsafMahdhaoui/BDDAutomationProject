@search
Feature: Search
  En tant qu un utilisateur je veux avoir la possibilitee de chercher les utilisateur avec userStatus

  Background: 
    Given je me connecte sur l'application
    When je saisi le login "Admin"
    And je saisi le password "admin123"
    And je clique sur le bouton login
    And je me redirige vers la page d'accueil et "Dashboard" s'affiche
    Then je clique sur l element Admin dans le menu

  @searchByUserStatus
  Scenario Outline: Rechercher un utilisateur avec userStatus
    When je clique sur la liste deroulante des userStatus
    And je select le UserStatus "<status>"
    And je clique sur le boutton de recherche
    Then je verifi les status des users affichees "<status>"

    Examples: 
      | status    |
      ##| Enabled  |
      | Disabled |
