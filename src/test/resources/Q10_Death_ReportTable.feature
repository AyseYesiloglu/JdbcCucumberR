Feature: Q10

  Scenario Outline: Soru 10: Database üzerinden death_report tablosundaki ölüm tarihlerine göre en son ölen hastanin
  guardian_name bilgisinin Kane Stark oldugunu dogrulayiniz.
     #SELECT guardian_name FROM death_report ORDER BY death_date DESC LIMIT 1;
    Given Create connection
    Then query is done according to the date of death
    And the query result should match the following "<guardian_name>"
    Then close the connection

    Examples:
      | guardian_name |
      | Kane Stark    |

