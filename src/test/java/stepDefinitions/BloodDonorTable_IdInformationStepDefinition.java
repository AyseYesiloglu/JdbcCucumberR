package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import static utilities.JDBCReusableMethods.getStatement;

public class BloodDonorTable_IdInformationStepDefinition {
    Statement statement;
    ResultSet resultSet;
    List<Object> informationList = new ArrayList<>();
    List<Object> donorInfo = new ArrayList<>();

    @Given("Create connection")
    public void create_connection() {
        JDBCReusableMethods.createConnection();
    }


    @Then("the donor  should match the following")
    public void the_donor_should_match_the_following() {
        //java.sql.Date.valueOf("2001-03-02") tarih formatını alırken dikkat et.
        // Eğer tarih formatında almazsak çıkarma işlemi olarak algılar.

        List<Object> expectedInfo = Arrays.asList(7, "Maria", java.sql.Date.valueOf("2001-03-02"), "Female", "Jhonson", "England");
        Assert.assertTrue(informationList.contains(expectedInfo));
    }

    @Then("close the connection")
    public void close_the_connection() {
        JDBCReusableMethods.closeConnection();
    }


    @Then("query is done with information according to the id is {int}")
    public void queryIsDoneWithInformationAccordingToTheIdIs(int id) throws SQLException {
        //informationList listesine her bir satırı tek bir dize olarak eklememiz gerekmekte.
        // Bu durumda, expectedList'teki elemanlarla aynı şekilde bulunması için tam bir dize eşleşmesi gerekir.
        // Ancak expectedList'teki elemanlar ayrı ayrı eklenmiş objelerdir.
        String query = "SELECT id, donor_name, date_of_birth, gender, father_name, address FROM blood_donor WHERE id = " + id + ";";
        resultSet = getStatement().executeQuery(query);

        while (resultSet.next()) {
            int idValue = resultSet.getInt("id");
            String donorName = resultSet.getString("donor_name");
            Date dateOfBirth = resultSet.getDate("date_of_birth");
            String gender = resultSet.getString("gender");
            String fatherName = resultSet.getString("father_name");
            String address = resultSet.getString("address");

            donorInfo = Arrays.asList(idValue, donorName, dateOfBirth, gender, fatherName, address);
            informationList.add(donorInfo);
        }
        System.out.println(donorInfo);


    }
}
