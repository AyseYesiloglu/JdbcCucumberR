Feature: Q9

  Scenario Outline:Database uzerinden charge_categories tablosundaki name bilgisi "P" ile baslayan iceriklerin
  charge_type_id numaralarini tekrardan arindirilmis olarak listeleyiniz ve dogrulayiniz. (6 , 7)
    #select distinct charge_type_id from charge_categories where name like 'P%';
    Given Create connection
    Then query is done without repetition according to the starting name with "P%"
    And the query result should match the following <id>
    Then close the connection
    Examples:
      | id |
      | 6  |
      | 7  |
