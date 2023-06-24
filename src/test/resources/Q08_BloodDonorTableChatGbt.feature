Feature: Q8
#Soru 8: Database üzerinden blood_donor tablosundaki id= 7 olan donorun donor_name'i Maria, date_of_birth=2001-03-02,
# gender=Female, father_name=Jhonson, address=England oldugunu dogrulayiniz.
  Scenario Outline: Verify donor information by ID
    Given Create connection
    Given I have the following donor information
      | id   |
      | <id> |
      | <id> |
    Then query the donor information
    And the donor information should match the following
      | id   | donor_name | date_of_birth        | gender | father_name | address                            |
      | <id> | Maria      | 2 Mar 2001 00:00:00  | Female | Jhonson     | England                            |
      | <id> | Jhon       | 28 Ara 1998 00:00:00 | Male   | David       | Main Street, Apt. Central Brooklyn |
    #8	Jhon	28 Ara 1998 00:00:00	Male	David	 Main Street, Apt. Central Brooklyn

    Examples:
      | id |
      | 7  |
      | 8  |
# id=7 olanın bilgileri olarak  {id=7, donor_name=Maria, date_of_birth=2 Mar 2001 00:00:00, gender=Female, father_name=Jhonson, address=England}
  #id=8 olanın bilgileri olarak da {id=8, donor_name=Jhon, date_of_birth=28 Ara 1998 00:00:00, gender=Male, father_name=David, address=Main Street, Apt. Central Brooklyn} bu bilgilerin gelecek şekilde hem feature file'ı hem de step definition sayfasındaki kodları bana hiç bilmeyen birine anlatır gibi anlatabilir misin lütfen

