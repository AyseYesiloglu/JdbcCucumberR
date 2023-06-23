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

    @Given("Create connection")
    public void create_connection() {
        JDBCReusableMethods.createConnection();
    }

    @Then("query the donor id is id, donor name is {string}, date of birth is {int} Mar {int} {int}:{int}:{int}, gender is {string}, father name is {string} and address is {string} information")
    public void query_the_donor_id_is_id_donor_name_is_date_of_birth_is_mar_gender_is_father_name_is_and_address_is_information(String donor_name, Integer id, Integer date_of_birth, String gender, String father_name, String address) throws SQLException {

        //   | id |  donor_name | date_of_birth       | gender | father_name | address |
        //      | id |  Maria      | 2 Mar 2001 00:00:00 | Female | Jhonson     | England |


    }

    @Then("the donor  should match the following")
    public void the_donor_should_match_the_following() {


    }

    @Then("close the connection")
    public void close_the_connection() {
        JDBCReusableMethods.closeConnection();
    }


    @Then("query is done with information according to the id is {int}")
    public void queryIsDoneWithInformationAccordingToTheIdIs(int id) throws SQLException {

        //   String query="select id,donor_name,date_of_birth,gender, father_name, address from blood_donor where id="+id+";";
        //   resultSet=getStatement().executeQuery(query);
        //   List<Object>informationList=new ArrayList<>();
        //   while(resultSet.next()){
        //       informationList.add(resultSet.getInt("id")+", "+resultSet.getString("donor_name")+", "+resultSet.getDate("date_of_birth")+", "+resultSet.getString("gender")+", "+resultSet.getString("father_name")+ ", "+resultSet.getString("address"));

        //   }
        //   System.out.println(informationList);

        //  //List<Object>expectedList= Arrays.asList(7," Maria", 2001-03-02," Female"," Jhonson", "England");
        //   //tarihi çıkarma işlemi olarak algıladığı için 1996 olarak döndürüyor
        //  ////7, Maria, 2001-03-02, Female, Jhonson, England
        //  //Assert.assertEquals(expectedList,informationList);
        //   List<Object> expectedList = Arrays.asList(7, "Maria", java.sql.Date.valueOf("2001-03-02"), "Female", "Jhonson", "England");
        // Assert.assertTrue(informationList.contains(expectedList));

        String query = "SELECT id, donor_name, date_of_birth, gender, father_name, address FROM blood_donor WHERE id = " + id + ";";
        resultSet = getStatement().executeQuery(query);
        List<Object> informationList = new ArrayList<>();
        List<Object> donorInfo = new ArrayList<>();
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

        List<Object> expectedInfo = Arrays.asList(7, "Maria", java.sql.Date.valueOf("2001-03-02"), "Female", "Jhonson", "England");
        Assert.assertTrue(informationList.contains(expectedInfo));

    }
}
