package stepDefinitions;

public class Knowledge {

    /*
    timestamp türünde verilen bir veriyi aşağıdaki şekilde oluşturabilirsin ama önce class level'de
    Timestamp timestamp;
    Timestamp timestamp1;
    Timestamp timestamp2;----->şeklinde obje oluşturmayı unutma
    timestamp1=Timestamp.valueOf("2021-10-28 04:48:56");
     */

    /*
    List<Object> expectedInfo = Arrays.asList(7, "Maria", java.sql.Date.valueOf("2001-03-02"), "Female", "Jhonson", "England");
    java.sql.Date.valueOf("2001-03-02") tarih formatını alırken dikkat et.
    Eğer tarih formatında almazsak çıkarma işlemi olarak algılar
    burda list'verileri teker teker eklediğimiz için karşılaştırma yapmak için
    sql sorgusuyla elde edeceğim verileri de oluşturacağımız list'e de aşağıdaki gibi teker teker eklememeiz gerekir.
    List<Object> informationList = new ArrayList<>();
    List<Object> donorInfo = new ArrayList<>();
      while (resultSet.next()) {
      int idValue = resultSet.getInt("id");
      String donorName = resultSet.getString("donor_name");
      Date dateOfBirth = resultSet.getDate("date_of_birth");
      String gender = resultSet.getString("gender");
      String fatherName = resultSet.getString("father_name");
      String address = resultSet.getString("addre
      donorInfo = Arrays.asList(idValue, donorName, dateOfBirth, gender, fatherName, address);
      informationList.add(donorInfo);
        }
     */
}
