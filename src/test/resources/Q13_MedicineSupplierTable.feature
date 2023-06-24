Feature: Q13

  Scenario:Database üzerinden medicine_supplier tablosundaki address bilgisi "Andheri, Mumbai"
  olan verinin diger bilgilerinin dogru oldugunu kontrol ediniz.
    #select * from heallife_hospitaltraining.medicine_supplier where address='Andheri, Mumbai';
    Given Create connection
    Then query is created according to given adress is "Andheri, Mumbai"
    And the query result should be match based on knowledge
    Then close the connection