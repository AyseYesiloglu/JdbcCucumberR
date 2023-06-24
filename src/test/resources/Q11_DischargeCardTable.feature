Feature: Q11

  Scenario: Soru 11: Database üzerinden discharge_card tablosundaki opd_details_id'si 11 ile 31 arasindaki
  (11 ve 31 haric) verlerin created_at bilgilerini dogrulayiniz.
    #select created_at from discharge_card where opd_details_id >11 and opd_details_id<31;
    Given Create connection
    Then query is done according to the opd_details_id
    And the query result should be match based on created_at
    Then close the connection

