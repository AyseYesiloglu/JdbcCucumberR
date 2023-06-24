Feature: Soru 2: Database üzerinden appointment_payment tablosunda odeme turu olarak "offline" secenl
  hasta id'lerinin (1,2,3,13,14,15,17,18,20,21,25) oldugunu dogrulayiniz.

  Background: Connection
    * Database baglantisi kurulur.

    #heallife_hospitaltraining.languages bolumunde karsilastirma yapilir
    #  Database üzerinden languages tablosundaki short_code "yi" olan verinin language bilgisinin
    #  "Yiddish" oldugunu dogrulayin.

  Scenario Outline: Database üzerinden appointment_payment tablosunda odeme turu olarak "offline" secenl
  hasta "<id>" lerinin (1,2,3,13,14,15,17,18,20,21,25) oldugunu dogrulayiniz.

    #1,2,3,16,17,18,20,21,24,25,31
    Given Appointment Payment tablosuna query gonderilir ve "<id>" leri dogrulanir.
    Then Database baglantisi kapatilir.
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 16 |
      | 17 |
      | 18 |
      | 20 |
      | 21 |
      | 24 |
      | 25 |
      | 31 |
