# Created by marco at 12/02/19
Feature: Infection

  Scenario: first infection
    Given the occidental sub-network
    When Paris gets infected
    Then Paris infection level should be 1

  Scenario: second infection
    Given the occidental sub-network
    But Paris infection level is 1
    When Paris gets infected
    Then Paris infection level should be 2

  Scenario: third infection
    Given the occidental sub-network
    But Paris infection level is 2
    When Paris gets infected
    Then Paris infection level should be 3

  Scenario: fourth infection
    Given the occidental sub-network
    But Paris infection level is 3
    When Paris gets infected
    Then Paris infection level should remain at 3

  # Given : si possible au passé
  # When : présent
  # Then : conditionnel
  # ex.
   # "Given Paris has been infected once"


# Qu'est ce qui va faire que ca peut ne pas marcher?
# * eclosions
# * plus de cubes
# Est-ce toujours vrai?
# Et si on change le contexte?
