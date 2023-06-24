Feature: Q7
  Scenario Outline: Birth_report tablosundan kardes olan bebeklerin isimlerini listeleyip, dogrulayiniz
    Given Create a connection
    Then  Create a query for the list of baby's name whose father name is "Mahesh" and child_name should be "<child_name>"
    Then  Close connection
    Examples:
      |child_name  |
      |Rohit       |
      |Reyana      |
      |child       |