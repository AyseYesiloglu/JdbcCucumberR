Feature: Soru 4: Database uzerinden bed tablosunda created_at = 2021-10-25 03:34:25
  olan yatagin active oldugunu dogrulayiniz.


  Background: Connection
    * Database baglantisi kurulur.

  Scenario:Bed tablosunda created_at = 2021-10-25 03:34:25
  olan yatagin active oldugunu dogrulayiniz.

    Given Bed tablosuna query gönderilir ve sonuclar dogrulanir.
    Then Database baglantisi kapatilir.
