Feature: Bed Table

  Background: Connection
    * Database baglantisi kurulur.

  Scenario:Q4-Bed tablosunda created_at = 2021-10-25 03:34:25
  olan yatagin active oldugunu dogrulayiniz.

    Given Bed tablosuna query gönderilir ve sonuclar dogrulanir.
    Then Database baglantisi kapatilir.

  Scenario Outline: Q5-Database üzerinden verilen bed tablosundaki name,bed_group_id ve name'lerini verilenlerle dogrulayiniz.
  Database üzerinden bed tablosunda bed group id'si 4 ve is_active= "no" olan hastanin name bilgisinin 105 oldugunu dogrulayiniz.
    #SELECT name FROM heallife_hospitaltraining.bed WHERE bed_group_id = 4 AND is_active = 'no';"

    Given Bed tablosunda  <bed_group_id>  bilgisine ve "<is_active>" bilgisine göre "<name>" bilgisi sorgulanir ve sonuclar dogrulanir.

    Examples:
      | name | bed_group_id | is_active |
      | 105  | 4            | no        |










