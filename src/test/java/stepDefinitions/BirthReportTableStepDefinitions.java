package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import utilities.Manage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utilities.JDBCReusableMethods.getStatement;

public class BirthReportTableStepDefinitions {
    Statement statement;
    ResultSet resultSet;
    String query;
    Manage manage = new Manage();
    @Given("Create a connection")
    public void create_a_connection() {
      JDBCReusableMethods.createConnection();
    }
    @Then("Create a query for the list of baby's name whose father name is {string} and child_name should be {string}")
    public void create_a_query_for_the_list_of_baby_s_name_whose_father_name_is_and_child_name_should_be(String father_name, String child_name) throws SQLException {
        query = "SELECT child_name from heallife_hospitaltraining.birth_report WHERE father_name='" + father_name + "';";//şimdi deneyin
        resultSet = getStatement().executeQuery(query);
        List<String> nameOfBabys = new ArrayList<>();
        while (resultSet.next()) {
            nameOfBabys.add(resultSet.getString("child_name"));
        }
        Assert.assertTrue(nameOfBabys.contains(child_name));
    }
    @Then("Close connection")
    public void close_connection() {
        JDBCReusableMethods.closeConnection();
    }
}