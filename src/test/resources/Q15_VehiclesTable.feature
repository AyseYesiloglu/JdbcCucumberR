Feature: Q15
  Scenario: Database uzerinden vehicles tablosundaki araclarin manufacture_year bilgisine gore en
  eskiden yeniye listelendiginde ve created_at bilgisine gorede eskiden yeniye siralanip
  listelendiginde iki listede de ayni indexte yer alan arac oldugunu dogrulayiniz.
    Given Create connection
    Then Create two query one with in ascending order of manufacture_year and one with ascending order of created_at
    Then Cross check the queries and find the vehicle with common index on both
    Then Close connection