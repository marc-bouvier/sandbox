# Persona / standard pour éviter de répéter tout le temps le contexte standard
# Le faire neutre et pouvoir le surcharger
  # Eviter de faire trop de standards / personas
Feature: standard definition

  Scenario: occidental sub-network
    Given the occidental sub-network
    Then NewYork should be linked to London, Madrid
    And Paris should be linked to Algiers, Milan, Essen, London, Madrid
    And Paris infection level should be 0
    And NewYork infection level should be 0
    And London infection level should be 0
    And Algiers infection level should be 0
    And Milan infection level should be 0
    And Essen infection level should be 0
    And Madrid infection level should be 0

#  Scenario: occidental sub-network
#    Given the occidental subnetwork
#    Then network should be
#      ||
