Feature: Q12
  Scenario:Database üzerinden doctor_shift tablosunda staff_id=2 olan doctorun
  sali gunu kac saat calistigini dogrulayiniz.(2)
    #SELECT sum(TIMESTAMPDIFF(HOUR, start_time, end_time)) AS total_hours FROM doctor_shift WHERE staff_id = 2 AND day='Tuesday';
    Given Create connection
    Then query is done according to the how much time work hours of doctor on "Tuesday"
    And the query result should be match based on total_hours
    Then close the connection