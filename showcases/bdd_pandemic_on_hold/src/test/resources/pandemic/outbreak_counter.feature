# Created by marco at 12/02/19
Feature: outbreak counter
  # Enter feature description here

#  Scenario: single outbreak
#    Given Paris infection level is 3
#    And outbreak counter is 0
#    When Paris gets infected
#    Then outbreak counter should be 1

  # hook pour utiliser la persona
  Scenario: single outbreak
    Given the occidental sub-network
    But Paris infection level is 3
    And outbreak counter is 0
    When Paris gets infected
    Then outbreak counter should be 1

    # Ici pour partir de 7 on pourrait injecter le compteur
  Scenario: final outbreak
    Given the occidental sub-network
    But Paris infection level is 3
    And outbreak counter is 7
    When Paris gets infected
    Then outbreak counter should be 8
    And the game should be lost
