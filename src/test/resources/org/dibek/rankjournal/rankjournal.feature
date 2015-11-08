Feature: In order to highlight the journals which have the biggest impact in a given year As a user I want to be able to see journals ordered by their score across a range of years. If two or more journals have the same score they should be assigned the same rank, ordering within a rank should be done alphabetically on the journal’s name.

  Scenario: Rank journals 2015

    Given the following journals have scores for 2015:
      | name      | score |
      | Journal A | 5.6   |
      | Journal B | 2.4   |
      | Journal C | 3.1   |
    When the user views the ranked journals
    Then the order and rank should be:
      | rank | name      | score |
      | 1    | Journal A | 5.6   |
      | 2    | Journal C | 3.1   |
      | 3    | Journal B | 2.4   |


  Scenario: Rank journals with a shared rank

    Given the following journals have scores for 2014:
      | name      | score |
      | Journal A | 2.2   |
      | Journal B | 6.2   |
      | Journal C | 6.2   |
    When the user views the ranked journals
    Then the order should be determined by score then journal name:
      | rank | name      | score |
      | 1    | Journal B | 6.2   |
      | 1    | Journal C | 6.2   |
      | 3    | Journal A | 2.2   |


  Scenario: Rank journals excluding review journals
    Given the following journals have scores for 2013:
      | name      | score |
      | Journal A | 5.6   |
      | Journal B | 2.4   |
      | Journal C | 3.1   |
    And "Journal A" is a review journal
    When the journals are ranked
    Then the order should be:
      | rank | name       | score |
      | 1    | Journal C  | 3.1   |
      | 2    | Journal B | 2.4   |