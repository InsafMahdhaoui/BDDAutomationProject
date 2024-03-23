@logout
Feature: logout
  En tant qu un utilisateur je veux avoir la possibilitee de se connecter de l application

  Background: 
    Given je me connecte sur l'application
    When je saisi le login "Admin"
    And je saisi le password "admin123"
    And je clique sur le bouton login
    And je me redirige vers la page d'accueil et "Dashboard" s'affiche

  @logout
  Scenario: Se deconnecter de l application
    When cliquer sur l element de nom d utilisateur
    And je select l item Log Out
    Then je verifi je me redirige vers la page d authentification et le mot "Login" s affiche
