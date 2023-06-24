Feature: Database üzerinden appointment tablosundaki patient_id = 20
  olan hastanin canli muayene isteginin acik oldugunu dogrulayiniz.
  Background: Connection
    * Database baglantisi kurulur.
  Scenario:
    Then appointment table icin query hazirlanir
    And  appointment table icin query calistirili ve sonuclari alinir
    And  appointment table icin query sonuclari dogrulanir
    Then baglantisi kapatilir.