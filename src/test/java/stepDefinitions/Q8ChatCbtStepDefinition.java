package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q8ChatCbtStepDefinition {


    Statement statement;
    ResultSet resultSet;
    Map<Object, Object> donorInformation;

    @Given("I have the following donor information")
    public void ı_have_the_following_donor_information(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String id = data.get(0).get("id");

        // Sorgu oluşturma işlemleri
        String query = "SELECT id, donor_name, date_of_birth, gender, father_name, address FROM blood_donor WHERE id = " + id+";";
        // Diğer işlemler
    }

    @Then("query the donor information")
    public void query_the_donor_information() throws SQLException {
     // donorInformation = new HashMap<>();
     // donorInformation.put("id", resultSet.getInt("id"));
     // donorInformation.put("donor_name", resultSet.getString("donor_name"));
     // donorInformation.put("date_of_birth", resultSet.getDate("date_of_birth"));
     // donorInformation.put("gender", resultSet.getString("gender"));
     // donorInformation.put("father_name", resultSet.getString("father_name"));
     // donorInformation.put("address", resultSet.getString("address"));
    }

    @Then("the donor information should match the following")
    public void the_donor_information_should_match_the_following(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedData = dataTable.asMaps(String.class, String.class);
        Map<String, String> expectedInformation = expectedData.get(0);

        // İlk önce dataTable adında bir DataTable nesnesi oluşturuyoruz. Bu DataTable, senaryo adımlarında verilen tablodaki verileri temsil eder.
        //asMaps(String.class, String.class) metodu, DataTable nesnesini List<Map<String, String>> türüne dönüştürür. Bu dönüşüm, her satırı bir harita olarak temsil eder. Her harita, sütun adını (anahtar) ve değeri içerir. Bu şekilde, senaryo adımındaki tablodaki verileri kolayca erişebiliriz.
        //expectedData.get(0) ifadesi, expectedData listesindeki ilk haritayı (ilk satırı) alır. Bu haritada, sütun adlarına göre eşleşen değerlere erişebiliriz.

        // Karşılaştırma işlemleri
        String expectedId = expectedInformation.get("id");
        String expectedDonorName = expectedInformation.get("donor_name");

        // Diğer beklenen değerlerin alınması
        System.out.println(expectedInformation);
        // Sorgudan dönen sonuçlarla beklenen değerlerin karşılaştırılması
       // Assert.assertEquals(expectedId, donorInformation.get("id"));
       // Assert.assertEquals(expectedDonorName, donorInformation.get("donor_name"));
        // Diğer karşılaştırmalar
    }

}
