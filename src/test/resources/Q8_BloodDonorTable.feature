Feature: Q8 blood_donor table

    #Soru 8: Database üzerinden blood_donor tablosundaki id= 7 olan donorun donor_name'i Maria, date_of_birth=2001-03-02, gender=Female, father_name=Jhonson, address=England oldugunu dogrulayiniz.
    #select id,donor_name,date_of_birth,gender, father_name, address from blood_donor where id=7;
  Scenario: Verify donor information by ID
    Given Create connection
    Then query is done with information according to the id is 7
    And the donor  should match the following
    Then close the connection



    #7	Maria	2 Mar 2001 00:00:00	Female	Jhonson	England
