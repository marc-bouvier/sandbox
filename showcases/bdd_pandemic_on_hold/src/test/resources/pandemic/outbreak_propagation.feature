Feature: outbreak propagation

  # TODO : écrire la règle
  # Une école : écrire uniquement des "pourquoi"

  # Utilisation du persona "occidental sub-network"
#  Scenario: single outbreak
#    Given the occidental sub-network
#    But Paris infection level is 3
#    When Paris gets infected
#    Then Algiers infection level should be 1
#    And Milan infection level should be 1
#    And Essen infection level should be 1
#    And London infection level should be 1
#    And Madrid infection level should be 1
#
#  Scenario: chain outbreaks
#    Given the occidental sub-network
#    But Paris infection level is 3
#    But London infection level is 3
#    But Essen infection level is 2
#    When Paris gets infected
#    Then London infection level should be 3
#    And Essen infection level should be 3
#    And New York infection level should be 1
#    And Milan infection level should be 1
#    And Algiers infection level should be 1
#    And Madrid infection level should be 1